import java.awt.*;

public class SimpleCalcEventSources extends Frame { 
	Label commentLabel, operator1Label, operator2Label;
	TextField oprand1TextField, oprand2TextField, resultTextField;
	Button runButton, cancelButton;
	Panel panel;
	
	public SimpleCalcEventSources(){
		this.setTitle("계산기");
		this.setSize(500, 100);
		this.setLocation(300, 100);
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		
		commentLabel = new Label("두 수를 입력한 후 실행 버튼을 클릭하세요.");
		operator1Label = new Label("+");
		operator1Label.setAlignment(1);
		operator2Label = new Label("=");
		operator2Label.setAlignment(1);
		
		oprand1TextField = new TextField(3);
		oprand2TextField = new TextField(3);
		resultTextField = new TextField(4);
		resultTextField.setEditable(false);
		
		runButton = new Button("실행");
		cancelButton = new Button("취소");
		
		this.add(commentLabel);
		this.add(oprand1TextField);
		this.add(operator1Label);
		this.add(oprand2TextField);
		this.add(operator2Label);
		this.add(resultTextField);
		this.add(runButton);
		this.add(cancelButton);
		
		SimpleCalcEventHandler simpleCalcEventhandler = new SimpleCalcEventHandler(this);
		runButton.addActionListener(simpleCalcEventhandler);
		cancelButton.addActionListener(simpleCalcEventhandler);
	}

}
