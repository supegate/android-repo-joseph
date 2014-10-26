import java.awt.Frame;
import java.awt.Button;

public class EventSource extends Frame {
	public EventSource(){
		this.setTitle("첫번째 GUI 프로그램");
		Button btn = new Button("버튼을 클릭해 보세요");
		this.add(btn);
		
		this.setSize(500,150);
		this.setVisible(true);
		
		EventHandler eh = new EventHandler();
		btn.addMouseListener(eh);
	}

}
