package basic.closedlab;

import java.util.ArrayList;
import java.util.Scanner;

public class FrequencyElement {
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

			System.out.println("Enter the element you want to find: "); // prompting user

			int find = sc.nextInt();

			int result = linearFrequencyCount(arr, find); // find method is being invoked

			if (result > 0)
				System.out.println("The element " + find + " ocurred " + result + " times in the array " + list);
			else
				System.out.println("The element is not present in the given array " + list);
		} catch (Exception e) {
			System.out.println("Error!");
		}
	}

	public static int linearFrequencyCount(int[] arr, int ele) {
		int count = 0;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == ele)
				count++;
		return count;
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
