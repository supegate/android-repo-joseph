import java.awt.*;

public class TextFieldTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("Login");
		f.setSize(400,65);
		f.setLayout(new FlowLayout());
		
		Label lid = new Label("ID :",Label.RIGHT);
		Label lpwd = new Label("Password :",Label.RIGHT);
		
		TextField id = new TextField(10);
		TextField pwd = new TextField(10);
		pwd.setEchoChar('*');
		
		f.add(lid);
		f.add(id);
		f.add(lpwd);
		f.add(pwd);
		f.setVisible(true);
	}

}
