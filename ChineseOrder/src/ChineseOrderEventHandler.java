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
		
		if(eventSource.getLabel().equals("�ֹ�")){
			System.out.println("�ֹ� ��ư�� Ŭ����");
			this.chineseOrderEventSources.setTitle("�߱�����-�ֹ���");
			
		}else if(eventSource.getLabel().equals("���")){
			System.out.println("��� ��ư�� Ŭ����");
			this.chineseOrderEventSources.setTitle("�߱�����-�����");			
		}
	}
}