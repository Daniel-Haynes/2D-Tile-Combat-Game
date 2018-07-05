package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class TreeMidLTile extends Tile{

	public TreeMidLTile(int id) {
		super(Assets.treeMidL, id);
	}
	
	public boolean onTop(){
		return true;
	}

}
