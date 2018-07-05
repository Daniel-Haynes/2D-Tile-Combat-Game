package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Pc6Tile extends Tile{

	public Pc6Tile(int id) {
		super(Assets.pc6, id);
	}
	
	public boolean onTop(){
		return true;
	}
	
	public boolean isSolid(){
		return true;
	}

}
