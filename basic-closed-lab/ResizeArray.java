package basic.closedlab;

import java.util.ArrayList;
import java.util.Scanner;

public class ResizeArray {
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

			System.out.println("Please enter the size in number that you want to resize the array");
			int size = sc.nextInt();

			int[] resized = resizeArray(arr, size);
			if (arr.length > resized.length)
				System.out.print("Array size has been shrinked, thus some of the elements might have lost ");
			System.out.print("\nThe new resized array elements are ");
			for (int i : resized)
				System.out.print(i + " ");
		} catch (Exception e) {
			System.out.println("Error! " + e);
		}
	}

	public static int[] resizeArray(int[] arr, int size) {
		// temp array of new size
		int[] temp = new int[size];

		// cop the array elements into temp array
		for (int i = 0; i < size; i++) {
			if (i >= arr.length)
				break;
			temp[i] = arr[i];
		}

		// returning the resized array
		return temp;
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
