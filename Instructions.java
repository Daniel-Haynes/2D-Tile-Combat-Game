package dev.codenmore.tilegame.overlays;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;

public class Instructions extends Overlay{
	
	private int mx, my;

	public Instructions(Handler handler) {
		super(handler);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		if(mouseOver(972, 579, 183, 75))
			g.drawImage(Assets.instructionsH, 0, 0, handler.getWidth(), handler.getHeight(), null);
		else
			g.drawImage(Assets.instructions, 0, 0, handler.getWidth(), handler.getHeight(), null);
	}
	
	private boolean mouseOver(int x, int y, int width, int height){
		if(mx > x && mx < x + width){
			if(my > y && my < y + height){
				return true;
			}
		}
		return false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		if(Overlay.getOverlay().equals(this))
			if(mouseOver(972, 579, 183, 75))
				Overlay.setOverlay(handler.getHUD());
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
		mx = e.getX();
		my = e.getY();
	}

}
