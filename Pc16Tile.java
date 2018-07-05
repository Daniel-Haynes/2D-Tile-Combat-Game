package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Pc16Tile extends Tile{

	public Pc16Tile(int id) {
		super(Assets.pc16, id);
	}
	
	public boolean onTop(){
		return true;
	}
	
	public boolean isSolid(){
		return true;
	}

}
