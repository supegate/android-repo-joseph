import java.awt.*;

public class ColorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("Color Test");
		f.setLayout(new GridLayout(14,2));
		Panel p1 = new Panel();	p1.setBackground(Color.black);
		Panel p13 = new Panel(); p13.setBackground(Color.yellow);
		Panel p14 = new Panel(); p14.setBackground(new Color(50,100,100));
		
		f.add(new Label("Color.black")); f.add(p1);
		f.add(new Label("Color.yellow")); f.add(p13);
		f.add(new Label("Color(50,100,100)")); f.add(p14);
		
		f.setSize(250, 300);
		f.setVisible(true);
	}
}
