import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Boss extends Object implements EntityEnemy{
	private int size = 60;
	private Game game;
	private ObjectController c;
	private int health = 15;
	private int fireRate = 200;
	private int i;
	BufferedImage image;
	BufferedImage bullet;
	Random random = new Random();
	private double movementspeedx, movementspeedy;

	public Boss(double x, double y, ObjectController c, Game g, BufferedImage bullet, BufferedImage image) {
		super(x, y);
		this.game = g;
		this.c = c;
		this.image = image;
		this.bullet = bullet;
		movementspeedx = 0.3;
		movementspeedy = 0.3 ;
	}
	
	public void render(Graphics g){
		tick();
		g.drawImage(image,(int)this.x-(size/2), (int)this.y-(size/2),size+health,size+health,null);
//		g.drawRect((int)this.x, (int)this.y, size+health, size+health);
		g.setColor(Color.RED);
	}
	public void tick(){
		x-=movementspeedx; //Movement
		y+=movementspeedy;
		for (int i = 0; i < game.epl.size(); i++) {
			EntityPlayer tempep = game.epl.get(i);
			if(Physics.Collision(this, tempep)){
				c.removeEntityPlayer(tempep);
				if(health <= 0) {
					c.removeEntityEnemy(this);
					Game.State = Game.STATE.WIN;
				}
				else {
					--health;
				}
			}
		}
		if(x-(size/2) < 0.0D || x+(size/2) > game.getWidth()){ //Change Movement when hits the border
			movementspeedx = movementspeedx*(-1);
		}
		if(y+size/2 > (game.getHeight()-(game.getHeight()/5))|| y< size/2){
			movementspeedy = movementspeedy*(-1);
		}
		
		
		if(i >= fireRate){
	        double dx = x - game.p.getX();
	        double dy = y - game.p.getY();
	        double dir = Math.atan2(dy, dx);
	        this.c.addEntityEnemy(new EnemyBullet(this.x-(size/2)+size/2, this.y-(size/2)+size, this.c, this.game,0.3, dir,bullet));
	        i=0;
		}
		i++;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)this.x, (int)this.y, size+health, size+health);
	}

	@Override
	public double getX() {
		return this.x;
	}

	@Override
	public double getY() {
		return this.y;
	}

}
