package dev.codenmore.tilegame;

import dev.codenmore.tilegame.gfx.GameCamera;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.overlays.HUD;
import dev.codenmore.tilegame.overlays.Instructions;
import dev.codenmore.tilegame.overlays.PauseMenu;
import dev.codenmore.tilegame.states.GameState;
import dev.codenmore.tilegame.states.MapCreatorState;
import dev.codenmore.tilegame.states.MenuState;
import dev.codenmore.tilegame.states.gamestates.PokemonCenterState;
import dev.codenmore.tilegame.states.gamestates.WorldState;
import dev.codenmore.tilegame.states.menustates.MainMenu;
import dev.codenmore.tilegame.states.menustates.PlayMenu;
import dev.codenmore.tilegame.worlds.World;

public class Handler {
	
	private Game game;
	private World world;

	public Handler(Game game){
		this.game = game;
	}
	
	public void resetGame(){
		game.resetGame();
	}
	
	public MapCreatorState getMapCreatorState(){
		return game.getMapCreatorState();
	}
	
	public Instructions getInstructions(){
		return game.getInstructions();
	}
	
	public MainMenu getMainMenu(){
		return game.getMainMenu();
	}
	
	public PlayMenu getPlayMenu(){
		return game.getPlayMenu();
	}
	
	public MenuState getMenuState(){
		return game.getMenuState();
	}
	
	public HUD getHUD(){
		return game.getHUD();
	}
	
	public PauseMenu getPauseMenu(){
		return game.getPauseMenu();
	}
	
	public GameState getGameState(){
		return game.getGameState();
	}
	
	public WorldState getWorldState(){
		return game.getWorldState();
	}
	
	public PokemonCenterState getPokemonCenterState(){
		return game.getPokemonCenterState();
	}
	
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return game.getWorldState().getWorld();
	}

	public void setWorld(World world) {
		this.world = world;
	}
}
