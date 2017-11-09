import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ObjectController {
	private List EnemyBulletList;
	private LinkedList<Enemy> EnemyList = new LinkedList<Enemy>();
	private LinkedList<PlayerBullet> PlayerBulletList = new LinkedList <PlayerBullet>();
	private Game game;
	private Random r = new Random();
	
	public ObjectController(Game game){
		this.game = game;
	}
	public void tick(){
		if(PlayerBulletList.size() > 0){
			Iterator<PlayerBullet> iter = PlayerBulletList.iterator();

			while (iter.hasNext()) {
			    PlayerBullet b = iter.next();

			    if (b.y < 0.0D || b.y > 480.0D){
			        iter.remove();
			    }
			    b.tick();
			}
		}
		if(EnemyList.size() > 0){
			Iterator<Enemy> iter = EnemyList.iterator();
			
			while (iter.hasNext()){
				Enemy e = iter.next();
				
				if(e.x < 0.0D || e.x > game.getWidth()){
					//iter.remove();
					e.speed = e.speed*(-1);
				}
				e.tick();
				
			}
		}
		System.out.println(EnemyList.size());
	}
	public void render(Graphics g){
		for(PlayerBullet bullet : PlayerBulletList){
			bullet.render(g);
		}
		for(Enemy enemy : EnemyList){
			enemy.render(g);
		}
		/*if(EnemyList.size() > 0){
			Iterator<Enemy> iter = EnemyList.iterator();
			
			while (iter.hasNext()){
				iter.next().render(g);
			}
		}*/
	}
	
	public void createEnemy(int enemy_count){
		for (int i = 0; i < enemy_count; i++) {
			Enemy e = new Enemy(Game.WIDTH * Game.SCALE * r.nextDouble(), 50, this, game);
		//Enemy e = new Enemy(Game.WIDTH * Game.SCALE, 50, this, game);
		addEnemy(e);
		}
	}
	public void addEnemy(Enemy enemy){
		this.EnemyList.add(enemy);
	}
	public void removeEnemy(Enemy enemy){
			this.EnemyList.remove(enemy);
	}
	public void addPlayerBullet(PlayerBullet bullet){
		this.PlayerBulletList.add(bullet);
	}
	public void removePlayerBullet(PlayerBullet bullet){
		this.PlayerBulletList.remove(bullet);
	}
	public LinkedList<PlayerBullet> getPlayerBulletList() {
		// TODO Auto-generated method stub
		return PlayerBulletList;
	}
	public LinkedList<Enemy> getEnemyList() {
		// TODO Auto-generated method stub
		return EnemyList;
	}
	
}
