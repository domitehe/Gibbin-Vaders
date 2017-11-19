import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Menu {
    public Rectangle startButton = new Rectangle(100, 180, 80, 40);

    public Menu() {
    }

    public void render(Graphics g) {
        Font fnt0 = new Font("arial", 1, 50);
        g.setFont(fnt0);
        g.setColor(Color.BLACK);
        g.drawString("Gibbin' Vaders", 100, 100);
        Font fnt1 = new Font("Arial Bold", 2, 25);
        g.setFont(fnt1);
        g.drawString("Press Enter to Start", 100, 180);
        Font fnt2 = new Font("Arial Bold", 1, 17);
        g.setFont(fnt2);
        
    }
}