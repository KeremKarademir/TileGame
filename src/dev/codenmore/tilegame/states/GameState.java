package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.worlds.World;

public class GameState extends State{
	
	private Player player;
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler,"C:/Users/Kerem/eclipse-workspace/TileGane/res/world1.txt");
		handler.setWorld(world);
		player = new Player(handler,100,100);
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
		//handler.getGameCamera().centerOnEntity(player);
	}

	@Override
	public void tick() {
		player.tick();
		world.tick();
		handler.getGameCamera().centerOnEntity(player); //render'dan update'e aldýk hata olursa geri alýrýz.
	}
	
	public World getWorld() {
		return world;
	}

}
