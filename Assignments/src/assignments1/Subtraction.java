package assignments1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <b>Assignment from Arithmetic Operations topic</b>
 * <p>
 * This class contains a method that implements logic for subtraction of two
 * numbers along with the main method which is already programmed for taking
 * user inputs and display the result.
 * 
 * 
 * @author syed anwar
 * @category Arithmetic operations
 */
public class Subtraction {
	/**
	 * The main method that is preprogrammed to accept relevant inputs and print the
	 * output into the console to demonstrate the subtraction
	 * functionality.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/* Try with resource block is being used, so we don't need to explicitly close
		   the scanner object */

		try (Scanner sc = new Scanner(System.in)) {// scanner object is initialized with source from console

			System.out.println("Enter the First number"); // prompting user to enter input

			int int1 = sc.nextInt(); // using nextInt() which accepts only int data type from the source

			System.out.println("Enter the Second number");

			int int2 = sc.nextInt();

			int result = subtract(int1, int2); // subtract method is being invoked and returns the difference

			System.out.println("The result is " + result);// printing the result

		} catch (Exception e) { // catching thrown exceptions to handle

			if (e instanceof InputMismatchException) // handling the InputMismatchException with a user friendly message
				System.out.println("Please enter number between the range of " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);

			else
				e.printStackTrace(); // Other unhandled Exceptions trace will be printed if there's any
		}
	}

	/**
	 * This method does the subtraction operation of two integers.
	 * 
	 * @param num1 as int
	 * @param num2 as int
	 * @return returns the difference of two integers as int
	 */
	public static int subtract(int num1, int num2) { // takes two int as arguments

		int sub = num1 - num2; // - operator is being used to perform subtraction

		return sub; // returns int
	}

}