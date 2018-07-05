package dev.codenmore.tilegame.tiles;

import dev.codenmore.tilegame.gfx.Assets;

public class Pc22Tile extends Tile{

	public Pc22Tile(int id) {
		super(Assets.pc22, id);
	}
	
	public boolean isSolid(){
		return true;
	}
}
