import java.awt.Graphics;

public class Player extends Object{

	   private final int SPEED = 5;
	    private int cspeed = 5;
	    private int fireRate = 80;
	    private Game game;
	    private ObjectController c;
	    private Keyboard input;
	    private int i = 0;
	
	public Player(double x, double y, ObjectController c, Keyboard input, Game game) {
		super(x, y);
		this.game = game;
		this.c = c;
		this.input = input;
	}
	public void render(Graphics g){
		tick();
		g.drawRect((int)this.x, (int)this.y, 10,10);
	}
	public void tick(){
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
		}if(input.shoot){
			if(i >= fireRate){
				this.c.addPlayerBullet(new PlayerBullet(this.x, this.y, this.c, this.game));
				i = 0;
			}
		}
		i++;
	}
	
}
