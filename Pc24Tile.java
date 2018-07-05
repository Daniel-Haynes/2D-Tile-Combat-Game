package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Pc24Tile extends Tile{

	public Pc24Tile(int id) {
		super(Assets.pc24, id);
	}
	
	public boolean isSolid(){
		return true;
	}

}
