package dev.codenmore.tilegame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;


public class Player extends Creature {
	
	private int frameCount;
	private int frameAttack;
	private String lastPos;
	private ArrayList <String> prepos;
	private boolean attackUp, attackDown, attackLeft, attackRight;
	private int heartContainers;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 32;
		frameCount = 0;
		lastPos = "down";
		prepos = new ArrayList <String>();
		prepos.add("down");
		prepos.add("down");
		attackUp = false;
		attackDown = false;
		attackLeft = false;
		attackRight = false;
		heartContainers = 3;
	}

	public void tick() {
		getInput();
		move();
		//isCollision();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up){
			prepos.add("up");
			if(!prepos.get(2).equals("up"))
				prepos.remove(0);
		}else if(handler.getKeyManager().down){
			prepos.add("down");
			if(!prepos.get(2).equals("down"))
				prepos.remove(0);
		}else if(handler.getKeyManager().left){
			prepos.add("left");
			if(!prepos.get(2).equals("left"))
				prepos.remove(0);
		}else if(handler.getKeyManager().right){
			prepos.add("right");
			if(!prepos.get(2).equals("right"))
				prepos.remove(0);
		}
		
		for(int x = prepos.size() - 1; x > 1; x--){
			if(prepos.get(x).equals(prepos.get(x-1)))
				prepos.remove(x);
		}
		
		if(attackUp == false && attackDown == false && attackLeft == false && attackRight == false){
			if(handler.getKeyManager().up && handler.getKeyManager().shift)
				yMove = -speed * 2;
			else if(handler.getKeyManager().down && handler.getKeyManager().shift)
				yMove = speed * 2;
			else if(handler.getKeyManager().left && handler.getKeyManager().shift)
				xMove = -speed * 2;
			else if(handler.getKeyManager().right && handler.getKeyManager().shift)
				xMove = speed * 2;
			else if(handler.getKeyManager().up)
				yMove = -speed;
			else if(handler.getKeyManager().down)
				yMove = speed;
			else if(handler.getKeyManager().left)
				xMove = -speed;
			else if(handler.getKeyManager().right)
				xMove = speed;
		}	
	}

	@Override
	public void render(Graphics g) {
		
		if(attackUp){
			if(frameAttack <= 8){
				g.drawImage(Assets.punchUp, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
				frameAttack++;
				lastPos = "up";
			}
		}else if(attackDown){
			if(frameAttack <= 8){
				g.drawImage(Assets.punchDown, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
				frameAttack++;
				lastPos = "down";
			}
		}else if(attackLeft){
			if(frameAttack <= 8){
				g.drawImage(Assets.punchLeft, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
				frameAttack++;
				lastPos = "left";
			}
		}else if(attackRight){
			if(frameAttack <= 8){
				g.drawImage(Assets.punchRight, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
				frameAttack++;
				lastPos = "right";
			}
		}else if(handler.getKeyManager().up && handler.getKeyManager().shift){
			if(frameCount <= 4)
				g.drawImage(Assets.walkUp1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 8)
				g.drawImage(Assets.walkUp2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 12)
				g.drawImage(Assets.walkUp3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 16)
				g.drawImage(Assets.walkUp2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 20)
				g.drawImage(Assets.walkUp1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 24)
				g.drawImage(Assets.walkUp2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 28)
				g.drawImage(Assets.walkUp3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 32)
				g.drawImage(Assets.walkUp2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			lastPos = "up";
		}else if(handler.getKeyManager().down && handler.getKeyManager().shift){
			if(frameCount <= 4)
				g.drawImage(Assets.walkDown1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 8)
				g.drawImage(Assets.walkDown2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 12)
				g.drawImage(Assets.walkDown3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 16)
				g.drawImage(Assets.walkDown2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 20)
				g.drawImage(Assets.walkDown1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 24)
				g.drawImage(Assets.walkDown2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 28)
				g.drawImage(Assets.walkDown3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 32)
				g.drawImage(Assets.walkDown2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			lastPos = "down";
		}else if(handler.getKeyManager().left && handler.getKeyManager().shift){
			if(frameCount <= 4)
				g.drawImage(Assets.walkLeft1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 8)
				g.drawImage(Assets.walkLeft2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 12)
				g.drawImage(Assets.walkLeft3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 16)
				g.drawImage(Assets.walkLeft2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 20)
				g.drawImage(Assets.walkLeft1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 24)
				g.drawImage(Assets.walkLeft2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 28)
				g.drawImage(Assets.walkLeft3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 32)
				g.drawImage(Assets.walkLeft2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			lastPos = "left";
		}else if(handler.getKeyManager().right && handler.getKeyManager().shift){
			if(frameCount <= 4)
				g.drawImage(Assets.walkRight1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 8)
				g.drawImage(Assets.walkRight2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 12)
				g.drawImage(Assets.walkRight3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 16)
				g.drawImage(Assets.walkRight2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 20)
				g.drawImage(Assets.walkRight1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 24)
				g.drawImage(Assets.walkRight2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 28)
				g.drawImage(Assets.walkRight3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 32)
				g.drawImage(Assets.walkRight2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			lastPos = "right";
		}else if(handler.getKeyManager().up){
			if(frameCount <= 8)
				g.drawImage(Assets.walkUp1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 16)
				g.drawImage(Assets.walkUp2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 24)
				g.drawImage(Assets.walkUp3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 32)
				g.drawImage(Assets.walkUp2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			lastPos = "up";
		}else if(handler.getKeyManager().down){
			if(frameCount <= 8)
				g.drawImage(Assets.walkDown1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 16)
				g.drawImage(Assets.walkDown2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 24)
				g.drawImage(Assets.walkDown3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 32)
				g.drawImage(Assets.walkDown2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			lastPos = "down";
		}else if(handler.getKeyManager().left){
			if(frameCount <= 8)
				g.drawImage(Assets.walkLeft1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 16)
				g.drawImage(Assets.walkLeft2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 24)
				g.drawImage(Assets.walkLeft3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 32)
				g.drawImage(Assets.walkLeft2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			lastPos = "left";
		}else if(handler.getKeyManager().right){
			if(frameCount <= 8)
				g.drawImage(Assets.walkRight1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 16)
				g.drawImage(Assets.walkRight2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 24)
				g.drawImage(Assets.walkRight3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			else if(frameCount <= 32)
				g.drawImage(Assets.walkRight2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			lastPos = "right";
		}else if(lastPos.equals("up")){
			g.drawImage(Assets.walkUp2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			frameCount = 0;
		}else if(lastPos.equals("down")){
			g.drawImage(Assets.walkDown2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			frameCount = 0;
		}else if(lastPos.equals("left")){
			g.drawImage(Assets.walkLeft2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			frameCount = 0;
		}else if(lastPos.equals("right")){
			g.drawImage(Assets.walkRight2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
			frameCount = 0;
		}
		
		if(frameCount == 32)
			frameCount = 0;
		frameCount++;
		
		if(frameAttack > 8){
			frameAttack = 0;
			attackUp = false;
			attackDown = false;
			attackLeft = false;
			attackRight = false;
		}
		/*
		int myxOffset = 0;
		int myyOffset = 0;
		
		if(game.getGameCamera().getxOffset() < 0)
			myxOffset = (int) Math.abs(game.getGameCamera().getxOffset());
		else
			myxOffset = -(int) game.getGameCamera().getxOffset();
		if(game.getGameCamera().getyOffset() < 0)
			myyOffset = (int) Math.abs(game.getGameCamera().getyOffset());
		else
			myyOffset = -(int) game.getGameCamera().getyOffset();
		*/
		//g.fillRect(getTileX() * Tile.TILEWIDTH + myxOffset, getTileY() * Tile.TILEHEIGHT + myyOffset, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		//g.fillRect((getTileX() * Tile.TILEWIDTH + myxOffset) + Tile.TILEWIDTH, getTileY() * Tile.TILEHEIGHT + myyOffset, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		//g.fillRect(getTileX() * Tile.TILEWIDTH + myxOffset, (getTileY() * Tile.TILEHEIGHT + myyOffset) + Tile.TILEHEIGHT, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		//g.fillRect((getTileX() * Tile.TILEWIDTH + myxOffset) + Tile.TILEWIDTH, (getTileY() * Tile.TILEHEIGHT + myyOffset) + Tile.TILEHEIGHT, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		//g.drawRect(getTileX() * Tile.TILEWIDTH + myxOffset, getTileY() * Tile.TILEHEIGHT + myyOffset, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		//g.drawRect((getTileX() * Tile.TILEWIDTH + myxOffset) + Tile.TILEWIDTH, getTileY() * Tile.TILEHEIGHT + myyOffset, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		//g.drawRect(getTileX() * Tile.TILEWIDTH + myxOffset, (getTileY() * Tile.TILEHEIGHT + myyOffset) + Tile.TILEHEIGHT, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		//g.drawRect((getTileX() * Tile.TILEWIDTH + myxOffset) + Tile.TILEWIDTH, (getTileY() * Tile.TILEHEIGHT + myyOffset) + Tile.TILEHEIGHT, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		//if(game.getKeyManager().up){
			//g.drawRect(getTileX() * Tile.TILEWIDTH + myxOffset, (getTileY() * Tile.TILEHEIGHT + myyOffset) - Tile.TILEHEIGHT, Tile.TILEWIDTH, Tile.TILEHEIGHT);
			//g.drawRect((getTileX() * Tile.TILEWIDTH + myxOffset) + Tile.TILEWIDTH, (getTileY() * Tile.TILEHEIGHT + myyOffset) - Tile.TILEHEIGHT, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		//}
		
		//g.setColor(Color.red);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
		//		(int) (y + bounds.y - handler.getGameCamera().getyOffset()), 
		//		bounds.width, bounds.height);
	}
	
	public boolean isAttackUp() {
		return attackUp;
	}

	public void setAttackUp(boolean attackUp) {
		this.attackUp = attackUp;
	}

	public boolean isAttackDown() {
		return attackDown;
	}

	public void setAttackDown(boolean attackDown) {
		this.attackDown = attackDown;
	}

	public boolean isAttackLeft() {
		return attackLeft;
	}

	public void setAttackLeft(boolean attackLeft) {
		this.attackLeft = attackLeft;
	}

	public boolean isAttackRight() {
		return attackRight;
	}

	public void setAttackRight(boolean attackRight) {
		this.attackRight = attackRight;
	}
	
	public int getHealth(){
		return health;
	}
	
	public int getHeartContainers(){
		return heartContainers;
	}

}
