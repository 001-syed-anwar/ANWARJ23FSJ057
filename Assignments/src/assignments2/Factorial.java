package assignments2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <b>Assignment from Recursion topic</b>
 * <p>
 * This class contains a method that implements logic for computing factorial of
 * a number along with the main method which is already programmed for taking
 * user inputs and display the result.
 * 
 * @author Syed Anwar
 * @category recursion
 *
 */
public class Factorial {
	/**
	 * The main method that is preprogrammed to accept relevant inputs and print the
	 * output into the console to demonstrate the Factorial functionality.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Try with resource block is being used, so we don't need to explicitly close
		 * the scanner object.
		 */

		try (Scanner sc = new Scanner(System.in)) {// scanner object is initialized with source from console

			System.out.println("Enter the number you want to find Factorial:");// prompting user to enter input

			int n = sc.nextInt();// using nextInt() which accepts only int data as input

			int result = factorial(n); // factorial method is being invoked

			System.out.println("The result is " + result);// printing the result

		} catch (Exception e) {// catching thrown exceptions to handle

			if (e instanceof InputMismatchException) // handling the InputMismatchException with a user friendly message
				System.out.println("Please enter positive integer number!");

			else if (e instanceof IllegalArgumentException) // handling the IllegalArgumentException with a user friendly
															// message
				System.out.println("Factorial of negative numbers is not supported!");

			else
				e.printStackTrace(); // Other unhandled Exceptions trace will be printed if there's any
		}
	}

	/**
	 * This method does the computation of factorial.
	 * 
	 * @throws IllegalArgumentException
	 * @param n as int
	 * @return int
	 */
	/*
	 * this function recursively solves the factorial of a number problem.
	 */
	public static int calculateFactorial(int n) {
		/*
		 * This additional check handles the case if negative numbers have been passed
		 * as n and prevents the recursion from infinite loop.
		 */
		if (n < 0)
			throw new IllegalArgumentException();

		/*
		 * This is the base case of the recursion and solves the subproblems
		 * recursively. The idea of this base case comes from the fact that for 0 and 1
		 * the factorial is 1.
		 */
		if (n == 0 || n == 1)
			return 1;

		/*
		 * recursively multiplies with n and makes recursive calls for n-1 until we meet
		 * base case.
		 */
		return n * calculateFactorial(n - 1);
	}

	/**
	 * This method does the computation of factorial with o(1) space complexity.
	 *
	 * @throws IllegalArgumentException
	 * @param n as int
	 * @return int
	 */
	// Helper function or Driver function for recursive function of factorial.
	public static int factorial(int n) {
		if (n < 0)
			throw new IllegalArgumentException();

		return factorial(n, 1);
	}

	/**
	 * @hidden
	 * @param n         as int
	 * @param factorial as int
	 * @return int
	 */
	/*
	 * optimized factorial recursive function to tail recursion to achieve O(1)
	 * space complexity.
	 */
	private static int factorial(int n, int factorial) {// stores the current factorial state as argument instead of
														// storing the state in recursive stack
		/*
		 * The base case of the function and returns the factorial when done with
		 * computing.
		 */
		if (n <= 1)
			return factorial;

		// recursively calls n times for n factorial
		return factorial(n - 1, n * factorial);
	}

}