import java.awt.*;

public class DialogTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("Parent");
		f.setSize(300, 200);
		
		Dialog info = new Dialog(f,"Information",false);
		info.setSize(140, 90);
		info.setLocation(50, 50);
		info.setLayout(new FlowLayout());
		
		Label msg = new Label("This is modal Dialog",Label.CENTER);
		Button ok = new Button("OK");
		info.add(msg);
		info.add(ok);
		
		f.setVisible(true);
		info.setVisible(true);
	}

}
