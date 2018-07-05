package dev.codenmore.tilegame.entities.creatures;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.tiles.Tile;

public class Computer extends Creature{
	
	private int wait;
	private boolean move;
	private int pos = 0;
	private int lastPos = 2;
	private int[] moves;
	private int frameCount = 0;

	public Computer(Handler handler, float x, float y, int[] moves) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		wait = 0;
		move = false;
		this.moves = moves;
	}

	public void tick() {
		makeMove();
		move();
	}

	public void render(Graphics g) {
		if(yMove == -1){
			//System.out.println("Up");
			if(frameCount <= 12)
				g.drawImage(Assets.walkUp1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 24)
				g.drawImage(Assets.walkUp2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 36)
				g.drawImage(Assets.walkUp3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 48)
				g.drawImage(Assets.walkUp2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}else if(yMove == 1){
			if(frameCount <= 12)
				g.drawImage(Assets.walkDown1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 24)
				g.drawImage(Assets.walkDown2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 36)
				g.drawImage(Assets.walkDown3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 48)
				g.drawImage(Assets.walkDown2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}else if(xMove == -1){
			if(frameCount <= 12)
				g.drawImage(Assets.walkLeft1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 24)
				g.drawImage(Assets.walkLeft2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 36)
				g.drawImage(Assets.walkLeft3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 48)
				g.drawImage(Assets.walkLeft2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}else if(xMove == 1){
			if(frameCount <= 12)
				g.drawImage(Assets.walkRight1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 24)
				g.drawImage(Assets.walkRight2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 36)
				g.drawImage(Assets.walkRight3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 48)
				g.drawImage(Assets.walkRight2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}else if(lastPos == 0){
			g.drawImage(Assets.walkUp2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}else if(lastPos == 1){
			g.drawImage(Assets.walkRight2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}else if(lastPos == 2){
			g.drawImage(Assets.walkDown2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}else if(lastPos == 3){
			g.drawImage(Assets.walkLeft2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}
		
		if(frameCount == 48)
			frameCount = 0;
		frameCount++;
	}
	
	public void makeMove(){
		/*
		wait++;
		yMove = 0;
		xMove = 0;
		
		Random r = new Random();
		
		if(wait == 50 && move == true){
			move = false;
			wait = 0;
			num = r.nextInt(4);
		}
		
		if(wait == 500 && move == false){
			move = true;
			wait = 0;
			num = r.nextInt(4);
		}
		
		if(move == true)
			switch(num){
				case 0 : yMove = -1; break; //Up
				case 1 : yMove = 1; break; //Down
				case 2 : xMove = -1; break; //Left
				case 3 : xMove = 1; break; //Right
				default : break;
			}	
		*/
		//0 - Up
		//1 - Right
		//2 - Down
		//3 - Left
		xMove = 0;
		yMove = 0;
		int num = 0;
		
		if(pos >= moves.length)
			pos = 0;
		num = moves[pos];
		
		if(wait >= 0)
			switch(num){
				case 0 : yMove = -1; lastPos = 0; break; //Up
				case 1 : xMove = 1; lastPos = 1; break; //Right
				case 2 : yMove = 1; lastPos = 2; break; //Down
				case 3 : xMove = -1; lastPos = 3; break; //Left
				default : break;
			}
		
		wait++;
		
		if(wait == Tile.TILEWIDTH){
			pos++;
			wait = -100;
		}
	}
}
