package basic.closedlab;

import java.util.Scanner;

public class ReverseRow2DArray {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
			for(int[] rowArr:arr)
				reverse(rowArr);

			System.out.print("The array after reverse,\n");
			for (int[] i : arr) {
				for (int ele : i)
					System.out.print(ele + " ");
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println("Error! ");
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
}