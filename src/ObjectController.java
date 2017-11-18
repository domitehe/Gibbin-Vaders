import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

public class ObjectController {
//	private List EnemyBulletList;
	private LinkedList<EntityPlayer> epl = new LinkedList <EntityPlayer>();
	private LinkedList<EntityEnemy> eel = new LinkedList <EntityEnemy>();
	private Game game;
	private Random r = new Random();
	private Wave wave;
	
	private EntityEnemy tempee;
	private EntityPlayer tempep;
	
	public ObjectController(Game game){
		this.game = game;
	}
	public void tick(){
		for (int i = 0; i < epl.size(); i++){
			tempep = epl.get(i);
			
			tempep.tick();
		}
		for (int i = 0; i < eel.size(); i++){
			tempee = eel.get(i);

			tempee.tick();
		}
		//System.out.println(eel.size());
		//System.out.println(epl.size());
	}
	public void render(Graphics g){
		for(EntityPlayer ea : epl){
			ea.render(g);
		}

		for (int i = 0; i < eel.size(); i++){
			tempee = eel.get(i);
			
			tempee.render(g);
		}
	}
	
	public void createEnemy(int enemy_count){
		for (int i = 0; i < enemy_count; i++) {
			Enemy e = new Enemy(Game.WIDTH * Game.SCALE * r.nextDouble(), 50, this, game);
			addEntityEnemy(e);
		}
	}
	public void addEntityEnemy(EntityEnemy entenemy){
		this.eel.add(entenemy);
	}
	public void removeEntityEnemy(EntityEnemy entenemy){
		this.eel.remove(entenemy);
		if((eel.size() == 0) & wave.finished) {
			Game.State = Game.STATE.BOSS;
			this.addEntityEnemy(game.boss);
		}
	}
	public void addEntityPlayer(EntityPlayer entplayer){
		this.epl.add(entplayer);
	}
	public void removeEntityPlayer(EntityPlayer entplayer){
		this.epl.remove(entplayer);
	}
	public LinkedList<EntityPlayer> getPlayerBulletList() {
		// TODO Auto-generated method stub
		return epl;
	}
	public LinkedList<EntityEnemy> getEnemyList() {
		// TODO Auto-generated method stub
		return eel;
	}
	public void reset(){
		while (!eel.isEmpty()) {
	        eel.removeFirst();
	    }
		while (!epl.isEmpty()) {
	        epl.removeFirst();
	    }
	}
	public void setWave(Wave w) {
		this.wave = w;
	}
	
}
