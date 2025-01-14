package com.wayne.bomberman.menuwindows;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;

public class InGameMenu {
	//buttons
	
	int x = 325;
	int y = 125;
	int w = 150;
	int h = 50;

	public Rectangle resumeButton = new Rectangle(x,y,w,h);//position x, position y, button width, button height
	public Rectangle optionsButton = new Rectangle(x,y+h+40,w,h);
	public Rectangle quitButton = new Rectangle(x,y+2*h+80,w,h);
	

	public void render(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
		float thickness = 5;
		Stroke stroke1 = g2d.getStroke();
		g2d.setStroke(new BasicStroke(thickness));
		
		//buttons
		Font font1 = new Font("arial", Font.BOLD, 25);
		g.setColor(Color.black);
		g.setFont(font1);
		g.fillRect(x, y, w, 3*h);
		
		int y=35;
		
		g.setColor(Color.pink);
		g.setFont(new Font("CenturyGothic", Font.BOLD, 28)); 
		g.drawString("Resume", resumeButton.x+20, resumeButton.y+y);
		g2d.draw(resumeButton);
		g.drawString("Options", optionsButton.x+25, optionsButton.y+y);
		g2d.draw(optionsButton);
		g.drawString("Quit", quitButton.x+45, quitButton.y+y);
		g2d.draw(quitButton);
	
		g2d.setStroke(stroke1);//Rectangle border thickness
	
	}
}
