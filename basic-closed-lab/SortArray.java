package basic.closedlab;

import java.util.ArrayList;
import java.util.Scanner;

public class SortArray {
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

			System.out.println("Choose the sorting order"
					+ "\nEnter 0 for sorting in descending order, any other key for ascending order");

			String option = sc.next();
			boolean sortingOrder = true;
			if (option.equals("0"))
				sortingOrder = false;
			quickSort(arr, sortingOrder);
			System.out.print("The elements after sorting ");
			for (int i : arr)
				System.out.print(i + " ");

		} catch (Exception e) {
			System.out.println("Error! ");
		}

	}

	/*
	 * quick sort algorithm is being used. The time complexity is o(n^2) in the
	 * worst case and o(n log n) in the best case. The space complexity is o(nlogn).
	 */
	public static void quickSort(int[] arr, boolean order) {
		quickSort(arr, 0, arr.length - 1, order);
	}

	private static void quickSort(int[] arr, int i, int j, boolean order) {
		// base case of the recursion.
		if (i < j) {

			/*
			 * Does the partition by choosing the last index as the pivot, at the end of
			 * this function, pivot element will be placed in it's correct position.
			 */
			int pivotIndex = partition(arr, i, j, order);

			// recursively sort the left sub array excluding the pivot index.
			quickSort(arr, i, pivotIndex - 1, order);

			// recursively sort the right sub array excluding the pivot index.
			quickSort(arr, pivotIndex + 1, j, order);
		}
	}

	private static int partition(int[] arr, int i, int j, boolean order) {
		// choosing last index as pivot element for every i to j sub arrays.
		int pivot = j;

		// setting the left pointer to starts from one index before the beginning of sub
		// array
		int leftPointer = i - 1;

		/*
		 * This for loop is basically to swap all the larger elements to the right side
		 * of the pivot index in case of ascending order and to swap all the smaller
		 * elements to right side in case of descending order.
		 */
		// right pointer starts from the beginning of the sub array
		for (int rightPointer = i; rightPointer < j; rightPointer++) {

			/*
			 * when sorting in ascending order, right when encountering a smaller element
			 * than pivot or equal element of pivot element, swap the places. when sorting
			 * in descending order, right when encountering a greater element than pivot or
			 * equal element of pivot element, swap the places.
			 */
			if ((order && arr[rightPointer] <= arr[pivot]) || (!order && arr[rightPointer] >= arr[pivot])) {
				// move the left pointer
				leftPointer++;
				// swap elements at positions leftPointer and rightPointer
				int temp = arr[leftPointer];
				arr[leftPointer] = arr[rightPointer];
				arr[rightPointer] = temp;

			}
		}

		// swap the pivot with it's corrected position
		int temp = arr[leftPointer + 1];
		arr[leftPointer + 1] = arr[j];
		arr[j] = temp;

		// return the position of the pivot after partition
		return leftPointer + 1;
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
