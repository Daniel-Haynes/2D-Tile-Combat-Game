package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class TreeTopRTile extends Tile{

	public TreeTopRTile(int id) {
		super(Assets.treeTopR, id);
	}
	
	public boolean onTop(){
		return true;
	}

}
