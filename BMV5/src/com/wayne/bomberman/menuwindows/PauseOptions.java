package com.wayne.bomberman.menuwindows;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;

public class PauseOptions {

	int x = 50;
	int y = 140;
	int width = 150;
	int height = 50;
	
	public Rectangle titleBox = new Rectangle(x,y,2*width, height);//position x, position y, button width, button height
	public Rectangle upBox = new Rectangle(x,y+height,width,height);
	public Rectangle downBox = new Rectangle(x,y+2*height,width,height);
	public Rectangle leftBox = new Rectangle(x,y+3*height,width,height);
	public Rectangle rightBox = new Rectangle(x,y+4*height,width,height);
	public Rectangle spaceBox = new Rectangle(x,y+5*height,width,height);
	public Rectangle upBox2 = new Rectangle(x+width,y+height,width,height);
	public Rectangle downBox2 = new Rectangle(x+width,y+2*height,width,height);
	public Rectangle leftBox2 = new Rectangle(x+width,y+3*height,width,height);
	public Rectangle rightBox2 = new Rectangle(x+width,y+4*height,width,height);
	public Rectangle spaceBox2 = new Rectangle(x+width,y+5*height,width,height);	
	
	public Rectangle backButton = new Rectangle(650,540,120,40);

	
public void render(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
		
		float thickness = 5;
		Stroke stroke1 = g2d.getStroke();
		g2d.setStroke(new BasicStroke(thickness));
		
		g.setColor(Color.black);
		g.fillRect(x, y, width*2, height*6);//filling for controls
		g.fillRect(650, 540, 120, 40);//filling for back button
		g.setColor(Color.pink);
		g.setFont(new Font("CenturyGothic", Font.BOLD, 28)); 
		g.drawString("Controls", titleBox.x+85, titleBox.y+35);
		
		int x = 20;
		int y = 35;
	
		//draw String
		g.setFont(new Font("CenturyGothic", Font.PLAIN, 20));
		g.drawString("Up", upBox.x+x, upBox.y+y);
		g.drawString("Down", downBox.x+x, downBox.y+y);
		g.drawString("Left", leftBox.x+x, leftBox.y+y);
		g.drawString("Right", rightBox.x+x,rightBox.y+y);
		g.drawString("Plant Bomb",spaceBox.x+x, spaceBox.y+y);
		g.drawString("w", upBox2.x+x, upBox2.y+y);
		g.drawString("s", downBox2.x+x, downBox2.y+y);
		g.drawString("a", leftBox2.x+x, leftBox2.y+y);
		g.drawString("d", rightBox2.x+x, rightBox2.y+y);
		g.drawString("Spacebar", spaceBox2.x+x, spaceBox2.y+y);
		
		//drawing boxes/rectangles
		g2d.draw(titleBox);
		g2d.draw(upBox);
		g2d.draw(downBox);
		g2d.draw(leftBox);
		g2d.draw(rightBox);
		g2d.draw(spaceBox);
		g2d.draw(upBox2);
		g2d.draw(downBox2);
		g2d.draw(leftBox2);
		g2d.draw(rightBox2);
		g2d.draw(spaceBox2);
	
		
		
		g.setFont(new Font("CenturyGothic", Font.BOLD, 20));
		g.drawString("Back", 685, 565);
		g2d.draw(backButton);
		
		g2d.setStroke(stroke1);//Rectangle border thickness
		
	}
}
