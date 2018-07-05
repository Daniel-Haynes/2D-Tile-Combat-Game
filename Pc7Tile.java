package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Pc7Tile extends Tile{

	public Pc7Tile(int id) {
		super(Assets.pc7, id);
	}
	
	public boolean isSolid(){
		return true;
	}

}
