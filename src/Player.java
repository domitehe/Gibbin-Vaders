import java.awt.Graphics;

public class Player extends Object{

	   private final int SPEED = 5;
	    private int cspeed = 5;
	    private int fireRate = 800;
	    private Game game;
	    private ObjectController c;
	    private Keyboard input;
	    private int i = 0;
	    private double playerspeed = 0.15;
	
	public Player(double x, double y, ObjectController c, Keyboard input, Game game) {
		super(x, y);
		this.game = game;
		this.c = c;
		this.input = input;
	}
	public void render(Graphics g){
		tick();
		g.drawRect((int)this.x, (int)this.y, 20,20);
	}
	public void tick(){
		if(input.left&&this.x>0){
			this.x-=playerspeed;
		}
		if(input.right&&this.x<game.WIDTH*game.SCALE){
			this.x+=playerspeed;
		}
		if(input.down&&this.y<game.HEIGHT*game.SCALE){
			this.y+=playerspeed;
		}
		if(input.up&&this.y>0){
			this.y-=playerspeed;
		}
		if(input.shoot){
			if(i >= fireRate){
				this.c.addPlayerBullet(new PlayerBullet(this.x, this.y, this.c, this.game));
				i = 0;
			}
		}
		i++;
	}
	
}
