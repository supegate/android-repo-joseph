import java.awt.*;
import java.awt.event.*;

public class TextFieldTest2 extends Frame{
	Label lid;
	Label lpwd;
	TextField tfId;
	TextField tfPwd;
	Button ok;
	
	TextFieldTest2(String title){
		super(title);
		
		lid = new Label("ID:",Label.RIGHT);
		lpwd = new Label("Password :",Label.RIGHT);
		
		tfId = new TextField(10);
		tfPwd = new TextField(10);
		tfPwd.setEchoChar('*');
		
		ok = new Button("OK");
		tfId.addActionListener(new EventHandler());
		tfPwd.addActionListener(new EventHandler());
		ok.addActionListener(new EventHandler());
		
		setLayout(new FlowLayout());
		add(lid);
		add(tfId);
		add(lpwd);
		add(tfPwd);
		add(ok);
		setSize(450,65);
		setVisible(true);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextFieldTest2 f = new TextFieldTest2("Login");
	}
	
	class EventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String id = tfId.getText();
			String password = tfPwd.getText();
			if(!id.equals("javachobo")){
				System.out.println("�Է��Ͻ� id�� ��ȿ���� �ʽ��ϴ�. �ٽ� �Է��� �ּ���.");
				tfId.requestFocus();
				tfId.selectAll();			
			}else if(!password.equals("asdf")){
				System.out.println("�Է��Ͻ� ��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է����ֽñ� �ٶ��ϴ�.");
				tfPwd.requestFocus();
				tfPwd.selectAll();
			}else {
				System.out.println(id+"��, ���������� �α��� �Ǿ����ϴ�.");
			}
		}
	}//class EventHandler

}
