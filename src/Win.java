import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Win {
	
	public Win(){}

	public void render(Graphics g) {
        Font fnt0 = new Font("arial", 1, 50);
        g.setFont(fnt0);
        g.setColor(Color.black);
        g.drawString("Gibbin' Vaders", 100, 100);
        Font fnt1 = new Font("Arial Bold", 2, 25);
        g.setFont(fnt1);
        g.drawString("You win", 100, 180);
        g.drawString("Press Esc to Quit", 100, 230);
        Font fnt2 = new Font("Arial Bold", 1, 17);
        g.setFont(fnt2);
        
    }
}
