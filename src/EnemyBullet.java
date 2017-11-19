import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class EnemyBullet extends Bullet implements EntityEnemy{
	private int bulletsize =4;
    private double nx;
    private double ny;
    BufferedImage image;
    
	public EnemyBullet(double x, double y, ObjectController c, Game game,double speed, double dir, BufferedImage image) {
		super(x, y, c, game, speed);
		this.image = image;
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
    	g.drawImage(image, (int)this.x, (int)this.y, null);
        g.setColor(Color.RED);
        if(this.y > Game.HEIGHT*Game.SCALE||this.y < 0.0D || this.x > Game.WIDTH*Game.SCALE|| this.x< 0.0D ){
        	c.removeEntityEnemy(this);
        }
    }

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)this.x, (int)this.y, bulletsize, bulletsize);
	}

}
