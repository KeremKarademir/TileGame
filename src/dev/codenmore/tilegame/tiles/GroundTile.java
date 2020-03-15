package dev.codenmore.tilegame.tiles;

import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.gfx.Assets;

public class GroundTile extends Tile{
	
	public GroundTile(int id) {
		super(Assets.ground, id);
	}
	
	@Override
	public boolean isSolid() {
		return false;
	}
	
	
}
