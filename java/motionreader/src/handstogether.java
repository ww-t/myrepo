import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Vector;


public class handstogether extends newgesture {

	@Override
	public boolean isgesture(Frame frame) {
		// TODO Auto-generated method stub
		
		Vector lhp = null, rhp = null;
		
		if(valid==false)
			return false;
		if(frame.hands().count()!=2)
			return false;
		
		for(Hand hand : frame.hands()) {
			if(hand.isLeft())
				lhp = hand.palmPosition();
			if(hand.isRight())
				rhp = hand.palmPosition();
		}
		
		if(lhp.distanceTo(rhp)<13)
			return true;
		
		return false;
	}

}
