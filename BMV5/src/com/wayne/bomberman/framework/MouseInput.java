package com.wayne.bomberman.framework;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import com.wayne.bomberman.windows.game;

public class MouseInput implements MouseListener{

	public static int levelNum;
	public static Position exitPosition;
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
		int mx = e.getX();
		int my = e.getY();
		
///////////////////////////////////////////////////////////////////////////////////////////////
		// inputs for game cover
		
		if(game.State == STATE.GAMECOVER)
			game.State = STATE.MENU;
		
///////////////////////////////////////////////////////////////////////////////////////////////
		
		//Mouse inputs for MENU
		
		
		if(game.State==STATE.MENU)
		{
			if(mx >=30 && mx<= 230)
			{
				if(my >=75 && my<= 125)
				{
					levelNum=1;
					game.State= STATE.GAME;
					exitPosition = new Position(512,416);
					game.score = 0;
				}
			}
		
			if(mx >=30 && mx<= 230)
			{
				if(my >=150 && my<= 200)
				{
					game.State= STATE.LEVELSELECT;
				}
			}
			
			if(mx >=30 && mx<= 230)
			{
				if(my >=225 && my<= 275)
				{
					game.State= STATE.HIGHSCORE;
				}
			}
			
			if(mx >=30 && mx<= 230)
			{
				if(my >=300 && my<= 350)
				{
					game.State= STATE.HOWTOPLAY;
				}
			}
			if(mx >=30 && mx<= 230)
			{
				if(my >=375 && my<= 425)
				{
					game.State = STATE.CREDITS;
				}
			}
			if(mx >=30 && mx<= 230)
			{
				if(my >=450 && my<= 500)
				{
					System.exit(1);
				}
			}
		}
///////////////////////////////////////////////////////////////////////////////////////////////
		//Mouse buttons for LEVEL SELECT
		
		//Mouse buttons for LEVEL SELECT
				if(game.State==STATE.LEVELSELECT){
					if(mx >=365 && mx<= 520)//back to main menu
					{
						if(my >= 475 && my<= 525)
						{
							game.State = STATE.MENU;
						}
					}
				}
				if(game.State==STATE.LEVELSELECT){
					if(mx >=450 && mx<= 575)
					{
						if(my >= 125 && my<= 175)
						{
							game.State = STATE.GAME;
							levelNum=1;
							exitPosition=new Position(512,416);
						}
					}
				}
				if(game.State==STATE.LEVELSELECT){
					if(mx >=450 && mx<= 575)
					{
						if(my >= 200 && my<= 250)
						{
							game.State = STATE.GAME;
							levelNum=2;
							exitPosition=new Position(512,416);
						}
					}
				}
				if(game.State==STATE.LEVELSELECT){
					if(mx >=450 && mx<= 575)					{
						if(my >= 275 && my<= 325)
						{
							game.State = STATE.GAME;
							levelNum=3;
							exitPosition=new Position(512,416);
						}
					}
				}
				if(game.State==STATE.LEVELSELECT){
					if(mx >=450 && mx<= 575)
					{
						if(my >= 350 && my<= 400)
						{
							game.State = STATE.GAME;
							levelNum=4;
							exitPosition=new Position(512,416);
						}
					}
				}
				if(game.State==STATE.LEVELSELECT){
					if(mx >=450 && mx<= 575)
					{
						if(my >= 425 && my<= 475)
						{
							game.State = STATE.GAME;
							levelNum=5;
							exitPosition=new Position(512,416);
						}
					}
				}
				if(game.State==STATE.LEVELSELECT){
					if(mx >=650 && mx<= 775)
					{
						if(my >= 125 && my<= 175)
						{
							game.State = STATE.GAME;
							levelNum=6;
							exitPosition=new Position(512,416);
						}
					}
				}
				if(game.State==STATE.LEVELSELECT){
					if(mx >=650 && mx<= 775)
					{
						if(my >= 200 && my<= 250)
						{
							game.State = STATE.GAME;
							levelNum=7;
							exitPosition=new Position(512,416);
						}
					}
				}
				if(game.State==STATE.LEVELSELECT){
					if(mx >=650 && mx<= 775)
					{
						if(my >= 275 && my<= 325)
						{
							game.State = STATE.GAME;
							levelNum=8;
							exitPosition=new Position(64,256);
						}
					}
				}
				if(game.State==STATE.LEVELSELECT){
					if(mx >=650 && mx<= 775)
					{
						if(my >= 350 && my<= 400)
						{
							game.State = STATE.GAME;
							levelNum=9;
							exitPosition = new Position(608,352);
						}
					}
				}
				if(game.State==STATE.LEVELSELECT){
					if(mx >=650 && mx<= 775)
					{
						if(my >= 425 && my<= 475)
						{
							game.State = STATE.GAME;
							levelNum=10;
							exitPosition = new Position(608,352);
							
						}
					}
				}
		
		
		if(game.State==STATE.LEVELSELECT){
			if(mx >=535 && mx<= 690)//back to main menu
			{
				if(my >= 500 && my<= 550)
				{
					game.State = STATE.MENU;
				}
			}
		}
///////////////////////////////////////////////////////////////////////////////////////////////
		//Mouse buttons for How To Play
		if(game.State==STATE.HOWTOPLAY){
			if(mx >=650 && mx<= 770)
			{
				if(my >= 540 && my<= 580)
				{
					game.State = STATE.MENU;
				}
			}
		
		}
///////////////////////////////////////////////////////////////////////////////////////////////
		//Mouse buttons for high scores
		if(game.State==STATE.HIGHSCORE){
			if(mx >=650 && mx<= 770)
			{
				if(my >= 540 && my<= 580)
				{
					game.State = STATE.MENU;
				}
			}
		}
///////////////////////////////////////////////////////////////////////////////////////////////
		//Mouse buttons for credits
		if(game.State==STATE.CREDITS){
			if(mx >=650 && mx<= 770)
			{
				if(my >= 540 && my<= 580)
				{
					game.State = STATE.MENU;
				}
			}
		}
		
///////////////////////////////////////////////////////////////////////////////////////////////
		//Mouse buttons for credits
		if(game.State==STATE.PAUSE){
			if(mx >=325 && mx<= 475)
			{
				if(my >= 125 && my<= 175)
				{
					game.State = STATE.GAME;
				}
			}
			
			if(mx >=325 && mx<= 475)
			{
				if(my >= 215 && my<= 265)
				{
					game.State = STATE.PAUSEOPTIONS;
				}
			}
			
			if(mx >=325 && mx<= 475)
			{
				if(my >= 305 && my<= 355)
				{
					game.State = STATE.MENU;
				}
			}
		}
///////////////////////////////////////////////////////////////////////////////////////////////
		//Mouse buttons for options from pause
		if(game.State==STATE.PAUSEOPTIONS){
			if(mx >=650 && mx<= 770)
			{
				if(my >= 540 && my<= 580)
				{
					game.State = STATE.PAUSE;
				}
			}
		}
///////////////////////////////////////////////////////////////////////////////////////////////
		//Mouse buttons for options from pause
		if(game.State==STATE.GAMEOVER){
			if(mx >=305 && mx<= 505)
				{
				if(my >= 265 && my<= 315)
				{
					game.State = STATE.MENU;
				}
			}
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////
	

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
