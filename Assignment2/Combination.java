package assignments2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <b>Assignment from Recursion topic</b>
 * <p>
 * This class contains a method that implements logic for combination along with
 * the main method which is already programmed for taking user inputs and
 * display the result.
 * 
 * @author Syed Anwar
 * @category recursion
 *
 */
public class Combination {
	/**
	 * The main method that is preprogrammed to accept relevant inputs and print the
	 * output into the console to demonstrate the combination functionality.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Try with resource block is being used, so we don't need to explicitly close
		 * the scanner object.
		 */
		try (Scanner sc = new Scanner(System.in)) {// scanner object is initialized with source from console

			System.out.println("Enter the word you want to see combinations of k size :");// prompting user to enter
																							// input

			String word = sc.next();// using next() which accepts String data as input

			System.out.println("Enter the size K");

			int k = sc.nextInt();// using nextInt() which accepts int data as input

			// generateCombination method is being invoked
			ArrayList<ArrayList<Character>> result = generateCombination(word.toCharArray(), k);

			for (ArrayList<Character> permutation : result)
				System.out.println("One Possible combination is " + permutation);// printing the result

		} catch (Exception e) {// catching thrown exceptions to handle
			e.printStackTrace();
		}
	}

	/**
	 * This method computes the combination of a given String
	 * 
	 * @param arr as char[]
	 * @return ArrayList<ArrayList<Character>>
	 */
	public static ArrayList<ArrayList<Character>> generateCombination(char[] arr, int k) {
		ArrayList<ArrayList<Character>> combinations = new ArrayList<>();
		backtrackCombination(arr, 0, k, new ArrayList<Character>(), combinations);
		return combinations;
	}

	/**
	 * @hidden
	 * @param ans
	 * @param frequency
	 * @param permutation
	 * @param index
	 * @param n
	 */
	private static void backtrackCombination(char[] arr, int i, int j, ArrayList<Character> list,
			ArrayList<ArrayList<Character>> ans) {
		/*
		 * We're using Backtracking approach as we need to explores all the combinations
		 * for a given string.
		 */

		/*
		 * The base case of recursion which collects completed combination of size j and
		 * puts in answer array.
		 */
		if (j == list.size()) {
			ans.add(new ArrayList<Character>(list));
			return;
		}

		// this base condition is to prevent from going beyond the array elements
		if (i == arr.length)
			return;

		// add an element and make recursive call
		list.add(arr[i]);
		backtrackCombination(arr, i + 1, j, list, ans);

		/*
		 * backtrack by removing the element to try new combination and make recursive
		 * call
		 */
		list.remove(list.size() - 1);
		backtrackCombination(arr, i + 1, j, list, ans);
	}

}
