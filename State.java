package dev.codenmore.tilegame.states;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.worlds.World;


public abstract class State implements MouseListener, MouseMotionListener{

	private static State currentState = null;
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
	//CLASS
	
	protected Handler handler;
	
	public State(Handler handler){
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void renderMain(Graphics g);

	public abstract void renderBackground(Graphics g);
	
	public abstract void renderTop(Graphics g);
	
	public abstract World getWorld();
	
}
