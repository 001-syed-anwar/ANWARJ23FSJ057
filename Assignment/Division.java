package assignments1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Division {
	public static void main(String[] args) {
		// Try with resource block is being used, so we don't need to explicitly close
		// the scanner object

		try (Scanner sc = new Scanner(System.in)) {// scanner object is initialized with source from console

			System.out.println("Enter the First number"); // prompting user to enter input

			double int1 = sc.nextDouble();// using nextDouble() which accepts only double data type from the source

			System.out.println("Enter the Second number");

			double int2 = sc.nextDouble();

			double result = divide(int1, int2);// divide method is being invoked and returns the quotient

			System.out.println("The result is " + result);// printing the result

		} catch (Exception e) {// catching thrown exceptions to handle

			if (e instanceof InputMismatchException) // handling the InputMismatchException with a user friendly message
				System.out.println(
						"Please enter number between the range of " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);

			// since we're using double we don't need to explicitly handle the exception of
			// division by zero
			// else if(e instanceof ArithmeticException) System.out.println("The result is
			// Infinity");

			else
				e.printStackTrace(); // Other unhandled Exceptions trace will be printed if there's any
		}
	}

	/**
	 * 
	 * @param a as double
	 * @param b as double
	 * @return returns quotient as double
	 */
	public static double divide(double a, double b) { // takes two double as argument

		return a / b; // the / operator has been used for division and the method returns double
	}
}
