import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends Object implements EntityEnemy{
	
	private double movementspeed = 0.04;
	protected ObjectController c;
	protected Game game;
	private int fireRate = 1000;
	private int i = 0;
	final private int size = 16;
	
	public Enemy(double x, double y,ObjectController c, Game game) {
		super(x, y);
		this.c = c;
		this.game = game;
	}
	public void render(Graphics g){
		tick();
		g.drawRect((int)this.x, (int)this.y, size, size);
	}
	public void tick(){
		x-=movementspeed; //Movement
		
		for (int i = 0; i < game.epl.size(); i++) {
			EntityPlayer tempep = game.epl.get(i);
			if(Physics.Collision(this, tempep)){
				c.removeEntityPlayer(tempep);
				c.removeEntityEnemy(this);
			}
		}
		
		if(x < 0.0D || x+size > game.getWidth()){ //Change Movement when hits the border
			movementspeed = movementspeed*(-1);
		}
		
		if(i >= fireRate){
			this.c.addEntityEnemy(new EnemyBullet(this.x+size/2, this.y+size, this.c, this.game, 0.2));
			i = 0;
		}
		i++;
		/*if (Physics.Collision(this, game.p)) {
			Game.State = Game.STATE.FAIL;
		}*/
	}
	public Rectangle getBounds(){
		return new Rectangle((int)this.x, (int)this.y, size, size);
	}
	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}
	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}
}
