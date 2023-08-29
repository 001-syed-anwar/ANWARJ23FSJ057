package basic.closedlab;

import java.util.Scanner;

public class PrintNumberInWord {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the number you want to display in words");
			int num = sc.nextInt();
			System.out.println("The number is " + numberInWord(num));
		} catch (Exception e) {
			System.out.println("Error!");
		}
	}

	// generate numbers in words without storing numbers in temporary array/string.
	public static String numberInWord(int n) {

		if (n == 0)
			return "zero";

		StringBuilder bf = new StringBuilder();
		// for negative numbers
		if (n < 0) {
			bf.append("minus ");
			n = n * -1;
		}

		// count the digits
		int digit = 0;
		int number = n;
		while (number > 0) {
			digit++;
			number = number / 10;
		}

		// after counting, reset the n.
		number = n;

		// for crores
		if (digit > 7) {
			// number of crores
			int temp = number / 10000000;

			// crores in words
			if (temp != 0) {
				if (temp >= 100) {
					bf.append(getTill19(temp / 100));
					bf.append(" hundred ");
					temp = temp % 100;
				}

				if (temp <= 19)
					bf.append(getTill19(temp));
				else {
					bf.append(getTyNumbers(temp / 10));
					bf.append(" ");
					bf.append(getTill19(temp % 10));
				}
				bf.append(" crore and ");
			}
		}

		// for lakhs
		if (digit > 5) {
			// extract the lakhs.
			int temp = number % 10000000;

			// number of lakhs
			temp = temp / 100000;

			// lakhs in words
			if (temp != 0) {
				if (temp <= 19)
					bf.append(getTill19(temp));
				else {
					bf.append(getTyNumbers(temp / 10));
					bf.append(" ");
					bf.append(getTill19(temp % 10));
				}
				bf.append(" lakh and ");
			}
		}

		// for thousands
		if (digit > 3) {
			// extract the thousands.
			int temp = number % 100000;

			// number of thousands
			temp = temp / 1000;

			// thousands in words
			if (temp != 0) {
				if (temp <= 19)
					bf.append(getTill19(temp));
				else {
					bf.append(getTyNumbers(temp / 10));
					bf.append(" ");
					bf.append(getTill19(temp % 10));
				}
				bf.append(" thousand and ");
			}
		}

		// for hundreds
		if (digit > 2) {
			// extract the hundreds.
			int temp = number % 1000;

			// number of hundreds
			temp = temp / 100;

			// hundreds in words
			if (temp != 0) {
				bf.append(getTill19(temp));
				bf.append(" hundred and ");
			}
		}

		// for tens and ones
		if (digit > 1) {
			// extract the tens and ones.
			int temp = number % 100;

			// numbers greater than 19
			if (temp != 0 && temp > 19) {
				bf.append(getTyNumbers(temp / 10));
				bf.append(" ");
				temp = temp % 10;
			}

			// numbers till 19
			if (temp != 0) {
				bf.append(getTill19(temp));
			}
		}

		// added for deleting the 'and' in the end
		if (bf.charAt(bf.length() - 2) == 'd')
			bf.delete(bf.length() - 4, bf.length());

		return bf.toString();

	}

	// instead of switch, String array can also be used for storing words
	public static String getTill19(int n) {
		switch (n) {
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		case 10:
			return "ten";
		case 11:
			return "eleven";
		case 12:
			return "twelve";
		case 13:
			return "thirteen";
		case 14:
			return "fourteen";
		case 15:
			return "fifteen";
		case 16:
			return "sixteen";
		case 17:
			return "seventeen";
		case 18:
			return "eighteen";
		case 19:
			return "nineteen";
		default:
			return "";
		}

	}

	// instead of switch, String array can also be used for storing words
	public static String getTyNumbers(int n) {
		switch (n) {
		case 2:
			return "twenty";
		case 3:
			return "thirty";
		case 4:
			return "forty";
		case 5:
			return "fifty";
		case 6:
			return "sixty";
		case 7:
			return "seventy";
		case 8:
			return "eighty";
		case 9:
			return "ninety";
		default:
			return "";
		}
	}
}