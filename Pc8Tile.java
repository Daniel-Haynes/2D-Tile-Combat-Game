package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Pc8Tile extends Tile{

	public Pc8Tile(int id) {
		super(Assets.pc8, id);
	}
	
	public boolean isSolid(){
		return true;
	}

}
