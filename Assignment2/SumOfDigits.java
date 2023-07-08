package assignments2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <b>Assignment from Recursion topic</b>
 * <p>
 * This class contains a method that implements logic for computing the sum of
 * digits in a number using recursion along with the main method which is
 * already programmed for taking user inputs and display the result.
 * 
 * @author Syed Anwar
 * @category recursion
 *
 */
public class SumOfDigits {
	/**
	 * The main method that is preprogrammed to accept relevant inputs and print the
	 * output into the console to demonstrate the Sum of Digits functionality.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Try with resource block is being used, so we don't need to explicitly close
		 * the scanner object.
		 */
		try (Scanner sc = new Scanner(System.in)) {// scanner object is initialized with source from console

			System.out.println("Enter the number you want to perform sum of digits :");// prompting user to enter input

			int int1 = sc.nextInt();// using nextInt() which accepts only int data as input

			int result = sumOfDigits(int1); // sumOfDigits method is being invoked

			System.out.println("The result is " + result);// printing the result

		} catch (Exception e) {// catching thrown exceptions to handle

			if (e instanceof InputMismatchException) // handling the InputMismatchException with a user friendly message
				System.out.println("Please enter element Positive Integers in range 0 to " + Integer.MAX_VALUE);

			else
				e.printStackTrace(); // Other unhandled Exceptions trace will be printed if there's any
		}
	}

	/**
	 * <p>
	 * This function returns the sum of digits in a number <i>for example: 123 -> 6.
	 * 
	 * @param num as int
	 * @return int
	 */
	public static int sumOfDigits(int num) {
		//calls the recursive method
		return sumOfDigits(num, 0);
	}

	/**
	 * @hidden
	 * @param num
	 * @param sum
	 * @return
	 */
	private static int sumOfDigits(int num, int sum) {
		/*
		 * The base case of the recursion
		 */
		if (num == 0)
			return sum;
		// Adds the digits from ones,tens,.. recursively and stores into the sum. 
		return sumOfDigits(num / 10, sum + num % 10);
	}
}
