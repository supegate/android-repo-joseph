import java.awt.*;

public class GridLayoutTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("GridLayoutTest");
		f.setSize(150, 150);
		f.setLayout(new GridLayout(3,2));
		f.add(new Button("1"));
		f.add(new Button("2"));
		f.add(new Button("3"));
		f.add(new Button("4"));
		f.add(new Button("5"));
		f.add(new Button("6"));
		
		f.setVisible(true);
	}

}
