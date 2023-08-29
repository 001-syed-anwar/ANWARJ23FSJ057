package basic.closedlab;

public class StudentResult {

	public static void main(String[] args) {
		// Hard coding 5 students and 5 subjects.
		int[][] marks = { { 80, 90, 91, 77, 98 }, { 100, 100, 100, 100, 100 }, { 35, 54, 45, 67, 76 },
				{ 54, 36, 41, 88, 99 }, { 70, 89, 92, 100, 36 } };

		int result[] = getTotal(marks);
		for (int i = 0; i < result.length; i++)
			System.out.println("Result of student " + (i + 1) + " is " + result[i]);

	}

	public static int[] getTotal(int[][] marks) {
		// this result array contains the total of marks for each students
		int[] result = new int[marks.length];

		// calculating sum of all marks and storing the result in result array
		for (int i = 0; i < marks.length; i++) {
			int total = 0;
			for (int j = 0; j < marks[i].length; j++)
				total += marks[i][j];
			result[i] = total;
		}

		return result;
	}
}