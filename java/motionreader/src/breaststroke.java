import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Vector;


public class breaststroke extends newgesture {
	
	boolean start = false;

	@Override
	public boolean isgesture(Frame frame) {
		// TODO Auto-generated method stub
		
		Hand lh = null, rh = null;
		
		if(valid==false)
			return false;
		if(frame.hands().count()!=2)
			return false;
		
		for(Hand hand : frame.hands()) {
			if(hand.isLeft())
				lh = hand;
			if(hand.isRight())
				rh = hand;
		}
		
		if(lh.palmPosition().distanceTo(rh.palmPosition())<170
				&& lh.palmNormal().roll()<-0.2 && lh.palmNormal().roll()>-2
				&& rh.palmNormal().roll()<2 && rh.palmNormal().roll()>0.2
				&& start==false)
			start = true;
		
		else if(lh.palmPosition().distanceTo(rh.palmPosition())>350
				&& lh.palmNormal().roll()<-0.2 && lh.palmNormal().roll()>-2
				&& rh.palmNormal().roll()<2 && rh.palmNormal().roll()>0.2
				&& start) {
			start = false;
			return true;
		}
		
		return false;
	}


}
