package dev.codenmore.tilegame.tiles;

import java.awt.Rectangle;

import dev.codenmore.tilegame.gfx.Assets;

public class TreeBaseLTile extends Tile{

	public TreeBaseLTile(int id) {
		super(Assets.treeBaseL, id);
		bounds = new Rectangle(10, 10, TILEWIDTH, TILEHEIGHT);
	}
	
	public boolean isSolid(){
		return true;
	}

}
