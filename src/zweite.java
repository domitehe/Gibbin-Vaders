
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public class zweite extends JPanel implements KeyListener, ActionListener{
	Timer t = new Timer(10, this);
	double x = 0, y = 0, velx = 0, vely = 0, height = 40, width = 40;
	
	public zweite() {
		t.start();
		setFocusable(true);
		addKeyListener(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(new Ellipse2D.Double(x, y, height, width));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(x < 0) {
			velx = 0;
			x = 0;
		}
		if(x > 445) {
			velx = 0;
			x = 445;
		}
		if(y < 0) {
			vely = 0;
			y = 0;
		}
		if(y > 420) {
			vely = 0;
			y = 420;
		}
		x += velx;
		y += vely;
		repaint();
		System.out.println(x + " " + y);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_UP) vely = -1;
		if(code == KeyEvent.VK_DOWN) vely = 1;
		if(code == KeyEvent.VK_LEFT) velx = -1;
		if(code == KeyEvent.VK_RIGHT) velx = 1;
	}

	@Override
	public void keyReleased(KeyEvent e) {
int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_UP) vely = 0;
		if(code == KeyEvent.VK_DOWN) vely = 0;
		if(code == KeyEvent.VK_LEFT) velx = 0;
		if(code == KeyEvent.VK_RIGHT) velx = 0;
	}

	@Override
	public void keyTyped(KeyEvent e) {}
}
