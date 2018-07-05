package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Tree1818Tile extends Tile{

	public Tree1818Tile(int id) {
		super(Assets.tree1818, id);
	}
	
	public boolean onTop(){
		return true;
	}

}
