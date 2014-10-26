import java.awt.*;

public class CanvasTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("CanvasTest");
		f.setSize(300, 200);
		f.setLayout(null);
		
		Canvas c = new Canvas();
		c.setBackground(Color.pink);
		c.setBounds(50,50,150, 100);
		
		f.add(c);
		f.setVisible(true);
	}

}
