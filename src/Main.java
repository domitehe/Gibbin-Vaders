import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World!");
        JFrame frame = new JFrame("FrameDemo");
        JPanel panel = new zweite();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(500,500);
        frame.setVisible(true);
	}

}
