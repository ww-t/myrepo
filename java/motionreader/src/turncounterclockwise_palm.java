import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Vector;


public class turncounterclockwise_palm extends newgesture {
	
	boolean start = false;

	@Override
	public boolean isgesture(Frame frame) {
		// TODO Auto-generated method stub
		
		if(valid==false)
			return false;
		
		for(Hand hand : frame.hands()) {
			if(hand.isRight()){
				Vector palmvector = hand.palmNormal();
				Vector leftvector = Vector.left();
				Vector downvector = Vector.down(); 
				
				if (!palmvector.isValid())
					return false;

				if ((double)palmvector.angleTo(leftvector) < Math.PI / 2 / 9)
					start = true;
				else if((double)palmvector.angleTo(downvector) < Math.PI / 2 / 9 && start){
					start = false;
					return true;
				}
			}
		}
		
		return false;
	}

}
