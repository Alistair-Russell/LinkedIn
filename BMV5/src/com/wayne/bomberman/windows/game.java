package com.wayne.bomberman.windows;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import com.wayne.bomberman.framework.KeyInput;
import com.wayne.bomberman.framework.MouseInput;
import com.wayne.bomberman.framework.ObjectId;
import com.wayne.bomberman.framework.Position;
import com.wayne.bomberman.framework.STATE;
import com.wayne.bomberman.framework.Texture;
import com.wayne.bomberman.menuwindows.Credits;
import com.wayne.bomberman.menuwindows.GameCover;
import com.wayne.bomberman.menuwindows.GameOver;
import com.wayne.bomberman.menuwindows.Highscores;
import com.wayne.bomberman.menuwindows.HowToPlay;
import com.wayne.bomberman.menuwindows.InGameMenu;
import com.wayne.bomberman.menuwindows.Menu;
import com.wayne.bomberman.menuwindows.PauseOptions;
import com.wayne.bomberman.menuwindows.levelSelect;
import com.wayne.bomberman.objects.Block;
import com.wayne.bomberman.objects.Crate;
import com.wayne.bomberman.objects.Enemy;
import com.wayne.bomberman.objects.ExitDoor;
import com.wayne.bomberman.objects.Player;




public class game extends Canvas implements Runnable{

	private static final long serialVersionUID = -7203659715208503182L;

	private boolean running =false;
	private Thread thread;
	public static Player player;
	
	public static int WIDTH, HEIGHT;
	
	public static boolean levelCompleted;
	public static boolean levelFailed;
	
	//create states here
	private Menu menu= new Menu();
	private levelSelect select = new levelSelect();
	private HowToPlay htp = new HowToPlay();
	private Highscores hs = new Highscores();
	private GameCover gc = new GameCover();
	private Credits c = new Credits();
	private InGameMenu p = new InGameMenu();
	private PauseOptions po = new PauseOptions();
	private GameOver go = new GameOver();
	
	
	
	//all necessary objects here
	Handler handler;
	static Texture tex;
	
	public static STATE State = STATE.GAMECOVER;//Game starting State
	
	static int gameLoop=1;//for looping once on init() 
	
	public static int score = 0;
	
	public static final int gameTime = 5000;
	public static int timeLeft = gameTime;
	
	
	private void init()
	{
		WIDTH =getWidth();
		HEIGHT=getHeight();
		tex = new Texture();
		
		handler = new Handler(); 
		
		levelCompleted=false;
		levelFailed=false;
		
		for(int i=1;i<=10;i++){
			if(MouseInput.levelNum == i)
				LoadImageLevel(tex.level[MouseInput.levelNum-1]);
			}
			
		this.addMouseListener(new MouseInput());	
		this.addKeyListener(new KeyInput(handler));
	}
		
	public synchronized void start(){
		if(running)
			return;
		running =true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	public void run()//game loop
	{
		init();
		
		this.requestFocus();
		
		long lastTime = System.nanoTime();
		double nbTicks = 50;
		double ns = 1000000000 / nbTicks;
		double time = 0;
		while(running){
			long now = System.nanoTime();
			time += (now - lastTime) / ns;
			lastTime = now;
			while(time >= 1){
				tick();	
				time--;
				if(State==STATE.GAME){
					timeLeft--;
					
					if(timeLeft<0){
						State=STATE.GAMEOVER;
						timeLeft=gameTime;
					}
				}
			}
			render();
			if(levelCompleted==false){
				render();
				}
			else{
				handler.object.clear();
				handler.bomb=null;
				KeyInput.spaceEnabled=true;
				MouseInput.levelNum +=1;
				gameLoop=1;
				}
			
			}
	}
	
	private void tick()//game updates
	{
		if(State==STATE.GAME)
		{
			handler.tick();
		}
		
		
	}
	
	private void render()//graphics, drawing, images
	{
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs==null)
		{
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		if(State!=STATE.GAME && State!=STATE.PAUSE && State!=STATE.PAUSEOPTIONS)
			g.drawImage(tex.cover[0],5, 0, null);
		if(State==STATE.GAME){
			if(gameLoop==1)//only for game cycle, so that it goes through init only once
			{
				gameLoop=0;
				init();
			}
			g.setColor(Color.darkGray);//IN GAME background
			g.fillRect(0, 0, getWidth(), getHeight());// window dimensions
			handler.render(g); 
			g.setColor(Color.red);
			//g.drawImage(tex.hud[0], 0, 476, null);//score hud
			g.setFont(new Font("TimesRoman", Font.PLAIN, 38));
			g.drawString(String.valueOf(score),400,520);
			g.drawString(String.valueOf(timeLeft), 680, 520);
			g.drawString(String.valueOf(MouseInput.levelNum), 400, 590);
			g.setColor(Color.blue);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 48));
			g.drawString("TIME:", 540, 525);
		}else if(State==STATE.MENU){
			g.setColor(Color.black);//menu background
			menu.render(g);
		}else if(State==STATE.LEVELSELECT){
			g.drawImage(tex.menu_icons[1], 35, 500, null);//level icon
			select.render(g);
		}else if(State==STATE.HOWTOPLAY){
			htp.render(g);
			//htp.optionsWindow();
		}else if(State==STATE.HIGHSCORE){
			g.setColor(Color.black);
			g.fillRect(0, 0, getWidth(), getHeight());
			hs.render(g);
		}else if(State==STATE.GAMECOVER){
			g.setColor(Color.black);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.drawImage(tex.cover[0],5, 0, null);
			gc.render(g);
		}else if(State==STATE.CREDITS){
			g.setColor(Color.black);
			g.fillRect(0, 0, getWidth(), getHeight());
			c.render(g);
		}else if(State==STATE.PAUSE){
			g.setColor(Color.black);
			g.fillRect(0, 0, getWidth(), getHeight());
			//g.fillRect(200, 50, 400, 400);
			p.render(g);
		}else if(State==STATE.PAUSEOPTIONS){
			g.setColor(Color.black);
			g.fillRect(0, 0, getWidth(), getHeight());
			po.render(g);
		}else if(State==STATE.GAMEOVER){
			g.setColor(Color.black);
			g.fillRect(0, 0, getWidth(), getHeight());
			go.render(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	private void LoadImageLevel(BufferedImage image)
	{
		if(State==STATE.GAME)
		{
			//only for testing, checks for file dimension size
			int w = image.getWidth();
			int h = image.getHeight();
			System.out.println("width, height: " + w + " " + h);
			//test stops here
			
			
			for(int xx= 0; xx<h; xx++)
			{//level design by colors
				for(int yy=0;yy<w; yy++)
				{
					int pixel = image.getRGB(xx,  yy);
					int red = (pixel >>16) & 0xff;
					int green=(pixel >> 8) & 0xff;
					int blue =(pixel) & 0xff;
					
					//check1
					Position p = new Position(xx*32, yy*32);
					if(red == 128 && green ==128 && blue ==128) handler.addObject(new Block(p,4, ObjectId.Block));
					if(red == 255 && green ==255 && blue ==255) handler.addObject(new Block(p,0, ObjectId.Block));//block bounderies
					if(red == 255 && green ==255 && blue ==0) handler.addObject(new Block(p,1, ObjectId.Block));//structure blocks 
					if(red == 255 && green ==0 && blue ==0) handler.addObject(new Crate(p,0, ObjectId.Block));//destructible blocks
					//if(red == 255 && green ==0 && blue ==0) handler.addObject(new Power(p,1, ObjectId.Power));//destructible blocks
					if(red == 0 && green ==0 && blue ==255) {
						player = new Player(p,handler, ObjectId.Player);
						handler.addObject(player);
					}
					if(red == 0 && green ==255 && blue ==0) handler.addObject(new Enemy(p,handler,0 ,ObjectId.Enemy));
					if(red == 255 && green ==128 && blue ==128) handler.addObject(new Enemy(p,handler,1, ObjectId.Enemy));
					if(red == 255 && green ==0 && blue ==255) handler.addObject(new Enemy(p,handler, 2,ObjectId.Enemy));
				}
				handler.addObject(new ExitDoor(MouseInput.exitPosition, ObjectId.ExitDoor));			}
		}
	}
	
	public static Texture getInstance(){
		return tex;
	}
	
	public static void main(String args[]) throws IOException {
		
		new window(800, 600, "Bomberman model", new game());
		
		Sound.theme.play();
	
	}
}
