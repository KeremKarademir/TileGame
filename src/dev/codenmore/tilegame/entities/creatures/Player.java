package dev.codenmore.tilegame.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;

public class Player extends Creature{
	
	//Animations
	
	private Animation animDown,animUp,animLeft,animRight;

	public Player(Handler handler,float x, float y) {
		super(handler,x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		// TODO Auto-generated constructor stub
		bounds.x = 18;//22
		bounds.y = 32;//44
		bounds.width = 32;//19
		bounds.height = 32;//19
		
		//Animations
		animUp = new Animation(135,Assets.knight_up);
		animDown = new Animation(135,Assets.knight_down);
		animLeft = new Animation(135,Assets.knight_left);
		animRight = new Animation(135,Assets.knight_right);
	}

	@Override
	public void tick() {
		//animation
		animUp.tick();
		animDown.tick();
		animLeft.tick();
		animRight.tick();
		//movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	public void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().W)
			yMove -= speed;
		if(handler.getKeyManager().S)
			yMove += speed;
		if(handler.getKeyManager().A)
			xMove -= speed;
		if(handler.getKeyManager().D)
			xMove += speed;
	}
	
	public void fire() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentImage(),(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()),width,height, null);
		//g.setColor(Color.CYAN);
		//g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),(int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}
	
	private BufferedImage getCurrentImage() {
		if(xMove > 0) {
			return animRight.getImage();
		}
		if(xMove < 0) {
			return animLeft.getImage();
		}
		if(yMove > 0) {
			return animDown.getImage();
		}
		if(yMove < 0) {
			return animUp.getImage();
		}
		return Assets.knight;
	}

}

