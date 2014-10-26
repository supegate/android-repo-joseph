import java.awt.Button;
import java.awt.Checkbox;
import java.awt.event.*;

public class ChineseOrderEventHandler implements ActionListener{
	ChineseOrderEventSources chineseOrderEventSources;
	static int OrderNumber = 0;
	
	public ChineseOrderEventHandler(ChineseOrderEventSources chineseOrderEventSources){
		this.chineseOrderEventSources = chineseOrderEventSources;
	}
	public void actionPerformed(ActionEvent ae){
		Button eventSource = (Button)ae.getSource();
		
		if(eventSource.getLabel().equals("주문")){
			System.out.println("주문 버튼이 클릭됨");
			this.chineseOrderEventSources.setTitle("중국음식-주문함");
			
		}else if(eventSource.getLabel().equals("취소")){
			System.out.println("취소 버튼이 클릭됨");
			this.chineseOrderEventSources.setTitle("중국음식-취소함");			
		}
	}
}