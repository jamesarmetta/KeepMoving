package com.km.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.km.main.Game.STATE;

public class Menu extends MouseAdapter   {
	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12*9;
	
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	
	
	public Menu(Game game, Handler handler, HUD hud){
		this.setGame(game);
		this.hud = hud;
		this.handler = handler;
	}

	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		if(Game.gameState == STATE.Menu){
			//play button
			if(mouseOver(mx, my, 210, 150, 200, 64)){
				Game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemys();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
			
				// add click sounds here
			}
			
			//help button
			if(mouseOver(mx, my, 210, 250, 200, 64)){
				Game.gameState = STATE.Help;
				
				// add click sounds here
			}
			
			//quit button
			if(mouseOver(mx, my, 210, 350, 200, 64)){
				System.exit(1);
			}
		}
		
		
		//back button for help
			if(Game.gameState == STATE.Help){
				if(mouseOver(mx, my, 210, 350, 200, 64)){
					Game.gameState = STATE.Menu;
					
					// add click sounds here
					
					return;
					
					
				}
			}
			
			if(Game.gameState == STATE.End){
				//Try Again button
				if(mouseOver(mx, my, 210, 350, 200, 64)){
					
					Game.gameState = STATE.Menu;
					
				}
			}
			
	}
	
	public void mouseReleas(MouseEvent e){
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if(mx > x && mx < x + width){
			if (my > y && my < y + height){
				return true;	
			
			}else return false;
		}else return false;
	}
	
	public void tick(){
		
	}
	public void render(Graphics g){
		if(Game.gameState == STATE.Menu){
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 10);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Keep Moving", 160, 80);
			
			g.setFont(fnt2);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Play", 270, 190);
			
			g.setFont(fnt2);
			g.drawRect(210, 250, 200, 64);
			g.drawString("Help", 270, 290);
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Quit", 270, 390);
			
			g.setFont(fnt3);
			g.setColor(Color.ORANGE);
			g.drawString("Coded By James Armetta", 490, 430);
			
		}else if(Game.gameState == STATE.Help){
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);
			
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", 240, 80);
			
			g.setFont(fnt3);
			g.drawString("Use WASD or Arrow keys to move and dodge the enemies", 50, 150);
			
			g.setFont(fnt3);
			g.drawString("To reach the next level you need to gain 350 points", 50, 180);
			
			g.setFont(fnt3);
			g.drawString("You gain points over time so keep moving to earn more", 50, 210);
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 270, 390);
		}else if(Game.gameState == STATE.End){
			Font fnt = new Font("arial", 1, 50);
			Font fnt3 = new Font("arial", 1, 20);
			Font fnt4 = new Font("arial", 1, 20);
			
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game Over", 180, 80);
			
			g.setFont(fnt3);
			g.drawString("You lost with a score of: " + hud.getscore(), 50, 155);
			
			g.setFont(fnt3);
			g.drawString("You lost at level: " + hud.getlevel(), 50, 180);
			
			g.setFont(fnt3);
			g.drawString("Highest score is: " + hud.getHscore(), 50, 215);
			
			g.setFont(fnt3);
			g.drawString("Highest level is: " + hud.getHlevel(), 50, 240);
			
			g.setFont(fnt4);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back To Menu", 240, 390);
		}else if(Game.gameState == STATE.Pause){
			Font fnt = new Font("arial", 1, 50);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Paused Game", 180, 80);
			
		}
		
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
