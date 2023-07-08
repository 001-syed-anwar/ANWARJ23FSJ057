package assignments2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <b>Assignment from Recursion topic</b>
 * <p>
 * This class contains a method that implements logic for finding GCD of two
 * numbers along with the main method which is already programmed for taking
 * user inputs and display the result.
 * 
 * @author Syed Anwar
 * @category recursion
 *
 */
public class GCD {
	/**
	 * The main method that is preprogrammed to accept relevant inputs and print the
	 * output into the console to demonstrate the GCD functionality.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Try with resource block is being used, so we don't need to explicitly close
		 * the scanner object.
		 */
		try (Scanner sc = new Scanner(System.in)) {// scanner object is initialized with source from console

			System.out.println("Enter the First number you want to find gcd :");// prompting user to enter input

			int a = sc.nextInt();// using nextInt() which accepts only byte data as input

			if (a < 0)
				throw new InputMismatchException();

			System.out.println("Enter the Second number you want to find gcd :");

			int b = sc.nextInt();

			if (b < 0)
				throw new InputMismatchException();

			int result = gcd(a, b); // gcd method is being invoked

			System.out.println("The result is " + result);// printing the result

		} catch (Exception e) {// catching thrown exceptions to handle

			if (e instanceof InputMismatchException) // handling the InputMismatchException with a user friendly message
				System.out.println("Please enter element Positive Integers in range 0 to " + Integer.MAX_VALUE);

			else
				e.printStackTrace(); // Other unhandled Exceptions trace will be printed if there's any
		}
	}

	/**
	 * TThis method computes GCD of two numbers.
	 * 
	 * @param a as int
	 * @param b as int
	 * @return int
	 */
	public static int gcd(int a, int b) {
		// Euclidean Algorithm for calculation of GCD is applied

		/*
		 * We recursively call the method,until we find the gcd of the two considering
		 * numbers. when b is 0,we have found the gcd of a and b.
		 */

		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}
