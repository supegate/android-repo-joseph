import java.awt.*;

public class ScrollPane {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("ScrollPaneTest");
		f.setSize(300, 200);
		
		ScrollPane sp = new ScrollPane();
		Panel p = new Panel();
		p.setBackground(Color.green);
		p.add(new Button("첫번째"));
		p.add(new Button("두번째"));
		p.add(new Button("세번째"));
		p.add(new Button("네번째"));
		
		sp.add(p);
		f.add(sp);
		f.setVisible(true);
	}

}
