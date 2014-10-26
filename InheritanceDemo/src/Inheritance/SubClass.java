package Inheritance;

public class SubClass extends SuperClass {
	public int addition() {
		return this.num1 + this.num2;
	}
	
	public int subtraction() {
		return this.num1 - this.num2;
	}
	
	public long multiplication() {
		return this.num1 * this.num2;
	}
	
	public double division() {
		return (double)this.num1 / this.num2;
	}
}