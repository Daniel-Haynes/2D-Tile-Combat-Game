package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Pc4Tile extends Tile{

	public Pc4Tile(int id) {
		super(Assets.pc4, id);
	}
	
	public boolean onTop(){
		return true;
	}

}
