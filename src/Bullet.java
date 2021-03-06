import java.awt.Graphics;

public abstract class Bullet extends Object {
    protected ObjectController c;
    protected Game game;
    protected double speed;

    public Bullet(double x, double y, ObjectController c, Game game, double speed) {
        super(x, y);
        this.c = c;
        this.game = game;
        this.speed = speed;
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