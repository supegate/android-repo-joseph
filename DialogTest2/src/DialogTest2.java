import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("Parent");
		f.setSize(300, 200);
		
		final Dialog info = new Dialog(f,"Information",true);
		info.setSize(140, 90);
		info.setLocation(50,50);
		//info.setLocation(400,500);
		info.setLayout(new FlowLayout());
		
		Label msg = new Label("This is modal Dialog",Label.CENTER);
		Button ok = new Button("OK");
		
		ok.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				info.setVisible(false);
				info.dispose();
			}
		});
		info.add(msg);
		info.add(ok);
		f.setVisible(true);
		info.setVisible(true);
		
	}

}