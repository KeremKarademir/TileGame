package dev.codenmore.tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dev.codenmore.tilegame.Game;

public class KeyManager implements KeyListener{
	
	private boolean[] keys;
	public boolean W,A,S,D,up,down,left,right;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		W = keys[KeyEvent.VK_W];
		S = keys[KeyEvent.VK_S];
		A = keys[KeyEvent.VK_A];
		D = keys[KeyEvent.VK_D];
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN]; 
		left = keys[KeyEvent.VK_LEFT]; 
		right = keys[KeyEvent.VK_RIGHT]; 
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true; 
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
