import java.awt.Graphics;
import java.awt.Rectangle;

public interface EntityPlayer {
    void tick();

    void render(Graphics var1);

    Rectangle getBounds();

    double getX();

    double getY();
}