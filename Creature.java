package dev.codenmore.tilegame.entities.creatures;

import java.awt.Rectangle;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;
import dev.codenmore.tilegame.states.GameState;
import dev.codenmore.tilegame.tiles.Tile;

public abstract class Creature extends Entity {
	
	public static final int DEFAULT_HEALTH = 6;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move(){
		moveX();
		moveY();
	}
	
	public void moveX(){
		if(xMove > 0){//Moving right
			
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
			}
		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}
	}
	
	public void moveY(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y){
		return handler.getWorld().getTile(x, y).isSolid();
	}
	/*
	public int getTileX(){
		return (int) (x / Tile.TILEWIDTH);
	}
	
	public int getTileY(){
		return (int) (y / Tile.TILEWIDTH);
	}
	
	public void isCollision(){
		
		int myxOffset = 0;
		int myyOffset = 0;
		
		if(handler.getGameCamera().getxOffset() < 0)
			myxOffset = (int) Math.abs(handler.getGameCamera().getxOffset());
		else
			myxOffset = -(int) handler.getGameCamera().getxOffset();
		if(handler.getGameCamera().getyOffset() < 0)
			myyOffset = (int) Math.abs(handler.getGameCamera().getyOffset());
		else
			myyOffset = -(int) handler.getGameCamera().getyOffset();
		
		Rectangle rectOne = new Rectangle((int) x + myxOffset, (int) y + myyOffset, width, height);
		Rectangle rectTwo = new Rectangle(getTileX() * Tile.TILEWIDTH + myxOffset, getTileY() * Tile.TILEHEIGHT + myyOffset, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		Rectangle rectThree = new Rectangle((getTileX() * Tile.TILEWIDTH + myxOffset) + Tile.TILEWIDTH, getTileY() * Tile.TILEHEIGHT + myyOffset, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		Rectangle rectFour = new Rectangle(getTileX() * Tile.TILEWIDTH + myxOffset, (getTileY() * Tile.TILEHEIGHT + myyOffset) + Tile.TILEHEIGHT, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		Rectangle rectFive = new Rectangle((getTileX() * Tile.TILEWIDTH + myxOffset) + Tile.TILEWIDTH, (getTileY() * Tile.TILEHEIGHT + myyOffset) + Tile.TILEHEIGHT, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		//System.out.println(getTileX() + " " + getTileY());
		
		if(rectOne.intersects(rectTwo) && handler.getGameState().getWorld().getTile(getTileX(), getTileY()).entrance()){
			if(handler.getKeyManager().up && GameState.getState().equals(handler.getWorldState())){
				handler.getWorldState().setXLast(getTileX());
				handler.getWorldState().setYLast(getTileY() + 1);
				GameState.setState(handler.getPokemonCenterState());
				this.x = 100;
				this.y = 100;
			}else if(handler.getKeyManager().up && GameState.getState().equals(handler.getPokemonCenterState())){
				GameState.setState(handler.getWorldState());
				this.x = handler.getWorldState().getXLast() * Tile.TILEWIDTH;
				this.y = handler.getWorldState().getYLast() * Tile.TILEHEIGHT;
			}
		}else if(rectOne.intersects(rectThree) && handler.getGameState().getWorld().getTile(getTileX() + 1, getTileY()).entrance()){
			if(handler.getKeyManager().up && GameState.getState().equals(handler.getWorldState())){
				handler.getWorldState().setXLast(getTileX() + 1);
				handler.getWorldState().setYLast(getTileY() + 1);
				GameState.setState(handler.getPokemonCenterState());
				this.x = 100;
				this.y = 100;
			}else if(handler.getKeyManager().up && GameState.getState().equals(handler.getPokemonCenterState())){
				GameState.setState(handler.getWorldState());
				this.x = handler.getWorldState().getXLast() * Tile.TILEWIDTH;
				this.y = handler.getWorldState().getYLast() * Tile.TILEHEIGHT;
			}
		}
		
		if(rectOne.intersects(rectTwo) && handler.getGameState().getWorld().getTile(getTileX(), getTileY()).isSolid()){
			if(handler.getKeyManager().up)
				this.y += rectOne.intersection(rectTwo).height + 1;
			else if(handler.getKeyManager().left)
				this.x += rectOne.intersection(rectTwo).width + 1;
		}else if(rectOne.intersects(rectThree) && handler.getGameState().getWorld().getTile(getTileX() + 1, getTileY()).isSolid()){
			if(handler.getKeyManager().up)
				this.y += rectOne.intersection(rectThree).height + 1;
			else if(handler.getKeyManager().right)
				this.x -= rectOne.intersection(rectThree).width + 1;
		}else if(rectOne.intersects(rectFour) && handler.getGameState().getWorld().getTile(getTileX(), getTileY() + 1).isSolid()){
			if(handler.getKeyManager().down)
				this.y -= rectOne.intersection(rectFour).height + 1;
			else if(handler.getKeyManager().left)
				this.x += rectOne.intersection(rectFour).width + 1;
		}else if(rectOne.intersects(rectFive) && handler.getGameState().getWorld().getTile(getTileX() + 1, getTileY() + 1).isSolid()){
			if(handler.getKeyManager().down)
				this.y -= rectOne.intersection(rectFive).height + 1;
			else if(handler.getKeyManager().right)
				this.x -= rectOne.intersection(rectFive).width + 1;
		}
	}
	*/
	//GETTERS SETTERS

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
}
