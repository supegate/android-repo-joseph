import java.awt.*;
import java.awt.event.*;


public class FrameTest3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("Login");
		f.setSize(300, 200);
		
		f.addWindowListener(new EventHandler());
		f.setVisible(true);
		
	}

}
