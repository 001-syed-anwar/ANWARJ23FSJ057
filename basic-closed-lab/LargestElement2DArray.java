package basic.closedlab;

import java.util.Scanner;

public class LargestElement2DArray {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

			System.out.print("The array after reverse,\n");
			for (int i = 0; i < arr.length; i++)
				System.out.println("The largest element in row " + (i + 1) + " is " + getLargest(arr[i]));

		} catch (Exception e) {
			System.out.println("Error! ");
		}

	}

	public static int getLargest(int[] arr) {
		// iteratively checking for largest element
		int largest = arr[0];
		for (int i : arr)
			if (i > largest)
				largest = i;
		return largest;
	}

}
