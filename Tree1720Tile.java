package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Tree1720Tile extends Tile{

	public Tree1720Tile(int id) {
		super(Assets.tree1720, id);
	}
	
	public boolean isSolid(){
		return true;
	}

}
