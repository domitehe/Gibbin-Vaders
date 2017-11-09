import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy extends Object{
	
	protected double speed = 0.04;
	ObjectController c;
	Game game;
	
	public Enemy(double x, double y,ObjectController c, Game game) {
		super(x, y);
		this.c = c;
		this.game = game;
	}
	public void render(Graphics g){
		tick();
		g.drawRect((int)this.x, (int)this.y, 16, 16);
	}
	public void tick(){
		x-=speed;
		for (int i = 0; i < game.PlayerBulletList.size(); i++) {
			 PlayerBullet tempbullet = game.PlayerBulletList.get(i);
			 
			if(Physics.Collision(this, tempbullet)){
				c.removePlayerBullet(tempbullet);
				c.removeEnemy(this);
			}
		}
		
		/*if (Physics.Collision(this, game.p)) {
			Game.State = Game.STATE.FAIL;
		}*/
	}
	public Rectangle getBounds(){
		return new Rectangle((int)this.x, (int)this.y, 16, 16);
	}

	

	
}
