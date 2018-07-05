package dev.codenmore.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.GameCamera;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.overlays.HUD;
import dev.codenmore.tilegame.overlays.Instructions;
import dev.codenmore.tilegame.overlays.Overlay;
import dev.codenmore.tilegame.overlays.PauseMenu;
import dev.codenmore.tilegame.states.GameState;
import dev.codenmore.tilegame.states.MapCreatorState;
import dev.codenmore.tilegame.states.MenuState;
import dev.codenmore.tilegame.states.State;
import dev.codenmore.tilegame.states.gamestates.PokemonCenterState;
import dev.codenmore.tilegame.states.gamestates.WorldState;
import dev.codenmore.tilegame.states.menustates.MainMenu;
import dev.codenmore.tilegame.states.menustates.PlayMenu;

public class Game implements Runnable {

	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//Overlays
	private HUD hud;
	private Instructions instructions;
	private PauseMenu pauseMenu;
	
	//States
	private GameState gameState;
	private MenuState menuState;
	private MapCreatorState mapCreatorState;
	private WorldState worldState;
	private PokemonCenterState pokemonCenterState;
	private MainMenu mainMenu;
	private PlayMenu playMenu;
	
	//Input
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	private void init(){
		display = new Display(this, title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		mapCreatorState = new MapCreatorState(handler);
		worldState = new WorldState(handler);
		pokemonCenterState = new PokemonCenterState(handler);
		hud = new HUD(handler);
		instructions = new Instructions(handler);
		pauseMenu = new PauseMenu(handler);
		mainMenu = new MainMenu(handler);
		playMenu = new PlayMenu(handler);
		GameState.setState(worldState);
		MenuState.setState(mainMenu);
		State.setState(menuState);
		Overlay.setOverlay(instructions);
		
		display.getCanvas().addMouseListener(gameState);
		display.getCanvas().addMouseMotionListener(gameState);
		display.getCanvas().addMouseListener(menuState);
		display.getCanvas().addMouseMotionListener(menuState);
		display.getCanvas().addMouseListener(mapCreatorState);
		display.getCanvas().addMouseMotionListener(mapCreatorState);
		display.getCanvas().addMouseListener(instructions);
		display.getCanvas().addMouseMotionListener(instructions);
		display.getCanvas().addMouseListener(pauseMenu);
		display.getCanvas().addMouseMotionListener(pauseMenu);
	}

	private void tick(){
		keyManager.tick();
		
		if(State.getState() != null){
			State.getState().tick();
		}
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
		
		//System.out.println(20 + 60 + 60 + 20 + 15 + 45 + 30 + 60 + 60 + 30 + 90 + 90 + 30 + 45 + 30 + 30 + 30 + 20 + 30 + 90 + 90 + 30 + 30 + 30 + 30 + 30 + 90 + 30 + 30 + 90 + 30 + 45 + 30 + 30 + 30 + 20);
		
		if(State.getState() != null){
			State.getState().render(g);
		}
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	public void resetGame(){
		worldState = null;
		worldState = new WorldState(handler);
		GameState.setState(worldState);
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public GameState getGameState(){
		return gameState;
	}
	
	public MenuState getMenuState() {
		return menuState;
	}
	
	public MapCreatorState getMapCreatorState(){
		return mapCreatorState;
	}
	
	public WorldState getWorldState(){
		return worldState;
	}
	
	public PokemonCenterState getPokemonCenterState(){
		return pokemonCenterState;
	}
	
	public Instructions getInstructions(){
		return instructions;
	}
	
	public HUD getHUD(){
		return hud;
	}
	
	public PauseMenu getPauseMenu(){
		return pauseMenu;
	}
	
	public MainMenu getMainMenu(){
		return mainMenu;
	}
	
	public PlayMenu getPlayMenu(){
		return playMenu;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
