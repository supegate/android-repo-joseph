import java.awt.Frame;
import java.awt.Button;

public class EventSource extends Frame {
	public EventSource(){
		this.setTitle("ù��° GUI ���α׷�");
		Button btn = new Button("��ư�� Ŭ���� ������");
		this.add(btn);
		
		this.setSize(500,150);
		this.setVisible(true);
		
		EventHandler eh = new EventHandler();
		btn.addMouseListener(eh);
	}

}
