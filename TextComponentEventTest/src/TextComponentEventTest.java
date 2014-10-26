import java.awt.*;
import java.awt.event.*;

public class TextComponentEventTest extends Frame {

	/**
	 * @param args
	 */
	TextField tf;
	TextArea ta;
	
	TextComponentEventTest(String title){
		super(title);
		
		tf = new TextField();
		ta = new TextArea();
		add(ta,"Center");
		add(tf,"South");
		
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ta.append(tf.getText()+"\n");
				tf.setText("");
				tf.requestFocus();
			}
		});
		ta.setEditable(false);
		setSize(300,200);
		setVisible(true);
		tf.requestFocus();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextComponentEventTest mainWin = new TextComponentEventTest("TextComponentEventTest");
	}

}
