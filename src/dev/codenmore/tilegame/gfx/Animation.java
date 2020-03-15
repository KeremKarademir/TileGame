package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Animation {
	private BufferedImage[] frames;
	private int speed;
	private long lastTime,timer;
	private int index; 
	
	public Animation(int speed,BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	public BufferedImage getImage() {
		return frames[index];
	}
	
	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > speed) {
			index++;
			timer = 0;
			if(index >= frames.length) {
				index = 0;
			}
		}
	}
	
}
