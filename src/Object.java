import java.awt.Rectangle;

public class Object {
	public double x, y;
	
	public Object(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public Rectangle getRectangle(int width, int height){
		return new Rectangle((int)x, (int)y, width, height);
	}
	
}
