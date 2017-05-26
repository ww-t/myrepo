import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;


public class leftclench extends newgesture {
	
	boolean start = false;

	@Override
	public boolean isgesture(Frame frame) {
		// TODO Auto-generated method stub
		
		if(valid==false)
			return false;
		
		for(Hand hand : frame.hands()) {
			if(hand.isLeft()){
				if(hand.grabAngle()>3 && start==false)
					start = true;
				else if(hand.grabAngle()<3 && start){
					start = false;
					return true;
				}
			}
		}
		
		return false;
	}

}
