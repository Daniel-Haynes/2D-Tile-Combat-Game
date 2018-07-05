package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Pc21Tile extends Tile{

	public Pc21Tile(int id) {
		super(Assets.pc21, id);
	}
	
	public boolean isSolid(){
		return true;
	}
}
