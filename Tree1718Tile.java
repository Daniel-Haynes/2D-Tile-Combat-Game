package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Tree1718Tile extends Tile{

	public Tree1718Tile(int id) {
		super(Assets.tree1718, id);
	}
	
	public boolean onTop(){
		return true;
	}

}
