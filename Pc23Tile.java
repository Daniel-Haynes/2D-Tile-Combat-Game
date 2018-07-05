package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Pc23Tile extends Tile{

	public Pc23Tile(int id) {
		super(Assets.pc23, id);
	}
	
	public boolean isSolid(){
		return true;
	}
	
	public boolean entrance(){
		return true;
	}

}
