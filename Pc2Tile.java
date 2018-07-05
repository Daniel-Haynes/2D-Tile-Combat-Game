package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Pc2Tile extends Tile{

	public Pc2Tile(int id) {
		super(Assets.pc2, id);
	}
	
	public boolean onTop(){
		return true;
	}

}
