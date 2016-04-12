package com.km.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{

	Random r = new Random();
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		//velX = r.nextInt(5) + 1;
		//velY = r.nextInt(5);
		
	}
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}


	
	@Override
	public void tick() {
		x +=velX;
		y +=velY;

		x = Game.clamp((int)x, 0, Game.WIDTH -37);
		y = Game.clamp((int)y, 0, Game.HEIGHT -60);
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.white, 32, 32, 0.07f, handler));
		
		/*
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		*/
		
		collision();
	}

	private void collision(){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() ==ID.FastEnemy || tempObject.getId() ==ID.SmartEnemy || tempObject.getId() ==ID.EnemyBoss){//tempObject is now BasicEnemy
				if(getBounds().intersects(tempObject.getBounds())){
					//collision code
					HUD.HEALTH -= 2;
					
				}
			}
			
		}
	}
	
	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 32, 32);
	}

}
