import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.lang.Integer;

public class SimpleCalcEventHandler implements ActionListener { 
	SimpleCalcEventSources simpleCalcEventSources;
	
	public SimpleCalcEventHandler(SimpleCalcEventSources simpleCalcEventSources) {
		this.simpleCalcEventSources = simpleCalcEventSources;
	}
	
	public void actionPerformed(ActionEvent ae){
		Button eventSource = (Button)ae.getSource();
		
		if(eventSource.getLabel().equals("����")){
			System.out.println("���� ��ư�� Ŭ����");
			Integer operand1 = new Integer(this.simpleCalcEventSources.oprand1TextField.getText());
			Integer operand2 = new Integer(this.simpleCalcEventSources.oprand2TextField.getText());
			Integer result = new Integer(operand1.intValue()+operand2.intValue());
			this.simpleCalcEventSources.resultTextField.setText(result.toString());			
			
		}else if(eventSource.getLabel().equals("���")){
			System.out.println("��� ��ư�� Ŭ����");
			this.simpleCalcEventSources.oprand1TextField.setText(" ");
			this.simpleCalcEventSources.oprand2TextField.setText(" ");
			this.simpleCalcEventSources.resultTextField.setText(" ");
			this.simpleCalcEventSources.setTitle(this.simpleCalcEventSources.getTitle()+"-��ҵ�");		
			
		}
	}

}
