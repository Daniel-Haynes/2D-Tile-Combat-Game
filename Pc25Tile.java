package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Pc25Tile extends Tile{

	public Pc25Tile(int id) {
		super(Assets.pc25, id);
	}
	
	public boolean isSolid(){
		return true;
	}

}
