package basic.closedlab;

public class TwoDArrayTraversal1 {
	public static void main(String[] args) {
		int[][] twoDArr = { { 80, 90, 91, 77, 98 }, { 100, 100, 100, 100, 100 }, { 35, 54, 45, 67, 76 },
				{ 54, 36, 41, 88, 99 }, { 70, 89, 92, 100, 36 } };
		traverse2DArray(twoDArr);
	}
	public static void traverse2DArray(int[][] arr) {
		//traversing 2-D array and printing the elements 
		for(int[] rowArr:arr) {
			for(int element:rowArr)
				System.out.print(element+" ");
			System.out.println();
		}
	}
}