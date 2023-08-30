package assignments1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <b>Assignment from Arithmetic Operations topic</b>
 * <p>
 * This class contains a method that implements logic for performing reminder
 * operation of numbers along with the main method which is already programmed
 * for taking user inputs and display the result.
 * 
 * @author syed anwar
 * @category Arithmetic operations
 */
public class Reminder {
	/**
	 * The main method that is preprogrammed to accept relevant inputs and print the
	 * output into the console to demonstrate the reminder functionality.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/* Try with resource block is being used, so we don't need to explicitly close
		   the scanner object */

		try (Scanner sc = new Scanner(System.in)) {// scanner object is initialized with source from console

			System.out.println("Enter the First number");// prompting user to enter input

			int int1 = sc.nextInt();// using nextInt() which accepts only int data type from the source

			System.out.println("Enter the Second number");

			int int2 = sc.nextInt();

			int result = modulo(int1, int2); // modulo method is being invoked and returns the reminder

			System.out.println("The result is " + result);

		} catch (Exception e) {// catching thrown exceptions to handle

			if (e instanceof InputMismatchException) // handling the InputMismatchException with a user friendly message
				System.out.println("Please enter number between the range of " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);

			// handling the ArithmeticException with a user friendly message
			else if (e instanceof ArithmeticException)
				System.out.println("The result is NaN");

			else
				e.printStackTrace(); // Other unhandled Exceptions trace will be printed if there's any
		}
	}

	/**
	 * This method does the operation reminder between two integers.
	 * 
	 * @param the integer that we want to perform reminder operation
	 * @param the integer that we want to perform reminder operation with
	 * @return returns the reminder
	 */
	public static int modulo(int a, int b) { // takes two double as argument

		return a % b; // the % operator has been used for modulo operation and the method returns
						// double
	}

}