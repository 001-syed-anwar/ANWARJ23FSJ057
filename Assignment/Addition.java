package assignments1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author Syed Anwar
 * @category Arithmetic Operations
 *
 */
public class Addition {

	public static void main(String[] args) {
		// Try with resource block is being used, so we don't need to explicitly close
		// the scanner object

		try (Scanner sc = new Scanner(System.in)) { // scanner object is initialized with source from console

			System.out.println("Enter the First number"); // prompting user to enter input

			int int1 = sc.nextInt(); // using nextInt() which accepts only int data type from the source

			System.out.println("Enter the Second number");

			int int2 = sc.nextInt();

			int result = add(int1, int2); // add method is being invoked and returns the sum

			System.out.println("The result is " + result); // printing the result

		} catch (Exception e) { // catching thrown exceptions to handle

			if (e instanceof InputMismatchException) // handling the InputMismatchException with a user friendly message
				System.out.println(
						"Please enter number between the range of " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
			else
				e.printStackTrace();// Other unhandled Exceptions trace will be printed if there's any
		}
	}

	/**
	 * 
	 * @param first  integer
	 * @param second integer
	 * @return returns the sum of two integers
	 */
	public static int add(int num1, int num2) { // takes two int as arguments

		int sum = num1 + num2; // + operator is being used to perform addition

		return sum; // returns int
	}

}
