import java.awt.*;

public class PanelTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("Panel");
		f.setSize(300,200);
		f.setLayout(null);
		
		Panel p = new Panel();
		p.setBackground(Color.green);
		p.setSize(100,200);
		p.setLocation(50, 50);
		
		Button ok = new Button("OK");
		
		p.add(ok);
		f.add(p);
		f.setVisible(true);
	}

}
