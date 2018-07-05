package dev.codenmore.tilegame.states;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.worlds.World;

public class MenuState extends State{
	
	private static MenuState currentState = null;
	
	public static void setState(MenuState menuState){
		currentState = menuState;
	}
	
	public static State getState(){
		return currentState;
	}
	
	protected int mx, my;

	public MenuState(Handler handler){
		super(handler);
	}

	@Override
	public void tick() {
		currentState.tick();
	}

	@Override
	public void render(Graphics g) {
		currentState.render(g);
	}
	
	public boolean mouseOver(int x, int y, int width, int height){
		if(mx > x && mx < x + width){
			if(my > y && my < y + height){
				return true;
			}
		}
		return false;
	}
	
	public void mouseMoved(MouseEvent e){
		currentState.mouseMoved(e);
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		currentState.mousePressed(e);
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseDragged(MouseEvent e) {
		
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
		return null;
	}
}
