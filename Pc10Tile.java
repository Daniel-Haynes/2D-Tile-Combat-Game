package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Pc10Tile extends Tile{

	public Pc10Tile(int id) {
		super(Assets.pc10, id);
	}
	
	public boolean isSolid(){
		return true;
	}

}
