package assignments1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author syed anwar
 * @category Arithmetic operations
 */
public class Multiplication {

	public static void main(String[] args) {
		/* Try with resource block is being used, so we don't need to explicitly close
		   the scanner object */

		try (Scanner sc = new Scanner(System.in)) {// scanner object is initialized with source from console

			System.out.println("Enter the First number");// prompting user to enter input

			int int1 = sc.nextInt();// using nextInt() which accepts only int data type from the source

			System.out.println("Enter the Second number");

			int int2 = sc.nextInt();

			int result = multiply(int1, int2); // multiply method is being invoked and returns the product

			System.out.println("The result is " + result);// printing the result

		} catch (Exception e) {// catching thrown exceptions to handle

			if (e instanceof InputMismatchException) // handling the InputMismatchException with a user friendly message
				System.out.println(
						"Please enter number between the range of " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);

			else if (e instanceof IllegalArgumentException) // handling the IllegalArgumentException with a user
															// friendly message
				System.out.println("The product goes beyond the allocated memory range!" + "\n(MEMORY LIMIT EXCEEDED)");

			else
				e.printStackTrace(); // Other unhandled Exceptions trace will be printed if there's any
		}
	}

	/**
	 * 
	 * @param num1 as int
	 * @param num2 as int
	 * @return returns the product of the two integers as int
	 */
	public static int multiply(int num1, int num2) { // takes two int as arguments

		// Added to avoid the result getting truncated and to prevent from incorrect
		// results

		// this logic will work for preventing overflow including double,long,float

		int temp1 = (num1 > 0) ? num1 : num1 * -1; // making the numbers positive if they're negative
		int temp2 = (num2 > 0) ? num2 : num2 * -1;

		if (temp1 != 0 && temp2 != 0 && temp1 > Integer.MAX_VALUE / temp2) // if the product goes beyond the int range then throws exception
			throw new IllegalArgumentException();

		int product = num1 * num2; // multiplication performed by * operator

		return product; // return int
	}

}
