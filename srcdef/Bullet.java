import java.awt.Graphics;

public abstract class Bullet extends Object {
    protected ObjectController c;
    protected Game game;
    protected int speed;

    public Bullet(double x, double y, ObjectController c, Game game) {
        super(x, y);
        this.c = c;
        this.game = game;
    }

    public void tick() {
    }

    public void render(Graphics g) {
    }

    public double getY() {
        return this.y;
    }

    public double getX() {
        return this.x;
    }
}