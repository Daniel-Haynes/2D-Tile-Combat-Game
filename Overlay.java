package dev.codenmore.tilegame.overlays;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;

public abstract class Overlay implements MouseListener, MouseMotionListener{
	
	public static Overlay currentOverlay = null;
	
	public static void setOverlay(Overlay overlay){
		currentOverlay = overlay;
	}
	
	public static Overlay getOverlay(){
		return currentOverlay;
	}
	
	//CLASS
	
	protected Handler handler;
	
	public Overlay(Handler handler){
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

}
