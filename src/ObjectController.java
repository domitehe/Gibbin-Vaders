import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ObjectController {
	private List EnemyBulletList;
	private LinkedList<PlayerBullet> PlayerBulletList = new LinkedList <PlayerBullet>();
	private Game game;
	
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
			
			/*int i = 0;
			for(PlayerBullet bullet : PlayerBulletList){
				bullet = PlayerBulletList.get(i);
				bullet.tick();
				i++;
			}*/
		}
	}
	public void render(Graphics g){
		for(PlayerBullet bullet : PlayerBulletList){
			bullet.render(g);
		}
	}
	public void addPlayerBullet(PlayerBullet bullet){
		PlayerBulletList.add(bullet);
	}
	public void removePlayerBullet(PlayerBullet bullet){
		PlayerBulletList.remove(bullet);
	}
	
}
