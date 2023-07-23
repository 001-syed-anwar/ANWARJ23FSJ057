package basic.closedlab;

import java.util.Scanner;

public class CheckPrime {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the number you want to check prime or not");
			int num = sc.nextInt();
			String result=(isPrime(num))?"a Prime":"Not a Prime";
			System.out.println("The number is "+result);
		} catch (Exception e) {
			System.out.println("Error!");
		}
	}

	public static boolean isPrime(int num) {
		if(num<=1)
			return false;
		//loop till the root of number, to find it's divisors
		for (int i = 2; i * i <= num; i++)
			if (num % i == 0)
				return false;
		
		return true;
	}
}
