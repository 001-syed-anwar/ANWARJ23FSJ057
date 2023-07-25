package basic.closedlab;

public class Exercise26 {
	public static void main(String[] args) {
		int i = -243;
		int j = 243;

		/*
		 * expression in the if statement, compares i and j and returns boolean value
		 * but there is a semicolon, right after the if statement. So regardless of i
		 * equals j or not, nothing will happen since there's no statements inside the
		 * scope of if statement.
		 */
		if (i == j);

		//we're printing a String here, that says "numbers are the same".
		System.out.println("numbers are the same");
	}
}
