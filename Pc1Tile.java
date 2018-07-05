package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Pc1Tile extends Tile{

	public Pc1Tile(int id) {
		super(Assets.pc1, id);
	}
	
	public boolean onTop(){
		return true;
	}
}
