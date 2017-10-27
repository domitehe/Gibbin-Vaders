import java.awt.Graphics;

public class Player extends Object{

	private Game game;
	private ObjectController c;
	private Keyboard input;
	
	public Player(double x, double y, ObjectController c, Keyboard input, Game game) {
		super(x, y);
		this.game = game;
		this.c = c;
		this.input = input;
	}
	public void render(Graphics g){
		g.drawRect(10, 10,(int) x, (int)y);
	}
	
}
