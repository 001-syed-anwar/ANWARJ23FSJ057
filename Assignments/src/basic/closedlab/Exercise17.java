package basic.closedlab;

public class Exercise17 {
	/*
	 * Fields declared as final cannot be modified, methods declared as final cannot
	 * be overridden.
	 */
	public static final double PI = 3.14d;

	public static void main(String[] args) {
		// cannot modify the data
		// Exercise17.PI=12;

		/*
		 * In a class definition, if a parameterized constructor was defined then we
		 * cannot use default constructor. To use default constructor as well, then we
		 * must have to explicitly define a constructor with no parameters.
		 */
		// Exercise17 obj = new Exercise17();

	}

	public void accessStaticMember() {
		// Accessing static member from instance method
		System.out.println("The value of PI is " + Exercise17.PI);
	}

	public Exercise17(int i) {
		System.out.println("Parameterized constructor with the parameter " + i);
	}
}