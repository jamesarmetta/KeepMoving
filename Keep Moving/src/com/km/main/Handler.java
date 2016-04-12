package com.km.main;

import java.awt.Graphics;
import java.util.LinkedList;


public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>();

	public void tick(){
		for(int i =0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	public void render(Graphics g){
		for(int i =0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	public void clearEnemys(){
		for(int i =0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			if(tempObject.getId() == ID.Player)
			{
				object.clear();
				//if(Game.gameState != STATE.End)
				addObject(new Player(tempObject.getX(), tempObject.getY(), ID.Player, this));
			}
		}
	}	
	public void clearPlayer(){
		for(int i =0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			if(tempObject.getId() == ID.Player)
			{
				object.clear();
				//if(Game.gameState != STATE.End)
				removeObject(new Player(tempObject.getX(), tempObject.getY(), ID.Player, this));
			
			}
		}
	}
	
	public void addObject(GameObject Object){
		this.object.add(Object);
	}
	public void removeObject(GameObject Object){
		this.object.remove(Object);
	}
	
}
