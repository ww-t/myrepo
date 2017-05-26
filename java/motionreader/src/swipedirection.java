import java.util.ArrayList;
import java.util.Collections;

import com.leapmotion.leap.Hand;


public class swipedirection {

	static int up = 1, down = 2, left = 3, right = 4, none = 0;
	
	public static int direction(Hand hand) {
		
		int max, d = none;
		float pvx, pvy, pvz;
		ArrayList<Float> v = new ArrayList<Float>();
		
		pvx = hand.palmVelocity().getX();
		pvy = hand.palmVelocity().getY();
		pvz = hand.palmVelocity().getZ();
		
		v.add(Math.abs(pvx));
		v.add(Math.abs(pvy));
		v.add(Math.abs(pvz));
		
		max = v.indexOf(Collections.max(v));
		
		switch(max) {
		case 0:
			if(pvx>0)
				d = right;
			else
				d = left;
			break;
		case 1:
			if(pvy>0)
				d = up;
			else
				d = down;
			break;
		case 2:
			d = none;
			break;
		}
		
		return d;
	}
}
