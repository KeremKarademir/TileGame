package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	static final int width = 32,height = 32;
	public static BufferedImage knight,cyclops,dragon,goblin,ground,castle,grass;
	public static BufferedImage[] knight_up,knight_down,knight_left,knight_right;
	public static BufferedImage tree;
	
	public static void init() {
		SpriteSheet tiles = new SpriteSheet(ImageLoader.LoadImage("/textures/tiles.png"));
		SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/test.png"));
		SpriteSheet tileset = new SpriteSheet(ImageLoader.LoadImage("/textures/tileset.png"));
		SpriteSheet tree_tiles = new SpriteSheet(ImageLoader.LoadImage("/textures/tree_tiles.png"));
		
		knight_up = new BufferedImage[2];
		knight_down = new BufferedImage[2];
		knight_left = new BufferedImage[2];
		knight_right = new BufferedImage[2];
		
		knight_up[0] = sheet.crop(0, 0, width, height);
		knight_up[1] = sheet.crop(width, 0, width, height);
		knight_down[0] = sheet.crop(width*8, 0, width, height);
		knight_down[1] = sheet.crop(width*9, 0, width, height);
		knight_left[0] = sheet.crop(width*12, 0, width, height);
		knight_left[1] = sheet.crop(width*13, 0, width, height);
		knight_right[0] = sheet.crop(width*4, 0, width, height);
		knight_right[1] = sheet.crop(width*5, 0, width, height);
		
		tree = tree_tiles.crop(160, 0, width*3, height*3);
		knight = sheet.crop(width*20, 0, width, height);
		cyclops = sheet.crop(0, height*7, width*2, height*2);
		dragon = sheet.crop(0, height*11, width*2, height*2);
		goblin = sheet.crop(width*9, height*5, width, height);
		ground = tiles.crop(0, 433, width, height); //bak burasý þaibeli biraz!!!
		grass = tileset.crop(100, 100, width, height);
	}
}
