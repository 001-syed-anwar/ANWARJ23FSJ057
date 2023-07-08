package assignments2;

import java.util.Scanner;

/**
 * <b>Assignment from Recursion topic</b>
 * <p>
 * This class contains a method that implements logic for palindrome check along
 * with the main method which is already programmed for taking user inputs and
 * display the result.
 * 
 * @author Syed Anwar
 * @category recursion
 */
public class Palindrome {
	/**
	 * The main method that is preprogrammed to accept relevant inputs and print the
	 * output into the console to demonstrate the Palindrome check functionality.
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

			String word = sc.next();// using next() which accepts String data as input

			boolean result = isPalindrome(word); // sumOfDigits method is being invoked

			if (result)
				System.out.println("The word " + word + " is a palindrome");// printing the result
			else
				System.out.println("No, The word " + word + " is not a palindrome");

		} catch (Exception e) {// catching thrown exceptions to handle

			e.printStackTrace(); // Exceptions trace will be printed if there's any
		}
	}

	/**
	 * @hidden
	 * @param word
	 * @param i
	 * @param j
	 * @return boolean
	 */
	private static boolean isPalindrome(String word, int i, int j) {
		/*
		 * The base case of the recursion and prevents the recursion from infinite loop
		 */
		if (i >= j)
			return true;
		/*
		 * At some point, we found the symmetric index is not equal to each other then
		 * return false.
		 */
		if (word.charAt(i) != word.charAt(j))
			return false;
		//Recursively call and return the result.
		return isPalindrome(word, i + 1, j - 1);
	}

	/**
	 * This method Checks whether a word Palindrome or not.
	 * 
	 * @param word as String
	 * @return boolean
	 */
	public static boolean isPalindrome(String word) {
		return isPalindrome(word, 0, word.length() - 1);
	}

}
