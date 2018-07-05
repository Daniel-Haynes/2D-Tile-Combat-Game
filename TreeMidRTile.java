package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class TreeMidRTile extends Tile{

	public TreeMidRTile(int id) {
		super(Assets.treeMidR, id);
	}
	
	public boolean onTop(){
		return true;
	}

}
