import java.awt.*;

public class FlowLayoutTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("FlowLayoutTest");
		f.setSize(250, 100);
		f.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		f.add(new Button("첫 번째"));
		f.add(new Button("두 번째"));
		f.add(new Button("세 번째"));
		f.add(new Button("네 번째"));
		f.add(new Button("다섯 번째"));
		f.setVisible(true);
	}

}
