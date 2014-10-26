import java.awt.*;

public class ChineseOrderEventSources extends Frame {
	TextField orderNameTextField, orderTelTextField, quantityTextField;
	TextArea orderResultTextArea;
	List menuChoice;
	CheckboxGroup checkboxGroup;
	Checkbox singleCheck, doubleCheckbox;
	Checkbox option1Checkbox, option2Checkbox;
	Button orderButton, cancelButton;
	
	ChineseOrderEventHandler chineseOrderEventHandler;
	
	public ChineseOrderEventSources(){
		this.setTitle("중국음식 주문");
		this.setSize(480,400);
		this.CreateUserComponent();
		this.setVisible(true);
	}

	private void CreateUserComponent() {
		// TODO Auto-generated method stub
		Label orderNameLabel = new Label("주문자명:");
		Label orderTLabel = new Label("연 락 처:");
		Label quantityLabel = new Label("주문수량:");
		
		orderNameTextField = new TextField(10);
		orderTelTextField = new TextField(10);
		quantityTextField = new TextField(10);
		
		menuChoice = new List(6,true);
		menuChoice.add("자장면");
		menuChoice.add("짬봉");
		menuChoice.add("볶음밥");
		menuChoice.add("탕수육");
		menuChoice.add("자장면자장면자장면자장면자장면자장면자장면자장면자장면자장면자장면");
		menuChoice.add("짬봉");
		menuChoice.add("볶음밥");
		menuChoice.add("탕수육");
		
		checkboxGroup = new CheckboxGroup();
		Checkbox singleCheckbox = new Checkbox("기    본",checkboxGroup,true);
		doubleCheckbox = new Checkbox("곱배기",checkboxGroup,false);
		
		option1Checkbox = new Checkbox("숟/젖가락");
		option2Checkbox = new Checkbox("쓰레기봉투");
		
		orderButton = new Button("주문");
		cancelButton = new Button("취소");
		
		orderResultTextArea = new TextArea(10,60);
		
		Panel panel = new Panel();
		panel.add(orderNameLabel);
		panel.add(orderNameTextField);
		panel.add(orderTLabel);
		panel.add(orderTelTextField);
		panel.add(menuChoice);
		panel.add(quantityLabel);
		panel.add(quantityTextField);
		panel.add(singleCheckbox);
		panel.add(doubleCheckbox);
		panel.add(option1Checkbox);
		panel.add(option2Checkbox);
		panel.add(orderButton);
		panel.add(cancelButton);
		panel.add(orderResultTextArea);		
		this.add(panel);
		
		chineseOrderEventHandler = new ChineseOrderEventHandler(this);
		orderButton.addActionListener(chineseOrderEventHandler);
		cancelButton.addActionListener(chineseOrderEventHandler);
	}
}
