package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Pc9Tile extends Tile{

	public Pc9Tile(int id) {
		super(Assets.pc9, id);
	}
	
	public boolean isSolid(){
		return true;
	}

}
