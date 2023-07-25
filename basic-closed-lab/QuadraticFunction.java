package basic.closedlab;

public class QuadraticFunction {
	int a = 1, b = 1, c = 1;

	public QuadraticFunction() {

	}

	public QuadraticFunction(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public int calculate(int x) {
		return (a * x * x) + (b * x) + c;
	}

	public static void main(String[] args) {
		int x = 2;
		QuadraticFunction obj = new QuadraticFunction(2, 2, 2);
		System.out.println("The value of f(x) when x = " + x + ", a = " + obj.a + ", b = " + obj.b + " and c = " + obj.c
				+ " is " + obj.calculate(x));
		obj = new QuadraticFunction();
		System.out.println("The value of f(x) when x = " + x + ", a = " + obj.a + ", b = " + obj.b + " and c = " + obj.c
				+ " is " + obj.calculate(x));
	}
}
