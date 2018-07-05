package dev.codenmore.tilegame.worlds;

import java.awt.Graphics;
import java.util.Random;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.tiles.Tile;
import dev.codenmore.tilegame.utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	private boolean[][] topTiles;
	private int numOfNpcs;
	
	public World(Handler handler, String path){
		this.handler = handler;
		loadWorld(path);
		//generateWorld(1024,1024);
		topTiles = new boolean[width][height];
	}
	
	public void tick(){
		
	}
	
	public int[][] getTiles() {
		return tiles;
	}

	public void render(Graphics g){
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				if(topTiles[x][y] == false)
					getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
							(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}
	
	public void renderTop(Graphics g){
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				if(topTiles[x][y] == true)
					getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
							(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}
	
	public void renderBackground(Graphics g){
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				if(getTile(x,y).onTop()){
					topTiles[x][y] = true;
					Tile.grassTile.render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
							(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
				}
			}
		}
	}
	
	public Tile getTile(int x, int y){
		if(x > tiles.length - 1 || y > tiles[0].length - 1 || x < 0 || y < 0)
			return Tile.dirtTile;
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
		return t;
	}
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		setSpawnX(Utils.parseInt(tokens[2]));
		setSpawnY(Utils.parseInt(tokens[3]));
		numOfNpcs = Utils.parseInt(tokens[4]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 5]);
			}
		}
		
		handler.getGame().getGameState().loadNpcs(path);
		
	}
	
	public void generateWorld(int width, int height){
		this.width = width;
		this.height = height;
		tiles = new int[width][height];
		
		//Adds grass tiles
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = 0;
			}
		}
		
		//Spawns trees
		Random r = new Random();
		int num = 0;
		for(int y = 0;y < height - 2;y++){
			for(int x = 0;x < width - 1;x++){
				num = r.nextInt(100);
				if(tiles[x][y] == 0 && tiles[x+1][y] == 0 && tiles[x][y+1] == 0 && tiles[x+1][y+1] == 0  && tiles[x][y+2] == 0 && tiles[x+1][y+2] == 0 && num == 1){
					tiles[x][y] = 18;
					tiles[x+1][y] = 19;
					tiles[x][y+1] = 16;
					tiles[x+1][y+1] = 17;
					tiles[x][y+2] = 14;
					tiles[x+1][y+2] = 15;
				}
			}
		}
	}

	public int getSpawnX() {
		return spawnX;
	}

	public void setSpawnX(int spawnX) {
		this.spawnX = spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}

	public void setSpawnY(int spawnY) {
		this.spawnY = spawnY;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}
