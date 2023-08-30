package basic.closedlab;

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseArray {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// prompting user to enter input
			System.out
					.println("Enter the array elements as Integers " + "and enter \"stop\" to stop entering elements:");

			ArrayList<Integer> list = initializeArray(sc); // takes input from user and stores in array
			if (list.size() == 0)
				throw new IllegalArgumentException();

			// cast ArrayList to int array using stream api
			int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

			System.out.print("The array after reverse, ");
			for (int i : reverse(arr))
				System.out.print(i + " ");
			
		} catch (Exception e) {
			System.out.println("Error! " + e);
		}
		
	}

	public static int[] reverse(int[] arr) {
		/*
		 * As long as there are more than 1 elements only then reverse otherwise simply
		 * return.
		 */
		if (arr.length > 1)
			// reverse the array
			reverse(arr, 0, arr.length - 1);
		return arr;
	}

	private static void reverse(int[] arr, int i, int j) {
		/*
		 * Recursively swap the i and j
		 */
		if (i < j) {

			/*
			 * Initially, arr[i] = arr[i] ^ arr[j] then, arr[j] = arr[j] ^ arr[i] ^ arr[j]
			 * because arr[i] is updated in the first statement to arr[i] ^ arr[j]. So, the
			 * same element that occurred twice will be removed and that's how we'r
			 * utilizing the The Xor operator property to perform swap operation.
			 */
			arr[i] ^= arr[j];
			arr[j] ^= arr[i];
			arr[i] ^= arr[j];

			reverse(arr, i + 1, j - 1);
		}
	}

	public static ArrayList<Integer> initializeArray(Scanner sc) {
		// Using ArrayList to overcome the issue of fixed array size.
		ArrayList<Integer> list = new ArrayList<>();
		String input = "";
		while (true) {// Getting array elements from user until user says "stop"
			input = sc.next();
			if (input.equalsIgnoreCase("stop"))
				break;
			Integer element = Integer.parseInt(input);
			list.add(element);
		}
		return list;
	}
}