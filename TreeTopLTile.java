package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class TreeTopLTile extends Tile{

	public TreeTopLTile(int id) {
		super(Assets.treeTopL, id);
	}
	
	public boolean onTop(){
		return true;
	}

}
