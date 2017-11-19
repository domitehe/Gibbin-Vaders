import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends Object implements EntityPlayer{

	    private int fireRate = 300;
	    private Game game;
	    private ObjectController c;
	    private Keyboard input;
	    private int i = 0;
	    private double playerspeed = 0.4;
	    private int playersize = 30;
	    protected boolean god = false; // god mode
	    private BufferedImage image;
	    private BufferedImage bullet;
	
	public Player(double x, double y, ObjectController c, Keyboard input, Game game, BufferedImage image, BufferedImage bullet) {
		super(x, y);
		this.game = game;
		this.c = c;
		this.input = input;
		this.image = image;
		this.bullet = bullet;
	}
	public void render(Graphics g){
		tick();
		g.setColor(Color.RED);
//		g.drawRect((int)this.x, (int)this.y, playersize,playersize);
		g.drawImage(image,(int)this.x, (int)this.y,null);
	}
	public void tick(){
		for (int i = 0; i < game.eel.size(); i++) {
			EntityEnemy tempee = game.eel.get(i);
			if(Physics.Collision(this, tempee)){
				c.removeEntityEnemy(tempee);
				if(!god) {
					Game.State = Game.STATE.FAIL;
				}
			}
		}
		
		if(input.left&&this.x>0){
			this.x-=playerspeed;
		}
		if(input.right&&this.x+playersize/2<Game.WIDTH*Game.SCALE){
			this.x+=playerspeed;
		}
		if(input.down&&this.y+playersize/2<Game.HEIGHT*Game.SCALE){
			this.y+=playerspeed;
		}
		if(input.up&&this.y>0){
			this.y-=playerspeed;
		}
		if(input.shoot){
			if(i >= fireRate){
				this.c.addEntityPlayer(new PlayerBullet(this.x+playersize/2, this.y, this.c, this.game, 0.9, bullet));
				i = 0;
			}
		}
		i++;
	}
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)this.x, (int)this.y, playersize, playersize);
	}
	@Override
	public double getX() {
		return x;
	}
	@Override
	public double getY() {
		return y;
	}
	
}
