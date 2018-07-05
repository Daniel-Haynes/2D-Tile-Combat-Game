package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Tree1820Tile extends Tile{

	public Tree1820Tile(int id) {
		super(Assets.tree1820, id);
	}
	
	public boolean isSolid(){
		return true;
	}


}
