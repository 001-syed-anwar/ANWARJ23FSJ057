package assignments2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * <b>Assignment from Recursion topic</b>
 * <p>
 * This class contains a method that implements logic for Permutation along with
 * the main method which is already programmed for taking user inputs and
 * display the result.
 * 
 * @author Syed Anwar
 * @category recursion
 *
 */
public class Permutation {
	/**
	 * The main method that is preprogrammed to accept relevant inputs and print the
	 * output into the console to demonstrate the Permutation functionality.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Try with resource block is being used, so we don't need to explicitly close
		 * the scanner object.
		 */
		try (Scanner sc = new Scanner(System.in)) {// scanner object is initialized with source from console

			System.out.println("Enter the word you want to see permutation :");// prompting user to enter input

			String word = sc.next().trim();// using next() which accepts String data as input

			// generatePermutation method is being invoked
			ArrayList<ArrayList<Character>> result = generatePermutation(word.toCharArray());

			for (ArrayList<Character> permutation : result)
				System.out.println("One Possible permutation is " + permutation);// printing the result

		} catch (Exception e) {// catching thrown exceptions to handle

			if (e instanceof InputMismatchException) // handling the InputMismatchException with a user friendly message
				System.out.println("Please enter element Positive Integers in range 0 to " + Integer.MAX_VALUE);

			else
				e.printStackTrace(); // Other unhandled Exceptions trace will be printed if there's any
		}

	}

	/**
	 * This method computes the permutations of a given String
	 * 
	 * @param arr as char[]
	 * @return ArrayList<ArrayList<Character>>
	 */
	public static ArrayList<ArrayList<Character>> generatePermutation(char[] arr) {
		/*
		 * we need a frequency array or map for identifying the repeated elements, just
		 * to avoid same permutation getting counted twice or more. Other way of
		 * resolving the problem would be using Set or similar data structures that
		 * removes duplicates, instead of ArrayList.
		 */
		Map<Character, Integer> frequency = generateFrequency(arr);
		ArrayList<ArrayList<Character>> permutations = new ArrayList<>();
		backtrackPermutation(permutations, frequency, new ArrayList<Character>(), 0, arr.length);
		return permutations;
	}

	/**
	 * @hidden
	 * @param ans
	 * @param frequency
	 * @param permutation
	 * @param index
	 * @param n
	 */
	private static void backtrackPermutation(ArrayList<ArrayList<Character>> ans, Map<Character, Integer> frequency,
			ArrayList<Character> permutation, int index, int n) {
		/*
		 * We're using Backtracking approach as we need to explores all the combinations
		 * to find all the possible permutations for a given string.
		 */

		/*
		 * The base case of recursion which collects completed permutation combination
		 * and puts in answer array.
		 */
		if (index == n) {
			ans.add(new ArrayList<Character>(permutation));
			return;
		}
		/*
		 * Loop through the frequency map and try all combination.
		 */
		for (char num : frequency.keySet()) {
			/*
			 * If the number has already been used before then directly go and see other
			 * option.
			 */
			if (frequency.get(num) > 0) {
				// Decrease the frequency count as we're going to use them.
				frequency.put(num, frequency.get(num) - 1);

				// use the number and add into the list.
				permutation.add(num);

				// Recursively keep add adding elements until we found a completed permutation.
				backtrackPermutation(ans, frequency, permutation, index + 1, n);

				// While backtracking, undo the parts before recursion.
				permutation.remove(permutation.size() - 1);
				frequency.put(num, frequency.get(num) + 1);
			}

		}

	}

	/**
	 * @hidden
	 * @param arr
	 * @return
	 */
	private static Map<Character, Integer> generateFrequency(char[] arr) {
		/*
		 * Loop through the array and generate frequency map.
		 */
		Map<Character, Integer> frequency = new HashMap<>();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			frequency.put(arr[i], frequency.getOrDefault(arr[i], 0) + 1);
		}
		return frequency;
	}
}
