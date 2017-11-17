import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemyBullet extends Bullet implements EntityEnemy{
	private int bulletsize =4;

	public EnemyBullet(double x, double y, ObjectController c, Game game, double speed) {
		super(x, y, c, game, speed);
	}
	
	public void tick() {
        this.y += speed;
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
