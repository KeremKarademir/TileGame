package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.worlds.World;

public abstract class State {
	
	protected Handler handler;
	public static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	//
	
	public State(Handler handler) {
		this.handler = handler;
	}

	public abstract void render(Graphics g);
	
	public abstract void tick();
}
