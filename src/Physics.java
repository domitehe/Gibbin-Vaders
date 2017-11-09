
public class Physics {
	
    public static boolean Collision(Enemy enemy, PlayerBullet bullet) {
        return enemy.getBounds().intersects(bullet.getBounds());
    }

    /*public static boolean Collision(EntityB entb, EntityA enta) {
        return entb.getBounds().intersects(enta.getBounds());
    }*/
}
