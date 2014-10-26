import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventHandler extends MouseAdapter {
	public void mouseClicked(MouseEvent me){
		System.out.println("마우스가 클릭 되었습니다.");
	}
}
