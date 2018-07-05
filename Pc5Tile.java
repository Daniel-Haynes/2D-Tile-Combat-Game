package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Pc5Tile extends Tile{

	public Pc5Tile(int id) {
		super(Assets.pc5, id);
	}
	
	public boolean onTop(){
		return true;
	}

}
