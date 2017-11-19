import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class PlayerBullet extends Bullet implements EntityPlayer{
    public static final int FIRE_RATE = 1;
    private int bulletsize =4;
    private BufferedImage bullet;

    public PlayerBullet(double x, double y, ObjectController c, Game game, double speed, BufferedImage bullet) {
        super(x, y, c, game, speed);
        this.bullet = bullet;
    }

    public void tick() {
        this.y -= speed;
    }

    public void render(Graphics g) {
    	tick();
    	g.drawImage(bullet, (int)this.x-bulletsize/2, (int)this.y-bulletsize/2,bulletsize, bulletsize,null);
//        g.drawRect((int)this.x-bulletsize/2, (int)this.y-bulletsize/2,bulletsize, bulletsize);
        g.setColor(Color.RED);
        if(this.y < 0){
        	c.removeEntityPlayer(this);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int)this.x+3, (int)this.y-4,4, 4);
    }
}
