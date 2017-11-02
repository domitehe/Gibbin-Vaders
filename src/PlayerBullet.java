import java.awt.Graphics;
import java.awt.Rectangle;

public class PlayerBullet extends Bullet {
    public static final int FIRE_RATE = 1;

    public PlayerBullet(double x, double y, ObjectController c, Game game) {
        super(x, y, c, game);
        this.speed = 4;
    }

    public void tick() {
        this.y -= speed;
        /*if (this.y < 0.0D || this.y > 480.0D) {
            this.c.removePlayerBullet(this);
        }*/

    }

    public void render(Graphics g) {
        g.drawRect((int)this.x+3, (int)this.y-4,4, 4);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)this.x + 10, (int)this.y + 12, 10, 8);
    }
}
