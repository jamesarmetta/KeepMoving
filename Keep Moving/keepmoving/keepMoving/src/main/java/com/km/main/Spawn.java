package com.km.main;

import java.util.Random;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	private int scoreKeep = 0;
	
	
	public Spawn(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick(){
		scoreKeep++;
				
			
		if(scoreKeep >= 350){
			scoreKeep = 0;
			hud.setlevel(hud.getlevel() + 1);
			
			
			if(hud.getlevel() == 2){
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
			}else if (hud.getlevel() == 3){
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
			}else if (hud.getlevel() == 4){
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
			}else if (hud.getlevel() == 5){
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
			}else if (hud.getlevel() == 6){
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.SmartEnemy, handler));
			}else if (hud.getlevel() == 7){
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
			}else if (hud.getlevel() == 10){
				handler.clearEnemys();
				handler.addObject(new EnemyBoss((Game.WIDTH / 2)-48, -120, ID.EnemyBoss, handler));
			}else if (hud.getlevel() == 15){
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
			}else if (hud.getlevel() == 25){
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
			}else if (hud.getlevel() == 30){
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
			}else if (hud.getlevel() == 35){
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
			}else if (hud.getlevel() == 40){
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
			}else if (hud.getlevel() == 50){
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
			}else if (hud.getlevel() == 60){
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
			}else if(hud.getlevel() == 70){
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
			}else if(hud.getlevel() == 80){
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
			}else if(hud.getlevel() == 90){
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
			}else if(hud.getlevel() == 100){
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
			}else if (hud.getlevel() == 101){
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.SmartEnemy, handler));
			}
	
		
		}
	}
}
