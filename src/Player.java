import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Object implements EntityPlayer{

	    private int fireRate = 800;
	    private Game game;
	    private ObjectController c;
	    private Keyboard input;
	    private int i = 0;
	    private double playerspeed = 0.15;
	    private int playersize = 20;
	
	public Player(double x, double y, ObjectController c, Keyboard input, Game game) {
		super(x, y);
		this.game = game;
		this.c = c;
		this.input = input;
	}
	public void render(Graphics g){
		tick();
		g.setColor(Color.RED);
		g.drawRect((int)this.x, (int)this.y, playersize,playersize);
		
	}
	public void tick(){
		for (int i = 0; i < game.eel.size(); i++) {
			EntityEnemy tempee = game.eel.get(i);
			if(Physics.Collision(this, tempee)){
				c.removeEntityEnemy(tempee);
				Game.State = Game.STATE.FAIL;
			}
		}
		
		if(input.left&&this.x>0){
			this.x-=playerspeed;
		}
		if(input.right&&this.x+playersize/2<game.WIDTH*game.SCALE){
			this.x+=playerspeed;
		}
		if(input.down&&this.y+playersize/2<game.HEIGHT*game.SCALE){
			this.y+=playerspeed;
		}
		if(input.up&&this.y>0){
			this.y-=playerspeed;
		}
		if(input.shoot){
			if(i >= fireRate){
				this.c.addEntityPlayer(new PlayerBullet(this.x+playersize/2, this.y, this.c, this.game, 0.3));
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
