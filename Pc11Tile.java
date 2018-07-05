package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Pc11Tile extends Tile{

	public Pc11Tile(int id) {
		super(Assets.pc11, id);
	}
	
	public boolean onTop(){
		return true;
	}
	
	public boolean isSolid(){
		return true;
	}

}
