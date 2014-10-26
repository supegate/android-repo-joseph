package Inheritance;

public class InheritanceDemo {
	public static void main(String[] args) {
		SubClass sub = new SubClass();
				
		sub.setNumbers(10, 20);
		System.out.println(sub.getNum1() + " + " + sub.getNum2() + " = " + sub.addition());
		System.out.println(sub.getNum1() + " - " + sub.getNum2() + " = " + sub.subtraction());
		System.out.println(sub.getNum1() + " * " + sub.getNum2() + " = " + sub.multiplication());
		System.out.println(sub.getNum1() + " / " + sub.getNum2() + " = " + sub.division());
	}
}