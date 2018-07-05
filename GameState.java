package dev.codenmore.tilegame.states;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.creatures.Computer;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.overlays.Overlay;
import dev.codenmore.tilegame.utils.Utils;
import dev.codenmore.tilegame.worlds.World;



public class GameState extends State {
	
	private static GameState currentState = null;
	
	public static void setState(GameState gameState){
		currentState = gameState;
	}
	
	public static State getState(){
		return currentState;
	}
	
	private Player player;
	private ArrayList <Computer> npcs = new ArrayList<Computer>();
	private Computer computer;
	private boolean newGame;
	private int spawnX, spawnY;
	
	public GameState(Handler handler){
		super(handler);
		//computer = new Computer(game, Tile.TILEWIDTH, Tile.TILEHEIGHT + 1);
	}
	
	public void init(){
		spawnX = handler.getWorldState().getWorld().getSpawnX();
		spawnY = handler.getWorldState().getWorld().getSpawnY();
		if(newGame == false){
			loadGame("res/saves/saveOne.txt");
		}
		player = new Player(handler, spawnX, spawnY);
	}
	
	public void setAttack(int x, int y){
		if(x + y < (handler.getHeight() + handler.getWidth()) / 2 && x < y * 16 / 9)
			player.setAttackLeft(true);
		if(x + y > (handler.getHeight() + handler.getWidth()) / 2 && x > y * 16 / 9)
			player.setAttackRight(true);
		if(x + y < (handler.getHeight() + handler.getWidth()) / 2 && x > y * 16 / 9)
			player.setAttackUp(true);
		if(x + y > (handler.getHeight() + handler.getWidth()) / 2 && x < y * 16 / 9)
			player.setAttackDown(true);
	}
	
	@Override
	public void tick() {
		if(!Overlay.getOverlay().equals(handler.getPauseMenu())){
			currentState.tick();
			if(player != null)
				player.tick();
			for(int x = 0; x < npcs.size(); x++){
				npcs.get(x).tick();
			}
			
			if(handler.getKeyManager().escape){
				try {
					Thread.sleep(130);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				handler.getKeyManager().escape = false;
				Overlay.setOverlay(handler.getPauseMenu());
			}
		}
		Overlay.getOverlay().tick();
	}

	@Override
	public void render(Graphics g) {
		currentState.renderBackground(g);
		currentState.renderMain(g);
		for(int x = 0; x < npcs.size(); x++){
			npcs.get(x).render(g);
		}
		player.render(g);
		currentState.renderTop(g);
		Overlay.getOverlay().render(g);
	}
	
	public void saveGame(){
		BufferedWriter writer = null;
		int world = 0;
		if(GameState.getState().equals(handler.getWorldState()))
			world = 0;
		else if(GameState.getState().equals(handler.getPokemonCenterState()))
			world = 1;
		String save = (int) player.getX() + " " + (int) player.getY() + " " + world + " " + handler.getWorldState().getXLast() + " " + handler.getWorldState().getYLast();
		File temp = new File("res/saves/saveOne.txt");
		try {
			writer = new BufferedWriter(new FileWriter(temp));
			writer.write(save);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			writer.close();
		} catch (IOException e) {
		}
	}
	
	public void loadGame(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		
		spawnX = Utils.parseInt(tokens[0]);
		spawnY = Utils.parseInt(tokens[1]);
		int world = Utils.parseInt(tokens[2]);
		handler.getWorldState().setXLast(Utils.parseInt(tokens[3]));
		handler.getWorldState().setYLast(Utils.parseInt(tokens[4]));
		
		
		if(world == 0)
			GameState.setState(handler.getWorldState());
		else if(world == 1)
			GameState.setState(handler.getPokemonCenterState());
		handler.setWorld(GameState.getState().getWorld());
	}
	
	public void loadNpcs(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		int width = Utils.parseInt(tokens[0]);
		int height = Utils.parseInt(tokens[1]);
		int numOfNpcs = Utils.parseInt(tokens[4]);
		int[] moves = new int[0];
		int num = 0;
		
		for(int x = 0; x < numOfNpcs; x++){
			int NpcX = Utils.parseInt(tokens[(width * height + 6) + x * (4 + Utils.parseInt(tokens[width * height + 8]))]);
			int NpcY = Utils.parseInt(tokens[(width * height + 7) + x * (4 + Utils.parseInt(tokens[width * height + 8]))]);
			moves = new int[Utils.parseInt(tokens[(width * height + 8) + x * (4 + Utils.parseInt(tokens[width * height + 8]))])];
			//System.out.println(moves.length);
			for(int y = 0; y < Utils.parseInt(tokens[width * height + 8 + num]); y++){
				moves[y] = Utils.parseInt(tokens[width * height + 9 + y + num]);
			}
			num += moves.length + 4;
			npcs.add(computer = new Computer(handler, NpcX, NpcY, moves));
		}
	}
	
	public void setNewGame(boolean a){
		newGame = a;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(State.getState().equals(handler.getGameState()) && Overlay.getOverlay().equals(handler.getHUD()))
			handler.getGameState().setAttack(e.getX(), e.getY());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renderMain(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renderBackground(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renderTop(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public World getWorld() {
		return currentState.getWorld();
	}
	
	public Player getPlayer(){
		return player;
	}
}
