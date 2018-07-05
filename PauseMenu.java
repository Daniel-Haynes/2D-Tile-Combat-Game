package dev.codenmore.tilegame.overlays;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.states.State;

public class PauseMenu extends Overlay{

	private int mx, my;
	
	public PauseMenu(Handler handler) {
		super(handler);
	}
	
	public void tick() {
		if(handler.getKeyManager().escape){
			try {
				Thread.sleep(130);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			handler.getKeyManager().escape = false;
			Overlay.setOverlay(handler.getHUD());
		}
	}

	public void render(Graphics g) {
		if(mouseOver(160, 93, 1035, 93)){
			g.drawImage(Assets.pauseMenuResume, 0, 0, 1366, 768, null);
		}else if(mouseOver(160, 188, 1035, 93)){
			g.drawImage(Assets.pauseMenuSave, 0, 0, 1366, 768, null);
		}else if(mouseOver(160, 283, 1035, 93)){
			g.drawImage(Assets.pauseMenuLoad, 0, 0, 1366, 768, null);
		}else if(mouseOver(160, 378, 1035, 93)){
			g.drawImage(Assets.pauseMenuMapcreator, 0, 0, 1366, 768, null);
		}else if(mouseOver(160, 670, 1035, 93)){
			g.drawImage(Assets.pauseMenuQuit, 0, 0, 1366, 768, null);
		}else
			g.drawImage(Assets.pauseMenu, 0, 0, 1366, 768, null);
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
		if(Overlay.getOverlay().equals(this) && State.getState().equals(handler.getGameState())){
			if(mouseOver(160, 93, 1035, 93)){
				//Resume
				Overlay.setOverlay(handler.getHUD());
			}else if(mouseOver(160, 188, 1035, 93)){
				//Save
				handler.getGameState().saveGame();
			}else if(mouseOver(160, 283, 1035, 93)){
				//LoadMenu
			}else if(mouseOver(160, 378, 1035, 93)){
				//MapCreator
				State.setState(handler.getMapCreatorState());
			}else if(mouseOver(160, 670, 1035, 93)){
				//Quit
				handler.getGameState().saveGame();
				handler.resetGame();
				State.setState(handler.getMenuState());
			}
		}
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
