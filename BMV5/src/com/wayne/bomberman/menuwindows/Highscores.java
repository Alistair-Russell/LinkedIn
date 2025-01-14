package com.wayne.bomberman.menuwindows;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Highscores {
	
	public static int finalScore=501;
	String scoreList[][] = new String[10][2];
	
	int x=40;
	int y=80;
	int w=300;
	int h=50 ;
	
	ArrayList<String> words = new ArrayList<String>();
	
	public Rectangle title = new Rectangle(x, 30,2*w,h);
	public Rectangle[] name = new Rectangle[10];
	public Rectangle[] score = new Rectangle[10];
	public Rectangle backButton = new Rectangle(650,540,120,40);


	public void render(Graphics g){
			
		Graphics2D g2d = (Graphics2D) g;
		float thickness = 5;
		Stroke stroke1 = g2d.getStroke();
		g2d.setStroke(new BasicStroke(thickness));
	
		g.setColor(Color.pink);
		g.setFont(new Font("CenturyGothic", Font.BOLD, 20));
		g.drawString("Back", 685, 565);
		g2d.draw(backButton);
		g2d.draw(title);
		
		for(int i=0; i<name.length;i++){
			Rectangle nameList = new Rectangle(x,y+i*h,w,h);
			name[i] = nameList;
			g2d.draw(name[i]);
		}
		for(int i=0; i<score.length;i++){
			Rectangle scoreList = new Rectangle(x+w,y+i*h,w,h);
			score[i] = scoreList;
			g2d.draw(score[i]);
		}
		
		g.setFont(new Font("CenturyGothic", Font.BOLD, 40));
		g.drawString("H I G H S C O R E S", title.x+120, title.y+40);
		scoreList();
		
		g.setFont(new Font("CenturyGothic", Font.BOLD, 20));
		for(int i = 0; i < 10; i++) {
	
			g.drawString(words.get(i).substring(0, 3), name[i].x + 100, name[i].y + 40);
			
			g.drawString(words.get(i).substring(4, words.get(i).length()), name[i].x + w+100, name[i].y + 40);
		
			
			
		}
		
		;
		
		g2d.setStroke(stroke1);
		
	}
	
	public void scoreList(){

		try {
			BufferedReader br = new BufferedReader(new FileReader("/tmp/wtam7/Desktop/team4-master/BMV3/src/com/wayne/bomberman/windows/highscores.txt"));
			
			String line = null;
			while((line = br.readLine()) != null) {
				words.add(new String(line));
			}
			
			for(int i = 0; i < 10; i++) {
				if(Integer.parseInt(words.get(i).substring(4, words.get(i).length())) < finalScore){
					words.add(i, "xxx "+ finalScore );
				}
				break;	
			
			}
			
			br.close();
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("file was not found");
		}
		
	}
	
	public void writeScore(){
		try {
			BufferedReader br = new BufferedReader(new FileReader("/BMV5/src/com/wayne/bomberman/menuwindows/highscores.txt"));
			
			String line = null;
			while((line = br.readLine()) != null) {
				words.add(new String(line));	
			}
			/*for(int i = 0; i < 10; i++) {
				if(Integer.parseInt(words.get(i).substring(4, words.get(i).length())) < finalScore){
					words.add(i, "xxx "+ finalScore );
					i=10;
				}
			}*/
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("file was not found");
		}
	}
	
}
