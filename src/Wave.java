import java.util.Timer;
import java.util.TimerTask;

public class Wave {
	private ObjectController c;
	private Game game;
	private Boss boss;
	
	private Timer t = new Timer();
	
	private int[] spawnamount = {4, 6, 8, 10};
	
	public Wave(ObjectController c, Game g, Boss b){
		this.c = c;
		this.game = g;
		this.boss = b;
	}
	
	public void spawn(){
	}
	
	

}
