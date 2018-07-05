package dev.codenmore.tilegame.states.gamestates;

import java.awt.Graphics;
import java.io.File;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.states.GameState;
import dev.codenmore.tilegame.worlds.World;

public class WorldState extends GameState{
	
	private World world;
	private int xLast, yLast;

	public WorldState(Handler handler) {
		super(handler);
		File file = new File("res/worlds/test.txt");
		String path = file.getAbsoluteFile().getParentFile().getAbsolutePath();
		System.out.println(path);
		world = new World(handler, path + "/newWorld.txt");
	}
	
	public void tick(){
		world.tick();
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
	
	public void setXLast(int x){
		xLast = x;
	}
	
	public void setYLast(int y){
		yLast = y;
	}
	
	public int getXLast(){
		return xLast;
	}
	
	public int getYLast(){
		return yLast;
	}
}
