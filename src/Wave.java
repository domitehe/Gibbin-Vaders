import java.util.Timer;
import java.util.TimerTask;

public class Wave {
	private ObjectController c;
	private Game game;
	private Boss boss;
	private int i;
	
	private Timer t = new Timer();
	
	private int[] spawnamount = {0, 2, 4, 6, 8, 10};
	
	public Wave(ObjectController c, Game g, Boss b){
		this.c = c;
		this.game = g;
		this.boss = b;
		spawn();
	}
	
	public void spawn(){
		/*for (int i = 0; i < spawnamount.length; i++) {
			t.schedule(new TimerTask() {          
		    @Override
		    public void run() {
		        c.createEnemy(1); 
		    }
		}, 5000);
		}*/
		i = 1;
		t.scheduleAtFixedRate(new TimerTask() {

		    @Override
		    public void run() {
//		    	System.out.println(i);
//		    	System.out.println(spawnamount.length);
		    	if(i == spawnamount.length-1) {
		    		t.cancel(); //stop timer
		    		t.purge(); // remove schedule
		    	}
		    	c.createEnemy(spawnamount[i]);
		    	i++;
		        //Called each time when 1000 milliseconds (1 second) (the period parameter)
		    }

		},
		//Set how long before to start calling the TimerTask (in milliseconds) (3 seconds)
		3000,
		//Set the amount of time between each execution (in milliseconds) (5 seconds)
		2000);
	}
	
	

}
