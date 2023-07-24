package basic.closedlab;

public class TwoDArrayTraversal2 {
	public static void main(String[] args) {
		int[][] twoDArr = { { 80, 90, 91, 77, 98 }, { 100, 100, 100, 100, 100 }, { 35, 54, 45, 67, 76 },
				{ 54, 36, 41, 88, 99 }, { 70, 89, 92, 100, 36 } };
		traverse2DArray(twoDArr);
	}
	
	public static void traverse2DArray(int[][] arr) {
		//traversing 2-D array and printing the elements 
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<=i;j++) 
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}
}
