package assignments1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <b>Assignment from Arithmetic Operations topic</b>
 * <p>
 * This class contains a method that implements logic for division of two
 * numbers along with the main method which is already programmed for taking
 * user inputs and display the result.
 * 
 * @author Syed anwar
 * @category Arithmetic Operations
 *
 */
public class Division {
	/**
	 * The main method that is preprogrammed to accept relevant inputs and print the
	 * output into the console to demonstrate the Division functionality.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/* Try with resource block is being used, so we don't need to explicitly close
		   the scanner object */

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
	 * This method does the division operation of two integers.
	 * 
	 * @param a as double
	 * @param b as double
	 * @return returns quotient as double
	 */
	public static double divide(double a, double b) { // takes two double as argument

		return a / b; // the / operator has been used for division and the method returns double
	}
}