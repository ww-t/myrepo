import com.leapmotion.leap.Finger;
import com.leapmotion.leap.Finger.Type;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Vector;

public class touchscreen extends newgesture {
	
	float a, b, c, d;
	int count = 0;
	Vector[] checkpoint = new Vector[3];
	Vector touchpoint;
	boolean start = false;
	
	public void setpoint(Frame frame) {
		
		if(valid==true)
			return;
		
		for(Hand hand : frame.hands()) {
			if(hand.isRight()) {
				checkpoint[count] = hand.fingers().fingerType(Type.TYPE_INDEX).get(0).tipPosition();
				count = count+1;
			}
		}
		
		if(count==3) {
			count = 0;
			setscreen();
			setvalid(true);
		}
	}
	
	public void clearscreen() {
		setvalid(false);
	}
	
	public void setscreen() {
		
		Vector p0_p1 = checkpoint[0].minus(checkpoint[1]);
		Vector p0_p2 = checkpoint[0].minus(checkpoint[2]);
		Vector crossproduct = p0_p1.cross(p0_p2);
		
		a = crossproduct.getX();
		b = crossproduct.getY();
		c = crossproduct.getZ();
		d = -(a*checkpoint[0].getX()+b*checkpoint[0].getY()+c*checkpoint[0].getZ());
	}

	@Override
	public boolean isgesture(Frame frame) {
		// TODO Auto-generated method stub
		
		if(valid==false)
			return false;
		
		touchpoint = frame.fingers().frontmost().tipPosition();
		
		if(touchpoint.getX()<checkpoint[0].getX() || touchpoint.getX()>checkpoint[1].getX())
			return false;
		if(touchpoint.getY()>checkpoint[0].getY() || touchpoint.getY()<checkpoint[2].getY())
			return false;
		
		float z = -(a*touchpoint.getX()+b*touchpoint.getY()+d)/c;
		if(touchpoint.getZ()<=z && start==false)
			start = true;
		else if(touchpoint.getZ()>z && start) {
			start = false;
			return true;
		}
		
		return false;
	}
}
