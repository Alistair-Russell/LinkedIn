package com.wayne.bomberman.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import com.wayne.bomberman.objects.Bomb;
import com.wayne.bomberman.objects.Player;
import com.wayne.bomberman.windows.Handler;
import com.wayne.bomberman.windows.game;

public class KeyInput extends KeyAdapter {

	long time1;
	public static long tBomb;
	Handler handler;
	Timer timer;//bomb timer
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	public static boolean spaceEnabled = true;
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_ESCAPE){
			System.exit(1);
		}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
//
//in game controls
		
		if(game.State==STATE.GAME)
		{
			for(int i=0; i<handler.object.size(); i++)
			{
				GameObject tempObject = handler.object.get(i);
				if(tempObject.getId()== ObjectId.Player)
				{
					//movements
					if(Player.speed>8) Player.speed=8;//max speed is 8, greater than 8 produces bug/glitch of ending outside of game grid
					if(key == KeyEvent.VK_D) tempObject.moveRight(Player.speed);
					if(key == KeyEvent.VK_A) tempObject.moveLeft(Player.speed);
					if(key == KeyEvent.VK_W) tempObject.moveUp(Player.speed);
					if(key == KeyEvent.VK_S) tempObject.moveDown(Player.speed);
					
					
					
					//bomb drop
					if(key==KeyEvent.VK_SPACE && spaceEnabled)
					{
						Position target = new Position(tempObject.getPosition().getX(), tempObject.getPosition().getY());
						Handler.bomb = new Bomb(target, ObjectId.Bomb);
						tBomb = System.currentTimeMillis();
						
						spaceEnabled = false;
						
					}
					
					if(key==KeyEvent.VK_P){
						game.State = STATE.PAUSE;
					}
				}
			}
		}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	if(game.State==STATE.GAMECOVER)
	{
		if(key == KeyEvent.VK_SPACE){
			game.State = STATE.MENU;
		}
	}
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		

		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		

		
	}
	@Override
	
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		if(game.State==STATE.GAME)
		{
			for(int i=0; i<handler.object.size(); i++)
			{
				GameObject tempObject = handler.object.get(i);
				
				if(tempObject.getId()== ObjectId.Player)
				{
					if(key == KeyEvent.VK_D && tempObject.velX > 0) tempObject.setVelX(0);
					if(key == KeyEvent.VK_A && tempObject.velX < 0) tempObject.setVelX(0);
					if(key == KeyEvent.VK_W && tempObject.velY < 0) tempObject.setVelY(0);
					if(key == KeyEvent.VK_S && tempObject.velY > 0)tempObject.setVelY(0);
					
				}
			}
		}

	}
}
