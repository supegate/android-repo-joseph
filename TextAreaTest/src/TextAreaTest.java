import java.awt.*;

public class TextAreaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("Comments");
		f.setSize(400,220);
		f.setLayout(new FlowLayout());
		
		TextArea comments = new TextArea("�ϰ� ���� ���� ��������.",10,50);
		
		f.add(comments);
		comments.selectAll();
		f.setVisible(true);
	}
}
