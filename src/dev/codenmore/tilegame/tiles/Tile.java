package dev.codenmore.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static final int TILEWIDTH = 64,TILEHEIGHT = 64;
	
	public static Tile[] tiles = new Tile[256];
	public static GroundTile ground = new GroundTile(0);
	public static GrassTile grass = new GrassTile(1);
	
	BufferedImage texture;
	int id;
	
	public Tile(BufferedImage texture , int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public int getId() {
		return id;
	}

	public void tick() {
		
	}
	
	public void render(Graphics g,int x,int y) {
		g.drawImage(texture, x, y,TILEWIDTH,TILEHEIGHT, null);
	}
	
	public boolean isSolid() {
		return false;
	}
}
