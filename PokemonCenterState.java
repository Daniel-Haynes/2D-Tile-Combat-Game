package dev.codenmore.tilegame.states.gamestates;

import java.awt.Graphics;
import java.io.File;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.states.GameState;
import dev.codenmore.tilegame.worlds.World;

public class PokemonCenterState extends GameState{
	
	private World world;

	public PokemonCenterState(Handler handler) {
		super(handler);
		File file = new File("res/worlds/test.txt");
		String path = file.getAbsoluteFile().getParentFile().getAbsolutePath();
		world = new World(handler, path + "/pokemonCenter1.txt");
	}
	
	public void tick(){
		
	}
	
	public void renderMain(Graphics g){
		world.render(g);
	}
	
	public void renderBackground(Graphics g){
		world.renderBackground(g);
	}
	
	public void renderTop(Graphics g){
		world.renderTop(g);
	}
	
	public World getWorld(){
		return world;
	}

}
