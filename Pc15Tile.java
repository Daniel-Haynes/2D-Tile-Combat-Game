package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Pc15Tile extends Tile{

	public Pc15Tile(int id) {
		super(Assets.pc15, id);
	}
	
	public boolean isSolid(){
		return true;
	}

}
