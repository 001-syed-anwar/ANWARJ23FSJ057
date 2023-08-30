package assignments1;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <b>Assignment from Arithmetic Operations topic</b>
 * <p>
 * This class contains a method that implements logic for computing power
 * exponentiation of numbers along with the main method which is already
 * programmed for taking user inputs and display the result.
 * 
 * @author syed anwar
 * @category Arithmetic operations
 */
public class Power {
	/**
	 * The main method that is preprogrammed to accept relevant inputs and print the
	 * output into the console to demonstrate the power exponentiation
	 * functionality.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/* Try with resource block is being used, so we don't need to explicitly close
		   the scanner object */

		try (Scanner sc = new Scanner(System.in)) {// scanner object is initialized with source from console

			System.out.println("Enter the base number : ");// prompting user to enter input

			// Using next() to accept String just so we can get much larger input
			// At the same time, if user tries to enter inappropriate inputs then it will be
			// handled by catch block
			Integer int1 = Integer.parseInt(sc.next());

			System.out.println("Enter the exponent number : ");

			int int2 = sc.nextInt();

			// power method is making use of compile time polymorphism
			String result = power(new BigInteger(String.valueOf(int1)), int2).toString();// invoking power method

			System.out.println("The result is " + result); // printing the result

		} catch (Exception e) {// catching thrown exceptions to handle

			if (e instanceof InputMismatchException)// handling the InputMismatchException with a user friendly message
				System.out.println("Please enter only number!");

			else if (e instanceof IllegalArgumentException)// handling the IllegalArgumentException with a user friendly
															// message
				System.out.println("The base value should be integer!");

			else if (e instanceof InverseException) // handling the InverseException with a user friendly message
				System.out.println("Inverse operation of exponentiation is not supported!");

			else
				e.printStackTrace(); // Other unhandled Exceptions trace will be printed if there's any
		}
	}

	/**
	 * This method does the computation of power exponentiation of integers.
	 * 
	 * @param base     as int
	 * @param exponent as int
	 * @throws InverseException
	 * @return returns the power
	 */
	public static int power(int base, int exponent) { // takes two int as arguments

		// the simple idea is 2^4 is equal to 4^2 (2^2)^2 and 2^5 is equal to 2*4^2
		// 2*(2^2)^2
		// we can solve the problem recursively by utilizing the above idea.
		// this method recursively returns the result if the exponent is a even number,
		// then this recursive method acts as a tail recursion and computes the power in
		// o(1) space complexity.

		if (exponent < 0) // if exponent is negative then throws inverseException
			throw new InverseException();

		if (exponent == 0)
			return 1;

		if ((exponent & 1) == 1)
			return base * power(base * base, exponent / 2);

		else
			return power(base * base, exponent / 2);
	}

	/**
	 * This method does the computation of power exponentiation of integers. instead
	 * of int data, BigInteger is being used so computation of big numbers also
	 * possible.
	 * 
	 * @param base     as BigInteger
	 * @param exponent as int
	 * @throws InverseException
	 * @return return the power
	 */
	public static BigInteger power(BigInteger base, int exponent) {
		if (exponent < 0)
			throw new InverseException();
		if (exponent == 0)
			return new BigInteger("1");
		if ((exponent & 1) == 1)
			return power(base.multiply(base), exponent / 2).multiply(base);
		else
			return power(base.multiply(base), exponent / 2);
	}
}

/**
 * This class is a custom exception for throwing exception when user tries to
 * input exponent as negative integer
 * 
 * @author syed anwar
 *
 */
class InverseException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	InverseException() {
		super("Inverse of exponentiation is not allowed");
	}
}