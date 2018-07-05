package dev.codenmore.tilegame.tiles;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Tile {
	
	//STATIC STUFF HERE
	
	public static int x;
	public static int y;
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile pathwayBLTile = new PathwayBLTile(2);
	public static Tile pathwayBRTile = new PathwayBRTile(3);
	public static Tile pathwayTLTile = new PathwayTLTile(4);
	public static Tile pathwayTRTile = new PathwayTRTile(5);
	public static Tile pathwayLTile = new PathwayLTile(6);
	public static Tile pathwayRTile = new PathwayRTile(7);
	public static Tile pathwayTTile = new PathwayTTile(8);
	public static Tile pathwayBTile = new PathwayBTile(9);
	public static Tile pathwayBLInvTile = new PathwayBLInvTile(10);
	public static Tile pathwayBRInvTile = new PathwayBRInvTile(11);
	public static Tile pathwayTLInvTile = new PathwayTLInvTile(12);
	public static Tile pathwayTRInvTile = new PathwayTRInvTile(13);
	public static Tile treeBaseLTile = new TreeBaseLTile(14);
	public static Tile treeBaseRTile = new TreeBaseRTile(15);
	public static Tile treeMidLTile = new TreeMidLTile(16);
	public static Tile treeMidRTile = new TreeMidRTile(17);
	public static Tile treeTopLTile = new TreeTopLTile(18);
	public static Tile treeTopRTile = new TreeTopRTile(19);
	public static Tile darkRockLTile = new DarkRockLTile(20);
	public static Tile darkRockRTile = new DarkRockRTile(21);
	public static Tile lightRockLTile = new LightRockLTile(22);
	public static Tile lightRockRTile = new LightRockRTile(23);
	public static Tile water1100Tile = new Water1100Tile(24);
	public static Tile water1101Tile = new Water1101Tile(25);
	public static Tile water1102Tile = new Water1102Tile(26);
	public static Tile water1200Tile = new Water1200Tile(27);
	public static Tile water1201Tile = new Water1201Tile(28);
	public static Tile water1202Tile = new Water1202Tile(29);
	public static Tile water1300Tile = new Water1300Tile(30);
	public static Tile water1301Tile = new Water1301Tile(31);
	public static Tile water1302Tile = new Water1302Tile(32);
	public static Tile tree1718Tile = new Tree1718Tile(33);
	public static Tile tree1719Tile = new Tree1719Tile(34);
	public static Tile tree1720Tile = new Tree1720Tile(35);
	public static Tile tree1818Tile = new Tree1818Tile(36);
	public static Tile tree1819Tile = new Tree1819Tile(37);
	public static Tile tree1820Tile = new Tree1820Tile(38);
	public static Tile pc1Tile = new Pc1Tile(39);
	public static Tile pc2Tile = new Pc2Tile(40);
	public static Tile pc3Tile = new Pc3Tile(41);
	public static Tile pc4Tile = new Pc4Tile(42);
	public static Tile pc5Tile = new Pc5Tile(43);
	public static Tile pc6Tile = new Pc6Tile(44);
	public static Tile pc7Tile = new Pc7Tile(45);
	public static Tile pc8Tile = new Pc8Tile(46);
	public static Tile pc9Tile = new Pc9Tile(47);
	public static Tile pc10Tile = new Pc10Tile(48);
	public static Tile pc11Tile = new Pc11Tile(49);
	public static Tile pc12Tile = new Pc12Tile(50);
	public static Tile pc13Tile = new Pc13Tile(51);
	public static Tile pc14Tile = new Pc14Tile(52);
	public static Tile pc15Tile = new Pc15Tile(53);
	public static Tile pc16Tile = new Pc16Tile(54);
	public static Tile pc17Tile = new Pc17Tile(55);
	public static Tile pc18Tile = new Pc18Tile(56);
	public static Tile pc19Tile = new Pc19Tile(57);
	public static Tile pc20Tile = new Pc20Tile(58);
	public static Tile pc21Tile = new Pc21Tile(59);
	public static Tile pc22Tile = new Pc22Tile(60);
	public static Tile pc23Tile = new Pc23Tile(61);
	public static Tile pc24Tile = new Pc24Tile(62);
	public static Tile pc25Tile = new Pc25Tile(63);
	
	//CLASS
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	protected Rectangle bounds;
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
		bounds = new Rectangle(0, 0, TILEWIDTH, TILEHEIGHT);
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		Tile.x = x;
		Tile.y = y;
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public static BufferedImage getTile(int id){
		return tiles[id].texture;
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public boolean onTop(){
		return false;
	}
	
	public boolean entrance(){
		return false;
	}
	
	public int getId(){
		return id;
	}
	
	public Rectangle getBounds(){
		return bounds;
	}
	
}
