package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Pc20Tile extends Tile{

	public Pc20Tile(int id) {
		super(Assets.pc20, id);
	}
	
	public boolean isSolid(){
		return true;
	}

}
