import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable {
	
	public final String TITLE = "Gibbin' Vaders";
	
	public enum STATE{
		MENU,
		GAME,
		FAIL,
		PAUSE,
		WIN,
		BOSS
	}
	public static STATE State = STATE.MENU;
	
	private JFrame frame;
	
	private Keyboard key;
	private ObjectController c;
	Player p;
	private Enemy e;
	private Wave w;
	
	private Thread thread;
	
	public static final int SCALE = 2;
	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 * 9;
	
    public LinkedList<EntityPlayer> epl;
    public LinkedList<EntityEnemy> eel;
	
	private boolean running = false;
	private Menu menu;
	private Fail fail;
	private Pause pause;
	private Win win;
	private Boss boss;
	
	private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
	
	public static void main(String[] args) {
		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE)); //set dimension
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		game.frame = new JFrame(); 
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //X button works
		game.frame.setResizable(false);
		game.frame.setLocationRelativeTo(null); //not to set the location
		game.frame.setVisible(true);
		game.start();

	}

	@Override
	public  void run() {
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;  //set FPS
		double ns = 1000000000 / amountOfTicks; //in nanoseconds per tick
		double delta = 0; //calculate the time pass
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis(); //in milliseconds
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns; //in ticks
			lastTime = now;
			if (delta >= 1){
				tick(); //update the frame
				updates++; //calculate the updates
				delta--;
			} //limit to 60 times per second to update the frames
			render();
			frames++; //calculate how many times it goes through this code
			
			if (System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				frame.setTitle(TITLE + "  |  " + updates + "ticks, " + frames + " fps");
				updates = 0; //reset it to 0
				frames = 0; //reset it to 0
			} //display the game updates and renders per second
		}
		stop();
		
	}
	private synchronized void start(){
		if (running)
			return; //get out of this method if the game is already running
		
		running = true; 
		thread = new Thread(this); 
		thread.start();
	}
	private synchronized void stop(){
		if (!running)
			return; //get out of this method if there is no thread
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	private void init(){
		requestFocus();
		key = new Keyboard();
		this.addKeyListener(key); //call the KeyInput class
		//this.addMouseListener(new MouseInput()); //call the MouseInput class
		menu = new Menu();
		fail = new Fail();
		pause = new Pause();
		win = new Win();
		boss = new Boss();
	}
	
	private void gameinit(){
		c = new ObjectController(this);
		p = new Player(WIDTH * SCALE / 2, HEIGHT * SCALE / 6 * 5, c, key, this);
		w = new Wave(c, this, boss);
		//Enemy e = new Enemy(WIDTH * SCALE, 50, c, this);
		c.createEnemy(25);
		
		epl = c.getPlayerBulletList();
		eel = c.getEnemyList();
	}
	
	private void tick(){
		key.tick();
		if(State== STATE.GAME){
			c.tick();
			p.tick();
		}
		if(key.enter && State== STATE.MENU){
			State = STATE.GAME;
			gameinit();
		}
		if(key.enter && State == STATE.PAUSE){
			State = STATE.GAME;
		}
		if(key.numOne && State == STATE.PAUSE){
			State = STATE.MENU;
		}
		if(key.esc && State == STATE.GAME){
			State = STATE.PAUSE;
		}
		if(key.esc && State == STATE.FAIL){
			State = STATE.MENU;
		}
	}
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if (bs  == null){
			createBufferStrategy(3);  //how many images loading up, cost CPU usage
			return;
		} //creating buffer strategy
		
		Graphics g = bs.getDrawGraphics(); //apply buffer strategy to graphics
		
		
		//g.drawImage(image, 0, 0, getWidth(), getHeight(), this); //black background
         g.fillRect(0, 0, getWidth(), getHeight());
         g.setColor(Color.WHITE);

			
		if (State == STATE.MENU) {
				menu.render(g);
		}
		if  (State == STATE.GAME){
			p.render(g);
			c.render(g);
		}
		if (State == STATE.FAIL){
			fail.render(g);
			c.reset();
		}
		if(State == STATE.PAUSE){
			pause.render(g);
		}
		g.dispose();
		bs.show();

		
	}

}
