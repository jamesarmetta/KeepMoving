package com.km.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	
	public static int HEALTH = 100;
	
	public static int score = 0;
	static int level = 1;
	
	public static int Hscore = 0;
	static int Hlevel = 1;
	
	private int greenValue = 255;
	//private int score = 0;
	//private int level = 1;


	public void tick(){
		HEALTH = (int) Game.clamp(HEALTH, 0, 100);
		greenValue = (int) Game.clamp(greenValue, 0, 255);
		
		greenValue = HEALTH * 2;
		
		score++;
	}
	
	public void render(Graphics g){
		Font fnt = new Font("arial", 1, 15);
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(75, greenValue, 0));
		g.fillRect(15, 15, HEALTH * 2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		g.setFont(fnt);
		g.drawString("Score: " + score, 15, 64);
		g.drawString("level: " + level, 15, 80);
	}
	
	public void score(int score){
		//this.score = score;
		HUD.score = score;
	}
	public int getscore(){
		return score;
	}
	public int getlevel(){
		return level;
	}
	public void setlevel(int level){
		//this.level = level;
		HUD.level = level;
	}
	
	public void Hscore(int Hscore){
		//this.score = score;
		HUD.Hscore = Hscore;
	}
	public int getHscore(){
		return Hscore;
	}
	public int getHlevel(){
		return Hlevel;
	}
	public void setHlevel(int Hlevel){
		//this.level = level;
		HUD.Hlevel = Hlevel;
	}
}
