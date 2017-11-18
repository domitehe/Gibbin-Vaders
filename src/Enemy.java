import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy extends Object implements EntityEnemy{
	Random r = new Random();
	private double movementspeedx;
	private double movementspeedy;
	protected ObjectController c;
	protected Game game;
	private int fireRate = 1000;
	private int i = 0;
	final private int size = 16;
	
	public Enemy(double x, double y,ObjectController c, Game game) {
		super(x, y);
		this.c = c;
		this.game = game;
		movementspeedx = (r.nextDouble() * 0.2)-0.1;
		movementspeedy = (r.nextDouble() * 0.2)-0.1 ;
	}
	public void render(Graphics g){
		tick();
		g.drawRect((int)this.x, (int)this.y, size, size);
		g.setColor(Color.RED);
	}
	public void tick(){
		x-=movementspeedx; //Movement
		y+=movementspeedy;
		for (int i = 0; i < game.epl.size(); i++) {
			EntityPlayer tempep = game.epl.get(i);
			if(Physics.Collision(this, tempep)){
				c.removeEntityPlayer(tempep);
				c.removeEntityEnemy(this);
			}
		}
		
		if(x < 0.0D || x+size > game.getWidth()){ //Change Movement when hits the border
			movementspeedx = movementspeedx*(-1);
		}
		if(y+size > game.getHeight()|| y<0.0D){
			movementspeedy = movementspeedy*(-1);
		}
		
		if(i >= fireRate){
            double dx = this.x - this.game.p.getX();
            double dy = this.y - this.game.p.getY();
            double dir = Math.atan2(dy, dx);
			this.c.addEntityEnemy(new EnemyBullet(this.x+size/2, this.y+size, this.c, this.game,0.2, dir));
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
