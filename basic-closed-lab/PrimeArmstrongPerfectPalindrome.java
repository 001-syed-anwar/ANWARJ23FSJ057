package basic.closedlab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeArmstrongPerfectPalindrome {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println(
					"Enter the range to get the prime numbers list, Starting number cannot be bigger than ending number\n"
							+ "enter the starting number");
			int s = sc.nextInt();
			int e = sc.nextInt();
			System.out.println("The prime numbers within the range is/are " + primeNumbers(s, e));

			System.out.println("Enter the number you want to check Palindrome, Armstrong or Perfect");
			int num = sc.nextInt();
			String palindrome = (isPalindrome(num)) ? "a Palindrome" : "Not a Palindrome";
			String armstrong = (isArmstrong(num)) ? "an Armstrong" : "Not an Armstrong";
			String perfect = (isPerfect(num)) ? "a Perfect" : "Not a Perfect";
			System.out.println("The number is " + palindrome + " , " + armstrong + " and " + perfect);
		} catch (Exception e) {
			System.out.println("Error!");
		}
	}

	public static List<Integer> primeNumbers(int start, int end) {
		// edge case
		if (start > end)
			throw new IllegalArgumentException();

		// the prime number list
		List<Integer> list = new ArrayList<Integer>();

		// there's no negative prime numbers.
		if (end < 0)
			return list;
		/*
		 * Creating a temporary array of size end+1, by default all elements are 'false'
		 * and we're assigning 'true' to the numbers which has more than 2 divisors.
		 * with this temporary array, we can generate prime numbers list. It is possible
		 * to generate prime numbers list without this temporary array as well. In that
		 * case, we need to first have our array list filled with numbers from start to
		 * end and remove the numbers which has more than 2 divisors.
		 */
		// initialize the temporary array of boolean
		boolean[] temp = new boolean[end + 1];

		// since 0 and 1 are not prime numbers assign 'true'.
		temp[0] = true;
		temp[1] = true;

		/*
		 * outer loop runs till root of end number, Since the divisors of a number can
		 * be found within from 1 to root of that number. We're starting from 2, because
		 * we don't count the 1 and the considering number itself for a number to be a
		 * prime number.
		 */
		for (int i = 2; i * i <= end; i++) {

			/*
			 * inner loop is going to assign 'true' for all multiples of i'th numbers.
			 */
			for (int j = i + i; j <= end; j += i) {
				temp[j] = true;
			}
		}

		// edge case
		start = (start < 0) ? 2 : start;

		// add the prime numbers into the list with the help temporary array
		for (int i = start; i <= end; i++) {
			if (!temp[i])
				list.add(i);
		}

		return list;
	}

	public static boolean isArmstrong(int num) {
		// negative numbers are not armstrong number
		if (num < 0)
			return false;

		// edge case for 0
		if (num == 0)
			return true;

		// counting the digits
		int temp = num;
		int digit = 0;
		while (temp > 0) {
			digit++;
			temp /= 10;
		}

		// counting the sum of digits raised to the power of number of digits
		int sum = 0;
		temp = num;
		while (temp > 0) {
			int i = temp % 10;
			sum += Math.pow(i, digit);
			if (sum > num)
				return false;
			temp /= 10;
		}

		// checking the sum and returning boolean values
		if (sum == num)
			return true;
		return false;
	}

	public static boolean isPerfect(int num) {
		// negative numbers are not perfect number
		if (num < 1)
			return false;

		// calculating sum of all unique divisors
		int sum = 0;
		for (int i = 1; i * i <= num; i++) {
			if (num % i == 0) {
				sum += i;
				sum += (num / i != i) ? num / i : 0;
			}
		}

		// checking the sum (neglecting the number itself) and returning boolean values
		if (sum - num == num)
			return true;
		return false;
	}

	public static boolean isPalindrome(int num) {
		// negative numbers are not palindrome number
		if (num < 0)
			return false;
		// reversing the number
		int revNum = 0;
		int temp = num;
		while (temp > 0) {
			revNum = (revNum * 10) + temp % 10;
			temp /= 10;
		}
		// checking the number with it's reversed one and returning boolean values
		if (revNum == num)
			return true;
		return false;
	}
}
