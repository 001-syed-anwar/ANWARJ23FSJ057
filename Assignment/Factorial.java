package assignments1;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author syed anwar
 * @category Arithmetic operations
 */
public class Factorial {

	public static void main(String[] args) {
		// Try with resource block is being used, so we don't need to explicitly close
		// the scanner object

		try (Scanner sc = new Scanner(System.in)) {// scanner object is initialized with source from console

			System.out.println("Enter the number you want to find Factorial:");// prompting user to enter input

			byte int1 = sc.nextByte();// using nextByte() which accepts only byte data as input

			String result = factorial(int1).toString(); // factorial method is being invoked and return BigInteger
														// Object
														// with toString() method it is converted into string

			System.out.println("The result is " + result);// printing the result

		} catch (Exception e) {// catching thrown exceptions to handle

			if (e instanceof InputMismatchException) // handling the InputMismatchException with a user friendly message
				System.out.println("Please enter positive integer number less than 128!");

			else if (e instanceof IllegalArgumentException)// handling the IllegalArgumentException with a user friendly
															// message
				System.out.println("Factorial of negative numbers is not supported!");

			else
				e.printStackTrace(); // Other unhandled Exceptions trace will be printed if there's any
		}
	}

	/**
	 * 
	 * @param the number that we want to find the factorial
	 * @return returns the factorial
	 */
	public static BigInteger factorial(byte n) { // takes byte as an argument

		if (n < 0)
			throw new IllegalArgumentException(); // throwing exception if n is negative

		BigInteger ans = new BigInteger("1");

		for (int i = n; i > 0; i--) // iterating from n to 1 to and multiplying all the number that we encounter
			ans = ans.multiply(new BigInteger(String.valueOf(i)));

		return ans; // returns BigInteger
	}

}
