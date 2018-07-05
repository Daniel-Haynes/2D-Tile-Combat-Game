package dev.codenmore.tilegame.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.tiles.Tile;
import dev.codenmore.tilegame.worlds.World;

public class MapCreatorState extends State{
	
	private int width, height;
	private int mx, my;
	private int xOffset, yOffset;
	private int currentX = 0, currentY = 0;
	private int[][] tiles;
	private int [][] npcs;
	private int selectedTile;
	private int button;
	private int numOfNpcs = 0;
	private int npcX;
	private int npcY;
	private int lastPathX;
	private int lastPathY;
	private boolean hasTree = false;
	private boolean hasNpc = false;
	private boolean pathing = false;
	private ArrayList<ArrayList<Integer>> moves = new ArrayList<ArrayList<Integer>>(1024);

	public MapCreatorState(Handler handler) {
		super(handler);
		width = Tile.TILEWIDTH;
		height = Tile.TILEHEIGHT;
		tiles = new int[1024][1024];
		for(int x = 0; x < 1024; x++)
			moves.add(new ArrayList<Integer>());
		for(int x = 0; x < tiles.length; x++){
			for(int y = 0; y < tiles[0].length; y++){
				tiles[x][y] = 1025;
			}
		}
		npcs = new int[1024][1024];
		for(int x = 0; x < npcs.length; x++){
			for(int y = 0; y < npcs[0].length; y++){
				npcs[x][y] = 1025;
			}
		}
		xOffset = 0;
		yOffset = 0;
	}
	
	public void tick() {
		
	}

	public void render(Graphics g) {
		//Draws grid
		for(int x = 0; x < handler.getWidth() - xOffset; x += Tile.TILEWIDTH){
			g.setColor(Color.BLACK);
			g.fillRect(x + xOffset, 0, 2, handler.getHeight());
		}
		for(int y = 0; y < handler.getHeight() - yOffset; y += Tile.TILEHEIGHT){
			g.fillRect(0, y + yOffset, handler.getWidth(), 2);
		}
		
		//Renders tiles
		for(int x = 0; x < tiles.length; x++){
			for(int y = 0; y < tiles[0].length; y++){
				if(tiles[x][y] < 1025)
					getTile(x, y).render(g, (x * width) + xOffset, (y * height) + yOffset);
			}
		}
		
		//
		for(int x = 0; x < npcs.length; x++){
			for(int y = 0; y < npcs[0].length; y++){
				if(npcs[x][y] < 1025)
					if(npcs[x][y] == 64)
						g.drawImage(Assets.walkDown2, (x * width) + xOffset, (y * height) + yOffset, width, height, null);
					else if(npcs[x][y] == 1021)
						g.drawImage(Assets.upArrow, (x * width) + xOffset, (y * height) + yOffset, width, height, null);
					else if(npcs[x][y] == 1022)
						g.drawImage(Assets.rightArrow, (x * width) + xOffset, (y * height) + yOffset, width, height, null);
					else if(npcs[x][y] == 1023)
						g.drawImage(Assets.downArrow, (x * width) + xOffset, (y * height) + yOffset, width, height, null);
					else if(npcs[x][y] == 1024)
						g.drawImage(Assets.leftArrow, (x * width) + xOffset, (y * height) + yOffset, width, height, null);
			}
		}
		
		//Selection panel
		g.setColor(Color.BLUE);
		g.fillRect(900, 0, 466, 768);
		g.drawImage(Assets.grass, 901, 1, width, height, null);
		g.drawImage(Assets.dirt, 902 + width, 1, width, height, null);
		g.drawImage(Assets.pathwayBL, 903  + width * 2, 1, width, height, null);
		g.drawImage(Assets.pathwayBR, 904 + width * 3, 1, width, height, null);
		g.drawImage(Assets.pathwayTL, 905 + width * 4, 1, width, height, null);
		g.drawImage(Assets.pathwayTR, 906 + width * 5, 1, width, height, null);
		g.drawImage(Assets.pathwayL, 907 + width * 6, 1, width, height, null);
		g.drawImage(Assets.pathwayR, 901, height + 2, width, height, null);
		g.drawImage(Assets.pathwayT, 902 + width, height + 2, width, height, null);
		g.drawImage(Assets.pathwayB, 903  + width * 2, height + 2, width, height, null);
		g.drawImage(Assets.pathwayBLInv, 904 + width * 3, height + 2, width, height, null);
		g.drawImage(Assets.pathwayBRInv, 905 + width * 4, height + 2, width, height, null);
		g.drawImage(Assets.pathwayTLInv, 906 + width * 5, height + 2, width, height, null);
		g.drawImage(Assets.pathwayTRInv, 907 + width * 6, height + 2, width, height, null);
		g.drawImage(Assets.treeBaseL, 901, height * 2 + 3, width, height, null);
		g.drawImage(Assets.treeBaseR, 902 + width, height * 2 + 3, width, height, null);
		g.drawImage(Assets.treeMidL, 903  + width * 2, height * 2 + 3, width, height, null);
		g.drawImage(Assets.treeMidR, 904 + width * 3, height * 2 + 3, width, height, null);
		g.drawImage(Assets.treeTopL, 905 + width * 4, height * 2 + 3, width, height, null);
		g.drawImage(Assets.treeTopR, 906 + width * 5, height * 2 + 3, width, height, null);
		g.drawImage(Assets.darkRockL, 907 + width * 6, height * 2 + 3, width, height, null);
		g.drawImage(Assets.darkRockR, 901, height * 3 + 4, width, height, null);
		g.drawImage(Assets.lightRockL, 902 + width, height * 3 + 4, width, height, null);
		g.drawImage(Assets.lightRockR, 903  + width * 2, height * 3 + 4, width, height, null);
		g.drawImage(Assets.water1100, 904 + width * 3, height * 3 + 4, width, height, null);
		g.drawImage(Assets.water1101, 905 + width * 4, height * 3 + 4, width, height, null);
		g.drawImage(Assets.water1102, 906 + width * 5, height * 3 + 4, width, height, null);
		g.drawImage(Assets.water1200, 907 + width * 6, height * 3 + 4, width, height, null);
		g.drawImage(Assets.water1201, 901, height * 4 + 5, width, height, null);
		g.drawImage(Assets.water1202, 902 + width, height * 4 + 5, width, height, null);
		g.drawImage(Assets.water1300, 903  + width * 2, height * 4 + 5, width, height, null);
		g.drawImage(Assets.water1301, 904 + width * 3, height * 4 + 5, width, height, null);
		g.drawImage(Assets.water1302, 905 + width * 4, height * 4 + 5, width, height, null);
		g.drawImage(Assets.tree1718, 906 + width * 5, height * 4 + 5, width, height, null);
		g.drawImage(Assets.tree1719, 907 + width * 6, height * 4 + 5, width, height, null);
		g.drawImage(Assets.tree1720, 901, height * 5 + 6, width, height, null);
		g.drawImage(Assets.tree1818, 902 + width, height * 5 + 6, width, height, null);
		g.drawImage(Assets.tree1819, 903  + width * 2, height * 5 + 6, width, height, null);
		g.drawImage(Assets.tree1820, 904 + width * 3, height * 5 + 6, width, height, null);
		g.drawImage(Assets.pc1, 905 + width * 4, height * 5 + 6, width, height, null);
		g.drawImage(Assets.pc2, 906 + width * 5, height * 5 + 6, width, height, null);
		g.drawImage(Assets.pc3, 907 + width * 6, height * 5 + 6, width, height, null);
		g.drawImage(Assets.pc4, 901, height * 6 + 7, width, height, null);
		g.drawImage(Assets.pc5, 902 + width, height * 6 + 7, width, height, null);
		g.drawImage(Assets.pc6, 903  + width * 2, height * 6 + 7, width, height, null);
		g.drawImage(Assets.pc7, 904 + width * 3, height * 6 + 7, width, height, null);
		g.drawImage(Assets.pc8, 905 + width * 4, height * 6 + 7, width, height, null);
		g.drawImage(Assets.pc9, 906 + width * 5, height * 6 + 7, width, height, null);
		g.drawImage(Assets.pc10, 907 + width * 6, height * 6 + 7, width, height, null);
		g.drawImage(Assets.pc11, 901, height * 7 + 8, width, height, null);
		g.drawImage(Assets.pc12, 902 + width, height * 7 + 8, width, height, null);
		g.drawImage(Assets.pc13, 903  + width * 2, height * 7 + 8, width, height, null);
		g.drawImage(Assets.pc14, 904 + width * 3, height * 7 + 8, width, height, null);
		g.drawImage(Assets.pc15, 905 + width * 4, height * 7 + 8, width, height, null);
		g.drawImage(Assets.pc16, 906 + width * 5, height * 7 + 8, width, height, null);
		g.drawImage(Assets.pc17, 907 + width * 6, height * 7 + 8, width, height, null);
		g.drawImage(Assets.pc18, 901, height * 8 + 9, width, height, null);
		g.drawImage(Assets.pc19, 902 + width, height * 8 + 9, width, height, null);
		g.drawImage(Assets.pc20, 903  + width * 2, height * 8 + 9, width, height, null);
		g.drawImage(Assets.pc21, 904 + width * 3, height * 8 + 9, width, height, null);
		g.drawImage(Assets.pc22, 905 + width * 4, height * 8 + 9, width, height, null);
		g.drawImage(Assets.pc23, 906 + width * 5, height * 8 + 9, width, height, null);
		g.drawImage(Assets.pc24, 907 + width * 6, height * 8 + 9, width, height, null);
		g.drawImage(Assets.pc25, 901, height * 9 + 10, width, height, null);
		
		g.drawImage(Assets.walkDown2, 902 + width, height * 9 + 10, width, height, null);
		
		//Buttons
		g.drawImage(Assets.newButton, 900, 700, 150, 50, null);
		g.drawImage(Assets.saveButton, 1060, 700, 150, 50, null);
		g.drawImage(Assets.quitButton, 1220, 700, 150, 50, null);
		
		//Renders selected tile
		if(pathing == false){
			if(hasNpc == false){
				if(hasTree == true){
					g.drawImage(Tile.getTile(18), mx - (width / 2), my - (height / 2), width, height, null);
					g.drawImage(Tile.getTile(19), mx - (width / 2) + width, my - (height / 2), width, height, null);
					g.drawImage(Tile.getTile(16), mx - (width / 2), my - (height / 2) + height, width, height, null);
					g.drawImage(Tile.getTile(17), mx - (width / 2) + width, my - (height / 2) + height, width, height, null);
					g.drawImage(Tile.getTile(14), mx - (width / 2), my - (height / 2) + height * 2, width, height, null);
					g.drawImage(Tile.getTile(15), mx - (width / 2) + width, my - (height / 2) + height * 2, width, height, null);
				}else
					g.drawImage(Tile.getTile(selectedTile), mx - (width / 2), my - (height / 2), width, height, null);
			}else
				g.drawImage(Assets.walkDown2, mx - (width / 2), my - (height / 2), width, height, null);
		}else{
			if(getSide() == 0)
				g.drawImage(Assets.upArrow, mx - width / 2, my - height / 2, width, height, null);
			else if(getSide() == 1)
				g.drawImage(Assets.rightArrow, mx - width / 2, my - height / 2, width, height, null);
			else if(getSide() == 2)
				g.drawImage(Assets.downArrow, mx - width / 2, my - height / 2, width, height, null);
			else if(getSide() == 3)
				g.drawImage(Assets.leftArrow, mx - width / 2, my - height / 2, width, height, null);
			else if(getSide() == -1)
				g.drawImage(Assets.x, mx - width / 2, my - height / 2, width, height, null);
		}
		
		/*
		g.setColor(Color.BLACK);
		g.fillRect(1300, 700, width, height);
		*/
	}
	
	public int getSide(){
		if(((mx - width) - xOffset) / width == lastPathX && (my - yOffset) / height == lastPathY)
			return 1; //Right side
		if(((mx + width) - xOffset) / width == lastPathX && (my - yOffset) / height == lastPathY)
			return 3; //Left side
		if((mx - xOffset) / width == lastPathX && ((my - height) - yOffset) / height == lastPathY)
			return 2; //Bottom side
		if((mx - xOffset) / width == lastPathX && ((my + height) - yOffset) / height == lastPathY)
			return 0; //Top side
		return -1;
	}
	
	public Tile getTile(int x, int y){
		if(x > tiles.length - 1 || y > tiles[0].length - 1 || x < 0 || y < 0)
			return Tile.dirtTile;
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
		return t;
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
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(State.getState().equals(this)){
			if(e.getButton() == MouseEvent.BUTTON1){ //If left click
				
				button = MouseEvent.BUTTON1;
				
				for(int x = 0; x < handler.getWidth(); x++){
					for(int y = 0; y < handler.getHeight(); y++){
						if(mouseOver(x * width + (901 + x), y * width + (1 + y), width, height) && pathing == false){
							
							if(y == 0){
								selectedTile = x;
								hasNpc = false;
								hasTree = false;
								return;
							}else if(y == 1){
								selectedTile = 7 + x;
								hasNpc = false;
								hasTree = false;
								return;
							}else if(y == 2){
								hasTree = false;
								if(14 + x >= 14 && 14 + x <= 19 && selectedTile >= 14 && selectedTile <= 19)
									hasTree = true;
								selectedTile = 14 + x;
								hasNpc = false;
								return;
							}else if(y == 3){
								selectedTile = 21 + x;
								hasNpc = false;
								hasTree = false;
								return;
							}else if(y == 4){
								selectedTile = 28 + x;
								hasNpc = false;
								hasTree = false;
								return;
							}else if(y == 5){
								selectedTile = 35 + x;
								hasNpc = false;
								hasTree = false;
								return;
							}else if(y == 6){
								selectedTile = 42 + x;
								hasNpc = false;
								hasTree = false;
								return;
							}else if(y == 7){
								selectedTile = 49 + x;
								hasTree = false;
								hasNpc = false;
								return;
							}else if(y == 8){
								selectedTile = 56 + x;
								hasNpc = false;
								hasTree = false;
								return;
							}else if(y == 9){
								if(x < 2) //Only tile in the row, causes null pointer without
									selectedTile = 63 + x;
								if(x == 1){
									hasNpc = true;
								}
								return;
							}
						}
					}
				}
				
				if(mouseOver(0, 0, 900, 1366))
					drawTile();
				
				if(mouseOver(900, 700, 150, 50)){
					clearMap();
				}else if(mouseOver(1060, 700, 150, 50)){
					saveWorld();
				}else if(mouseOver(1220, 700, 150, 50)){
					State.setState(handler.getGameState());
				}
			}
			
			else if(e.getButton() == MouseEvent.BUTTON3){
				currentX = mx;
				currentY = my;
				button = MouseEvent.BUTTON3;
				
				for(int x = 0; x < handler.getWidth() - xOffset; x++){
					for(int y = 0; y < handler.getHeight() - yOffset; y++){
						if(mouseOver((x * width) + xOffset, (y * height) + yOffset, width, height)){
							tiles[x][y] = 1025;	
						}
					}
				}
			}
			
		}
	}
	
	public void drawTile(){
		if(hasNpc == false)
			for(int x = 0; x < handler.getWidth() - xOffset; x++){
				for(int y = 0; y < handler.getHeight() - yOffset; y++){
					if(mouseOver((x * width) + xOffset, (y * height) + yOffset, width, height)){
						if(hasTree == false)
							tiles[x][y] = selectedTile;
						else{
							tiles[x][y] = 18;
							tiles[x + 1][y] = 19;
							tiles[x][y + 1] = 16;
							tiles[x + 1][y + 1] = 17;
							tiles[x][y + 2] = 14;
							tiles[x + 1][y + 2] = 15;
						}
							
					}
				}
			}
		else
			if(pathing == false)
				for(int x = 0; x < handler.getWidth() - xOffset; x++){
					for(int y = 0; y < handler.getHeight() - yOffset; y++){
						if(mouseOver((x * width) + xOffset, (y * height) + yOffset, width, height)){
							npcs[x][y] = selectedTile;
							pathing = true;
							numOfNpcs += 1;
							npcX = ((x * width)) / width;
							npcY = ((y * height)) / height;
							lastPathX = ((x * width)) / width;
							lastPathY = ((y * height)) / height;
							moves.get(numOfNpcs).add(npcX);
							moves.get(numOfNpcs).add(npcY);
						}
					}
				}
			else
				for(int x = 0; x < handler.getWidth() - xOffset; x++){
					for(int y = 0; y < handler.getHeight() - yOffset; y++){
						if(mouseOver((x * width) + xOffset, (y * height) + yOffset, width, height)){
							if(getSide() == 0){
								npcs[x][y] = 1021;
								lastPathY -= 1;
								moves.get(numOfNpcs).add(0);
							}else if(getSide() == 1){
								npcs[x][y] = 1022;
								lastPathX += 1;
								moves.get(numOfNpcs).add(1);
							}else if(getSide() == 2){
								npcs[x][y] = 1023;
								lastPathY += 1;
								moves.get(numOfNpcs).add(2);
							}else if(getSide() == 3){
								npcs[x][y] = 1024;
								lastPathX -= 1;
								moves.get(numOfNpcs).add(3);
							}
							
							if(lastPathX == npcX && lastPathY == npcY){
								npcs[x][y] = 64;
								pathing = false;
							}
						}
					}
				}
	}
	
	public void saveWorld(){
		BufferedWriter writer = null;
		int width = 0, height = 0;
		
		for(int x = 0 ; x < tiles.length; x++){
			if(tiles[x][0] < 1025)
				width++;
			else
				x = tiles.length;
		}
		
		for(int y = 0 ; y < tiles[0].length; y++){
			if(tiles[0][y] < 1025)
				height++;
			else
				y = tiles[0].length;
		}
		
		for(int x = 0 ; x < width; x++){
			for(int y = 0 ; y < height; y++){
				if(tiles[x][y] >= 1025){
					System.out.println(tiles[x][y]);
					System.out.println("Error: Map Incomplete!");
					return;
				}
			}
		}
		
		String save = width + " " + height + "\n" + "100 100\n" + numOfNpcs + "\n";
		for(int y = 0; y < height; y++){
			for(int x = 0 ; x < width; x++){
				save += tiles[x][y] + " ";
			}
			save += "\n";
		}
		
		save += "\n";
		
		for(int x = 0; x < npcs.length; x++){
			for(int y = 0; y < npcs[0].length; y++){
				if(npcs[x][y] == 64){
					save += "1 " + moves.get(numOfNpcs).get(0) * 64 + " " + moves.get(numOfNpcs).get(1) * 64 + " ";
					moves.get(numOfNpcs).remove(0);
					moves.get(numOfNpcs).remove(0);
					save += moves.get(numOfNpcs).size() + " ";
					for(int i = 0; i < moves.get(numOfNpcs).size(); i++){
						save += moves.get(numOfNpcs).get(i) + " ";
					}
					save += "\n";
					numOfNpcs--;
				}
			}
		}
		
		File temp = new File("res/worlds/newWorld.txt");
		try {
			writer = new BufferedWriter(new FileWriter(temp));
			writer.write(save);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			writer.close();
		} catch (IOException e) {
		}
		System.out.println("Saved!");
	}
	
	public void clearMap(){
		for(int x = 0; x < tiles.length; x++){
			for(int y = 0; y < tiles[0].length; y++){
				tiles[x][y] = 1025;
			}
		}
		for(int x = 0; x < npcs.length; x++){
			for(int y = 0; y < npcs[0].length; y++){
				npcs[x][y] = 1025;
			}
		}
		for(int x = 0; x < 1024; x++){
			for(int y = 0; y < moves.get(x).size(); y++){
				moves.get(x).remove(y);
			}
		}
		numOfNpcs = 0;
		pathing = false;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		button = 0;
		
		mx = e.getX();
		my = e.getY();
		
		if(e.getButton() == MouseEvent.BUTTON3){
			xOffset += (currentX - mx) * -1;
			yOffset += (currentY - my) * -1;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		
		if(button == 1 && mouseOver(0, 0, 900, 768) && !pathing)
			drawTile();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
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
		// TODO Auto-generated method stub
		return null;
	}

}
