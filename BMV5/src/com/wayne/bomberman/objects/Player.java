package com.wayne.bomberman.objects;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.wayne.bomberman.framework.Animations;
import com.wayne.bomberman.framework.GameObject;
import com.wayne.bomberman.framework.MouseInput;
import com.wayne.bomberman.framework.ObjectId;
import com.wayne.bomberman.framework.Position;
import com.wayne.bomberman.framework.Texture;
import com.wayne.bomberman.windows.Handler;
import com.wayne.bomberman.windows.game;

public class Player extends GameObject {

	private int width =32, height = 32;
	
	private Handler handler;
	//player speed values
	private final static int defaultVel=4;
	public static int speed = defaultVel;
	
	//health
	public static Integer health;
	public static int nbBomb;
	
	public static long tHit;
	
	public static boolean invincible=false;
	
	
	//player bomb drops
	
	//player bomb kick ability
	private final static boolean defaultKick=false;
	public static boolean kick = defaultKick;
	
	Texture tex = game.getInstance();
	
	private Animations playerWalkLeft, playerWalkRight,playerWalkDown, playerWalkUp;
	
	public Player(Position p, Handler handler, ObjectId id) {
		super(p, id);
		this.handler = handler;
		health = 3;
		game.timeLeft = game.gameTime;
		nbBomb = 1;
		speed = defaultVel;
		
		//walking animations
		playerWalkLeft = new Animations(5, tex.player[1], tex.player[2], tex.player[3]);
		playerWalkRight = new Animations(5, tex.player[4], tex.player[5], tex.player[6]);
		playerWalkDown = new Animations(5, tex.player[7], tex.player[8]);
		playerWalkUp = new Animations(5, tex.player[9], tex.player[10], tex.player[11]);
		
	}

	public void tick(LinkedList<GameObject> object) {
		
		position.x += velX;
		position.y += velY;
		
		Collision(object);
		
		playerWalkLeft.runAnimation();
		playerWalkRight.runAnimation();
		playerWalkDown.runAnimation();
		playerWalkUp.runAnimation();
	}
	private void Collision(LinkedList<GameObject> object){
		
		for(int i = 0; i< handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Block){
				
				if(getBoundsTop().intersects(tempObject.getBounds()))
				{
					position.y = tempObject.getPosition().getY() + 32;
				
				}
				
				if(getBounds().intersects(tempObject.getBounds()))
				{
					position.y = tempObject.getPosition().getY() - height;
				
				}
			
				//right
				if(getBoundsRight().intersects(tempObject.getBounds()))
				{
					position.x = tempObject.getPosition().getX() - width;
				
				}
				//left
				if(getBoundsLeft().intersects(tempObject.getBounds()))
				{
					position.x = tempObject.getPosition().getX() + 32;
					
				}
			}
			if(tempObject.getId() == ObjectId.Power){
				
				if(getBoundsTop().intersects(tempObject.getBounds()))
				{
					position.y = tempObject.getPosition().getY() + 32;
				
				}
				
				if(getBounds().intersects(tempObject.getBounds()))
				{
					position.y = tempObject.getPosition().getY() - height;
				}
			
				//right
				if(getBoundsRight().intersects(tempObject.getBounds()))
				{
					position.x = tempObject.getPosition().getX() - width;
				
				}
				//left
				if(getBoundsLeft().intersects(tempObject.getBounds()))
				{
					position.x = tempObject.getPosition().getX() + 32;
					
				}
			}
			if(Handler.bomb!=null && Handler.bomb.getId() == ObjectId.Block){

				if(getBoundsTop().intersects(Handler.bomb.getBounds()))
				{
					position.y = Handler.bomb.getPosition().getY() + 32;
				
				}
				
				if(getBounds().intersects(Handler.bomb.getBounds()))
				{
					position.y = Handler.bomb.getPosition().getY() - height;
				
				}
			
				//right
				if(getBoundsRight().intersects(Handler.bomb.getBounds()))
				{
					position.x = Handler.bomb.getPosition().getX() - width;
				
				}
				//left
				if(getBoundsLeft().intersects(Handler.bomb.getBounds()))
				{
					position.x = Handler.bomb.getPosition().getX() + 32;
					
				}
			}
			
			
		}
			
	}

	
	public void render(Graphics g) {
	
		if(velX!=0 && velX <0)
			playerWalkLeft.drawAnimation(g, position.x, position.y,32,32);
		else if(velX!=0 && velX >0)
			playerWalkRight.drawAnimation(g, position.x,  position.y, 32, 32);
		else if(velY!=0 && velY >0)
			playerWalkDown.drawAnimation(g, position.x,  position.y, 32, 32);
		else if(velY!=0 && velY <0)
			playerWalkUp.drawAnimation(g, position.x,  position.y, 32, 32);
		else
			g.drawImage(tex.player[0], (int)position.x, (int) position.y, null);
	
		
	}

//Boundaries 

		public Rectangle getBounds() {
			return new Rectangle((int) (position.getX()+(width/2)-((width/2)/2)), (int) ((int) position.getY()+(14)), (int) width/2, (int) height/2);
		}
		public Rectangle getBoundsTop() {
			return new Rectangle((int) (position.getX()+(width/2)-((width/2)/2)), (int) position.getY(), (int) width/2, (int) height/2);
		}
		public Rectangle getBoundsRight() {
			return new Rectangle((int) (position.getX()+width-5), (int) position.getY()+5, (int) 4, (int) height-12);
		}
		public Rectangle getBoundsLeft() {
			return new Rectangle((int) position.getX(), (int) position.getY()+1, (int) 4, (int) height-4);
		}

		@Override
		public boolean isBombed(Bomb bomb) {
			Rectangle rect1=new Rectangle(bomb.position.x-bomb.range,bomb.position.y,32+2*bomb.range,32);
			Rectangle rect2=new Rectangle(bomb.position.x,bomb.position.y-bomb.range,32,32+2*bomb.range);
			Rectangle rect3=new Rectangle(this.position.x,this.position.y,32,32);
			if(rect1.intersects(rect3)||rect2.intersects(rect3)){
				return true;
			}
			else{
				return false;
			}
		}
		
		public boolean isExited(){
			if(position==MouseInput.exitPosition){
				return true;
			}
			return false;
		}
	
}
