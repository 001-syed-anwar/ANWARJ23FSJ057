package assignments1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author syed anwar
 * @category Arithmetic operations
 */
public class SquareRoot {

	public static void main(String[] args) {
		/* Try with resource block is being used, so we don't need to explicitly close
		   the scanner object */

		try (Scanner sc = new Scanner(System.in)) {// scanner object is initialized with source from console

			System.out.println("Enter the number you want to find Square root :");// prompting user to enter input

			double int1 = sc.nextDouble(); // using nextDouble() which accepts only double data type from the source

			double result = squareRoot(int1); // invoking the squareRoot method and return double

			System.out.println("The result is " + result); // printing the result

		} catch (Exception e) {// catching thrown exceptions to handle

			if (e instanceof InputMismatchException) // handling the InputMismatchException with a user friendly message
				System.out.println("Please enter positive integer number!");

			else if (e instanceof IllegalArgumentException) // handling the IllegalArgumentException with a user
															// friendly message
				System.out.println("SquareRoot of negative numbers is not supported!");

			else
				e.printStackTrace(); // Other unhandled Exceptions trace will be printed if there's any
		}
	}

	/**
	 * 
	 * @param number that we want to find square root
	 * @throws IllegalArgumentException
	 * @return returns square root
	 */
	public static double squareRoot(double number) {

		// babylonian method for finding square root is applied

		// if negative number passed as an argument then throws exception
		if (number < 0)
			throw new IllegalArgumentException();

		// According to babylonian method we make some Initial guess less than root of
		// number that we want find square root.
		double guess = 1;

		// picking a close guess as much as possible
		for (double i = 2; i * i <= number; i++) {
			guess = i;
		}

		// Iteratively improve the accuracy
		// for better accuracy increase the loop range
		for (int i = 0; i < 10; i++) {
			guess = (guess + number / guess) / 2.0;
		}
		return guess; // returns double
	}
}
