import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Boss extends Object implements EntityEnemy{
	private int size = 60;
	private Game game;
	private ObjectController c;
	private int health = 15;
	private int fireRate = 6000;
	private int i;

	public Boss(double x, double y, ObjectController c, Game g) {
		super(x, y);
		this.game = g;
		this.c = c;
	}
	
	public void render(Graphics g){
		tick();
		g.drawRect((int)this.x, (int)this.y, size+health, size+health);
		g.setColor(Color.RED);
	}
	public void tick(){
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
		
		
		if(i >= fireRate){
	        double dx = x - game.p.getX();
	        double dy = y - game.p.getY();
	        double dir = Math.atan2(dy, dx);
	        this.c.addEntityEnemy(new EnemyBullet(this.x+(size+health)/4, this.y+size+health, this.c, this.game,0.05, dir));	        this.c.addEntityEnemy(new EnemyBullet(this.x+(size+health)/2, this.y+size+health, this.c, this.game,0.05, dir));
	        this.c.addEntityEnemy(new EnemyBullet(this.x+(size+health)/2, this.y+size+health, this.c, this.game,0.05, dir));
	        this.c.addEntityEnemy(new EnemyBullet(this.x+(size+health)*0.75, this.y+size+health, this.c, this.game,0.05, dir));
			i = 0;
		}
		i++;
		/*if (Physics.Collision(this, game.p)) {
			Game.State = Game.STATE.FAIL;
		}*/
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
