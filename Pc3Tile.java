package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Pc3Tile extends Tile{

	public Pc3Tile(int id) {
		super(Assets.pc3, id);
	}
	
	public boolean onTop(){
		return true;
	}

}
