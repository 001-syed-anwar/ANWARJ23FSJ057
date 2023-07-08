package assignments2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <b>Assignment from Recursion topic</b>
 * <p>
 * This class contains a method that implements logic for binary search along
 * with the main method which is already programmed for taking user inputs and
 * display the result.
 * 
 * @author Syed Anwar
 * @category recursion
 *
 */
public class BinarySearch {
	/**
	 * The main method that is preprogrammed to accept relevant inputs and print the
	 * output into the console to demonstrate the Binary search functionality.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Try with resource block is being used, so we don't need to explicitly close
		 * the scanner object.
		 */

		try (Scanner sc = new Scanner(System.in)) {// scanner object is initialized with source from console

			// prompting user to enter input
			System.out.println("Enter the array elements as Integers " 
								+ "and enter \"stop\" to stop entering elements:");

			ArrayList<Integer> list = initializeArray(sc); // takes input from user and stores in array
			if (list.size() == 0)
				throw new IllegalArgumentException();
			
			//cast ArrayList to int array using stream api 
			int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

			System.out.println("Enter the element you want to find: "); //prompting user

			int find = sc.nextInt();

			int result = find(arr, find); // find method is being invoked

			if (result != -1)
				System.out.println("The element is at index " + result + " in the array " + list);// printing the result
			else
				System.out.println("The element is not present in the given array " + list);

		} catch (Exception e) {// catching thrown exceptions to handle

			if (e instanceof InputMismatchException) // handling the InputMismatchException with a user friendly message
				System.out.println("Please enter integer number to find!");

			else if (e instanceof IllegalArgumentException) {// handling the IllegalArgumentException with a user
															 // friendly message
				System.out.println("Please enter element as Integers in range " + Integer.MIN_VALUE + " to "
									+ Integer.MAX_VALUE + " and  to stop enter \"stop\"");
			}

			else if (e instanceof SortOrderException) {
				String msg = e.toString();
				System.out.println(msg.substring(msg.indexOf("[")));
			} else
				e.printStackTrace(); // Other unhandled Exceptions trace will be printed if there's any
		}
	}

	/**
	 * This method takes input from users and initializes array.
	 * 
	 * @param sc as Scanner
	 * @return ArrayList<Integer>
	 * @throws SortOrderException
	 */
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
		//	Throwing exception instantly if user tries to enter array elements as unsorted
			if (list.size() > 1 && element < list.get(list.size() - 2)) {
				throw new SortOrderException(list + " Elements should be in sorted ascending order (" + element + " < "
						+ list.get(list.size() - 2) + ")");
			}
		}
		return list;
	}

	/**
	 * This method does the binary search operation
	 * 
	 * @param arr    as int[]
	 * @param toFind as int
	 * @return int
	 * @throws IndexOutOfBoundsException
	 */
	public static int find(int[] arr, int toFind) {
		//calls the binarySearch to find the element
		return binarySearch(arr, 0, arr.length - 1, toFind);
	}

	/**
	 * @hidden
	 * @param arr    as int[]
	 * @param i      as int
	 * @param j      as int
	 * @param toFind as int
	 * @return int
	 */
	private static int binarySearch(int[] arr, int i, int j, int toFind) {
		/*
		 * Binary search finds an element in the array in o(log n) time complexity. 
		 * The base case of recursive method and solves the case where the element to 
		 * be found does not exist.
		 */
		if (i == j) {
			return -1;
		}
		
		//Taking the mid value to divide and search independently.
		int mid = (i + j) / 2;
		
		/*
		 * if considering element is lesser than or equal to mid, it means the element is
		 * on the left side of the array. So this recursively search in left array as long
		 * as the element is lesser than or equal to mid value. 
		 */
		
		if (toFind <= arr[mid]) {
			if (arr[mid] == toFind) //if match found then return;
				return mid;
			return binarySearch(arr, i, mid, toFind);
		} else {
			/*
			 * If the above condition does not satisfy, then the element is on the right side.
			 * So, this recursively calls as long as element is on the right side of the
			 * array.
			 */
			if (arr[mid + 1] == toFind)//A small optimization to traditional binary search implementation.
				return mid + 1;
			return binarySearch(arr, mid + 1, j, toFind);
		}
	}

}

/**
 * This class is a custom exception for throwing exception when user tries to
 * input array in unsorted manner.
 * 
 * @author syed anwar
 */
class SortOrderException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SortOrderException(String s) {
		super(s);
	}

}