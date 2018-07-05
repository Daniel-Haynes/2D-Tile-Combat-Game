package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Tree1819Tile extends Tile{

	public Tree1819Tile(int id) {
		super(Assets.tree1819, id);
	}

	public boolean isSolid(){
		return true;
	}
}
