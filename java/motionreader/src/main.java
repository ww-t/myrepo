import java.io.IOException;

import com.leapmotion.leap.*;
import com.leapmotion.leap.Controller.PolicyFlag;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listener listener = new listener();
		Controller controller = new Controller();
		
		controller.addListener(listener);
		controller.setPolicy(PolicyFlag.POLICY_BACKGROUND_FRAMES);
			
		System.out.println("Press Enter to quit...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        controller.removeListener(listener);
	}
}
