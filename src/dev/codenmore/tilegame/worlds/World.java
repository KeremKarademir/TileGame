package dev.codenmore.tilegame.worlds;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.EntityManager;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.entities.statics.Tree;
import dev.codenmore.tilegame.tiles.Tile;
import dev.codenmore.tilegame.utils.Util;

public class World {
	
	private Handler handler;
	private int[][] tiles;
	private int width,height;
	int spawnX;
	int spawnY;
	
	private EntityManager entityManager;
	
	public World(Handler handler,String path){
		this.handler = handler;
		entityManager = new EntityManager(handler,new Player(handler,100,100));
		entityManager.addEntity(new Tree(handler,100,250));
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void loadWorld(String path) {
		
		String file = Util.loadFileAsSting(path);
		String[] tokens = file.split("\\s+");
		
		width = Util.parseInt(tokens[0]);
		height = Util.parseInt(tokens[1]);
		spawnX = Util.parseInt(tokens[2]);
		spawnY = Util.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++) {
			for(int x = 0;x < width ;x++) {
				tiles[x][y] = Util.parseInt(tokens[(x+y * width) + 4]);
			}
		}
	}
	
	public void tick() {
		entityManager.tick();
	}
	
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, (handler.getGameCamera().getxOffset()/Tile.TILEWIDTH));
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, (handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT));
		int yEnd = (int) Math.min(height,  (handler.getGameCamera().getyOffset() + handler.getHeight())/Tile.TILEHEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++) {
			for(int x = xStart;x < xEnd;x++) {
				getTile(x,y).render(g, (int) (x*Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), (int) (y*Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		entityManager.render(g);
	}
	
	public Tile getTile(int x,int y) {
		if(x<0||y<0||x>=width||y>=height) {
			return Tile.grass;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t==null) {
			return Tile.ground;
		}
		return t;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
