package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class TreeBaseRTile extends Tile{

	public TreeBaseRTile(int id) {
		super(Assets.treeBaseR, id);
	}
	
	public boolean isSolid(){
		return true;
	}

}
