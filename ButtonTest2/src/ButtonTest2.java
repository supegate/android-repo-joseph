import java.awt.*;

public class ButtonTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("Login");
		f.setSize(300,200);
		f.setLayout(null);
		
		Button b = new Button("»Æ ¿Œ");
		b.setSize(100,50);
		b.setLocation(100, 75);
		
		f.add(b);
		f.setVisible(true);		
		
	}

}
