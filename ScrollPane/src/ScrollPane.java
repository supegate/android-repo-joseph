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
		p.add(new Button("ù��°"));
		p.add(new Button("�ι�°"));
		p.add(new Button("����°"));
		p.add(new Button("�׹�°"));
		
		sp.add(p);
		f.add(sp);
		f.setVisible(true);
	}

}
