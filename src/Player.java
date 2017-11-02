import java.awt.Graphics;

public class Player extends Object{

	   private final int SPEED = 5;
	    private int cspeed = 5;
	    private int fireRate = 0;
	    private Game game;
	    private ObjectController c;
	    private Keyboard input;
	
	public Player(double x, double y, ObjectController c, Keyboard input, Game game) {
		super(x, y);
		this.game = game;
		this.c = c;
		this.input = input;
	}
	public void render(Graphics g){
		if(input.left){
			this.x-=0.3;
		}
		if(input.right){
			this.x+=0.3;
		}
		if(input.down){
			this.y+=0.3;
		}
		if(input.up){
			this.y-=0.3;
		}
		g.drawRect((int)this.x, (int)this.y, 10,10);
	}
	
}
