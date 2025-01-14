package com.wayne.bomberman.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.wayne.bomberman.framework.GameObject;
import com.wayne.bomberman.framework.ObjectId;
import com.wayne.bomberman.framework.Position;
import com.wayne.bomberman.framework.Texture;
import com.wayne.bomberman.windows.game;

public class Power extends GameObject{

	Texture tex = game.getInstance();
	int type;
	int powerDouble = 0;
	int powerSpeed = 1;
	int powerHealth = 2;
	int powerRange = 3;
	
	static int typeHolder;
	
	public Power(Position p, int type, ObjectId id) {
		super(p, id);
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		if(type==0)
			g.drawImage(tex.power[0], (int) position.x, (int) position.y, null);
		if(type==1)
			g.drawImage(tex.power[1], (int) position.x, (int) position.y, null);
		if(type==2)
			g.drawImage(tex.power[2], (int) position.x, (int) position.y, null);
		if(type==3)
			g.drawImage(tex.power[3], (int) position.x, (int) position.y, null);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(position.x, position.y, 32,32); 
		
	}

	//increases player speed
	public static void speedUp(int type){
		Player.speed=Player.speed*2;
	}
	
	//increases max bomb placement in an interval
	public static void doubleUp(int type){
		game.score=game.score*2;
	}
	
	//gives ability to kick the bomb
	public static void healthUp(int type){
		Player.health++;
	}
	
	public static void rangeUp(int type){
		Bomb.range+=32;
	}
	
	public static boolean consumed(Power power, LinkedList<GameObject> object) {
		boolean consumed = false;
		if(power!=null) {
			Rectangle rect1=game.player.getBounds();
			Rectangle rect2=power.getBounds();
			
			if(rect1.intersects(rect2)) {
				consumed = true;
				selectPower(typeHolder);
			} else {
				consumed = false;
			}
		}
		return consumed;
	}
	
	public static void selectPower(int type){
		if(Power.typeHolder == 0)
			Power.healthUp(Power.typeHolder);
		if(Power.typeHolder == 1)
			Power.doubleUp(Power.typeHolder);
		if(Power.typeHolder == 2)
			Power.rangeUp(Power.typeHolder);
		if(Power.typeHolder == 3)
			Power.speedUp(Power.typeHolder);
	}

	@Override
	public boolean isBombed(Bomb bomb) {
		// TODO Auto-generated method stub
		return false;
	}
}
