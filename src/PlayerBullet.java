import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerBullet extends Bullet implements EntityPlayer{
    public static final int FIRE_RATE = 1;
    private int bulletsize =4;

    public PlayerBullet(double x, double y, ObjectController c, Game game, double speed) {
        super(x, y, c, game, speed);
    }

    public void tick() {
        this.y -= speed;
    }

    public void render(Graphics g) {
    	tick();
        g.drawRect((int)this.x-bulletsize/2, (int)this.y-bulletsize/2,bulletsize, bulletsize);
        g.setColor(Color.RED);
        if(this.y < 0){
        	c.removeEntityPlayer(this);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int)this.x+3, (int)this.y-4,4, 4);
    }
}
