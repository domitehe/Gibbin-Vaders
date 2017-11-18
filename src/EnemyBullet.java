import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemyBullet extends Bullet implements EntityEnemy{
	private int bulletsize =4;
    private double nx;
    private double ny;

	public EnemyBullet(double x, double y, ObjectController c, Game game,double speed, double dir) {
		super(x, y, c, game, speed);
        this.nx = (double)this.speed * Math.cos(dir);
        this.ny = (double)this.speed * Math.sin(dir);
	}
	
	public void tick() {
        this.x -= this.nx;
        this.y -= this.ny;
        if (this.y < 0.0D || this.y > 480.0D || this.x < 0.0D || this.x > 640.0D) {
            this.c.removeEntityEnemy(this);
        }
    }

    public void render(Graphics g) {
    	tick();
        g.drawRect((int)this.x-bulletsize/2, (int)this.y-bulletsize/2,bulletsize, bulletsize);
        g.setColor(Color.RED);
        if(this.y > Game.HEIGHT*Game.SCALE){
        	c.removeEntityEnemy(this);
        }
    }

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)this.x, (int)this.y, bulletsize, bulletsize);
	}

}
