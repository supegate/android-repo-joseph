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
		this.setTitle("�߱����� �ֹ�");
		this.setSize(480,400);
		this.CreateUserComponent();
		this.setVisible(true);
	}

	private void CreateUserComponent() {
		// TODO Auto-generated method stub
		Label orderNameLabel = new Label("�ֹ��ڸ�:");
		Label orderTLabel = new Label("�� �� ó:");
		Label quantityLabel = new Label("�ֹ�����:");
		
		orderNameTextField = new TextField(10);
		orderTelTextField = new TextField(10);
		quantityTextField = new TextField(10);
		
		menuChoice = new List(6,true);
		menuChoice.add("�����");
		menuChoice.add("«��");
		menuChoice.add("������");
		menuChoice.add("������");
		menuChoice.add("�������������������������������������������������������");
		menuChoice.add("«��");
		menuChoice.add("������");
		menuChoice.add("������");
		
		checkboxGroup = new CheckboxGroup();
		Checkbox singleCheckbox = new Checkbox("��    ��",checkboxGroup,true);
		doubleCheckbox = new Checkbox("�����",checkboxGroup,false);
		
		option1Checkbox = new Checkbox("��/������");
		option2Checkbox = new Checkbox("���������");
		
		orderButton = new Button("�ֹ�");
		cancelButton = new Button("���");
		
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
