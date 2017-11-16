
public class Physics {
	
    public static boolean Collision(EntityEnemy tempee, EntityPlayer tempep) {
        return tempee.getBounds().intersects(tempep.getBounds());
    }
    
    public static boolean Collision(EntityPlayer tempep, EntityEnemy tempee){
		return tempep.getBounds().intersects(tempee.getBounds());
    }

}
