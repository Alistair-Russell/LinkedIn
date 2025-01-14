package com.wayne.bomberman.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import com.wayne.bomberman.framework.GameObject;
import com.wayne.bomberman.framework.ObjectId;
import com.wayne.bomberman.framework.Position;
import com.wayne.bomberman.framework.Texture;
import com.wayne.bomberman.windows.game;

public class Crate extends GameObject{

	
	Texture tex = game.getInstance();
	
	public Crate(Position p, float y, ObjectId id) {
		super(p, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(tex.crate[0], (int) position.x, (int) position.y, null);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) position.x, (int)position.y, 32,32); 
		}

	public boolean isBombed(Bomb bomb){
		
		
		Rectangle rect1=new Rectangle(bomb.position.x-bomb.range,bomb.position.y,32+2*bomb.range,32);
		Rectangle rect2=new Rectangle(bomb.position.x,bomb.position.y-bomb.range,32,32+2*bomb.range);
		Rectangle rect3=new Rectangle(this.position.x,this.position.y,32,32);
		
		
		if(rect1.intersects(rect3)||rect2.intersects(rect3)){
			game.score+=10;
			
			
			return true;
		}
		else{
			return false;
		}
		}

}