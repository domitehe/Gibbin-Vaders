import java.util.Timer;
import java.util.TimerTask;

public class Wave {
	private ObjectController c;
	private int i;
	protected boolean finished = false;
	
	private Timer t = new Timer();
	
	private int[] spawnamount = {0, 2, 4, 6, 8, 10};
	
	public Wave(ObjectController c){
		this.c = c;
		spawn();
	}
	
	public void spawn(){
		i = 1;
		t.scheduleAtFixedRate(new TimerTask() {

		    @Override
		    public void run() {
		    	if(i == spawnamount.length-1) {
		    		finished = true;
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
		7000);
	}
	
	

}
