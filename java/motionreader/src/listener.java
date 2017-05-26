import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Listener;


public class listener extends Listener {
	
	newgesture us, ds, ls, rs, lc, rc, ht, bs, ph;
	touchscreen ts;
	Robot rb;
	boolean vbutton = false;
	
	public void onInit(Controller controller) {
		System.out.println("Initialized");
	}
	
	public void onConnect(Controller controller) {
        System.out.println("Connected");
        
        us = new upswipe(controller);
        us.setvalid(true);
        ds = new downswipe(controller);
        ds.setvalid(true);
        ls = new leftswpie(controller);
        ls.setvalid(true);
        rs = new rightswipe(controller);
        rs.setvalid(true);
        lc = new leftclench();
        lc.setvalid(true);
        rc = new rightclench();
        rc.setvalid(true);
        ht = new handstogether();
        ht.setvalid(true);
        ph = new pointerhand();
        ph.setvalid(true);
        bs = new breaststroke();
        bs.setvalid(true);
        ts = new touchscreen();
        
        try {
			rb = new Robot();
			rb.setAutoDelay(1);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void onDisconnect(Controller controller) {
        System.out.println("Disconnected");
    }

    public void onExit(Controller controller) {
        System.out.println("Exited");
    }
    
    public void onFrame(Controller controller) {
    	Frame frame = controller.frame();
    	
    	if(us.isgesture(frame)) {
    		rb.keyPress(KeyEvent.VK_SHIFT);
    		rb.keyPress(KeyEvent.VK_F5);
    		rb.keyRelease(KeyEvent.VK_F5);
    		rb.keyRelease(KeyEvent.VK_SHIFT);
    	}
    	
    	else if(ds.isgesture(frame)) {
    		rb.keyPress(KeyEvent.VK_ESCAPE);
    		rb.keyRelease(KeyEvent.VK_ESCAPE);
    	}
    	
    	else if(ls.isgesture(frame)) {
    		rb.keyPress(KeyEvent.VK_RIGHT);
    		rb.keyRelease(KeyEvent.VK_RIGHT);
    	}
    	
    	else if(rs.isgesture(frame)) {
    		rb.keyPress(KeyEvent.VK_LEFT);
    		rb.keyRelease(KeyEvent.VK_LEFT);
    	}
    	
    	else if(ht.isgesture(frame)) {
    		rb.keyPress(KeyEvent.VK_ALT);
    		rb.keyPress(KeyEvent.VK_F4);
    		rb.keyRelease(KeyEvent.VK_F4);
    		rb.keyRelease(KeyEvent.VK_ALT);
    	}
    	
    	else if(frame.hands().count()==2 && ph.isgesture(frame) && lc.isgesture(frame)) {
    		System.out.println("check");
    		ts.setpoint(frame);
    	}
    	
    	else if(ts.isgesture(frame)) {
    		rb.keyPress(KeyEvent.VK_F5);
    		rb.keyRelease(KeyEvent.VK_F5);
    	}
    	
    	else if(rc.isgesture(frame)) {
    		rb.keyPress(KeyEvent.VK_ENTER);
    		rb.keyRelease(KeyEvent.VK_ENTER);
    	}
    	
    	else if(bs.isgesture(frame)) {
    		ts.clearscreen();
    	}
    }
}
