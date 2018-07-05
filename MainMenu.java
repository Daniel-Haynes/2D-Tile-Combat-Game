package dev.codenmore.tilegame.states.menustates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.states.MenuState;
import dev.codenmore.tilegame.states.State;

public class MainMenu extends MenuState{

	public MainMenu(Handler handler) {
		super(handler);
	}
	
	public void tick(){
		if(handler.getKeyManager().escape && MenuState.getState().equals(this)){
			System.exit(1);
		}
	}
	
	public void render(Graphics g){
		//Backdrop
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		
		//Highlighting effect
		g.setColor(Color.RED);
		
		if(State.getState().equals(handler.getMenuState())){
			if(mouseOver(400, 250, 600, 100))
				g.fillRect(401, 251, 599, 99);
			else if(mouseOver(400, 400, 600, 100))
				g.fillRect(401, 401, 599, 99);
			else if(mouseOver(400, 550, 600, 100))
				g.fillRect(401, 551, 599, 99);
		}
		
		//Text and Buttons
		Font fnt = new Font("arial", 1, 50);
		
		g.setColor(Color.WHITE);
		g.setFont(fnt);
		
		g.drawString("Pokemon Fight", 510, 150);
		g.drawString("Play", 640, 315);
		g.drawString("Settings", 600, 465);
		g.drawString("Quit", 645, 615);
		g.drawRect(400, 250, 600, 100);
		g.drawRect(400, 400, 600, 100);
		g.drawRect(400, 550, 600, 100);
	}
	
	public void mouseMoved(MouseEvent e){
		mx = e.getX();
		my = e.getY();
	}
	
	public void mousePressed(MouseEvent e) {
		if(State.getState().equals(handler.getMenuState())){
			if(mouseOver(400, 250, 600, 100))
				MenuState.setState(handler.getPlayMenu());
			else if(mouseOver(400, 550, 600, 100))
				System.exit(1);
		}
	} 

}
