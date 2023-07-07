package assignments2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author Syed Anwar
 * @category recursion
 *
 */
public class FibonaciSeries {

	public static void main(String[] args) {
		/*
		 * Try with resource block is being used, so we don't need to explicitly close
		 * the scanner object.
		 */

		try (Scanner sc = new Scanner(System.in)) {// scanner object is initialized with source from console

			System.out.println("Enter the N'th number you want to find from fibonacci Series :");// prompting user to
																									// enter input

			int n = sc.nextInt();// using nextInt() which accepts only int data as input

			int result = fibonacci(n); // fibonacci method is being invoked

			System.out.println("The result is " + result);// printing the result

		} catch (Exception e) {// catching thrown exceptions to handle

			if (e instanceof InputMismatchException) // handling the InputMismatchException with a user friendly message
				System.out.println("Please enter positive integer number!");

			else if (e instanceof IllegalArgumentException) // handling the IllegalArgumentException with a user friendly
															// message
				System.out.println("Fibonacci of negative numbers does not exist!");

			else
				e.printStackTrace(); // Other unhandled Exceptions trace will be printed if there's any
		}
	}

	/**
	 * @throws IllegalArgumentException
	 * @param n as int
	 * @return int
	 */
	/*
	 * This function recursively computes N'th fibonacci number and returns the
	 * result.
	 */
	public static int calculateFibonacci(int n) {
		/*
		 * This additional check handles the case if negative numbers have been passed
		 * as n and prevents the recursion from infinite loop.
		 */
		if (n < 0)
			throw new IllegalArgumentException();

		/*
		 * The base condition and solves the sub problem.
		 */
		if (n == 0)
			return 0;

		/*
		 * The base condition and solves the sub problem.
		 */
		if (n == 1 || n == 2)
			return 1;

		/*
		 * First recursive call Recursively finds the (N-1)'th fibonacci number and
		 * second recursive call Recursively finds the (N-2)'th fibonacci number and
		 * returns the sum of N-1 and N-2
		 */
		return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
	}

	/**
	 * @throws IllegalArgumentException
	 * @param n as int
	 * @return int
	 */
	/*
	 * Helper function or Driver function for recursive function of fibonacci.
	 */
	public static int fibonacci(int n) {

		if (n < 0)
			throw new IllegalArgumentException();

		return fibonacci(n, 0, 1);
	}

	/**
	 * @hidden
	 * @param n      as int
	 * @param first  as int
	 * @param second as int
	 * @return int
	 */
	/*
	 * optimized fibonacci recursive function to tail recursion to achieve O(1)
	 * space complexity.
	 */
	private static int fibonacci(int n, int first, int second) {// stores the current N-1 and N-2 states as arguments
																// instead of storing the states in recursive stack

		// The base case that solves 0'th Fibonacci number and returns
		if (n == 0)
			return first;

		// The base case that solves N'th Fibonacci number and returns
		if (n == 1)
			return second;

		/*
		 * Recursively calls by updating N-1 and N-2 each time When making recursive
		 * call.
		 */
		return fibonacci(n - 1, second, first + second);
	}

}
