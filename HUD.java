package dev.codenmore.tilegame.overlays;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;

public class HUD extends Overlay{

	public HUD(Handler handler) {
		super(handler);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		//Health Bar
		int width, height;
		width = 13;
		height = 12;
		int hearts = 0;
		for(int heartsDrawn = 0; heartsDrawn != handler.getGameState().getPlayer().getHeartContainers(); heartsDrawn++){
			if(handler.getGameState().getPlayer().getHealth() - hearts > 1){
				g.drawImage(Assets.heartFull, heartsDrawn * width, 0, width, height, null);
				hearts += 2;
			}else if(handler.getGameState().getPlayer().getHealth() - hearts > 0){
				g.drawImage(Assets.heartHalf, heartsDrawn * width, 0, width, height, null);
				hearts += 1;
			}else{
				g.drawImage(Assets.heartEmpty, heartsDrawn * width, 0, width, height, null);
			}
		}
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
