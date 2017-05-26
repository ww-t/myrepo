
public class normalizetipposition {
	
	public static float getx(touchscreen ts) {
		
		return Math.abs(ts.touchpoint.getX()-ts.checkpoint[0].getX())/Math.abs(ts.checkpoint[1].getX()-ts.checkpoint[0].getX());
	}
	
	public static float gety(touchscreen ts) {
		
		return Math.abs(ts.checkpoint[0].getY()-ts.touchpoint.getY())/Math.abs(ts.checkpoint[0].getY()-ts.checkpoint[2].getY());
	}
}