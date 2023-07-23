package basic.closedlab;

import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfNElements {
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

			System.out.println("The average of all elements is "+getAvg(arr));

		} catch (Exception e) {
			System.out.println("Error! ");
		}
	}
	
	// var args is used, we can now pass array or multiple int arguments.
	public static double getAvg(int... a) {
		//store the total numbers count
		int n=a.length;
		
		//add all the elements
		double sum=0;
		for(int i:a)
			sum+=i;
		
		//calculate the average
		double avg=sum/n;
		return avg;
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
