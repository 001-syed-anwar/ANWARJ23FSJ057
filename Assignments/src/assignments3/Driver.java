package assignments3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class requires DynamicArray class to be imported in order function
 * properly and this class has the main method that demonstrate the use of
 * DynamicArray class by interacting with user via console or terminal.
 * 
 * @author Syed Anwar
 * @category Array Operations
 */
public class Driver {
	/**
	 * The main method that is already preprogrammed to demonstrate the use case of
	 * DynamicArray class.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {// scanner object is initialized with source from console
			DynamicArray arr = new DynamicArray();
			do {// used do-while loop to perform any operation for any number of times.
				boolean exit = false;
				System.out.println(
						"\n\n-------------------------------------------------------------------------------------\n"
								+ "|                               THE   MENU   PAGE                                  |\n"
								+ "|----------------------------------------------------------------------------------|\n"
								+ "|    Enter 1 to initialsize array                                                  |\n"
								+ "|    Enter 2 to reverse array                                                      |\n"
								+ "|    Enter 3 to sort array                                                         |\n"
								+ "|    Enter 4 to calculate sum of all elements                                      |\n"
								+ "|    Enter 5 to calculate average among of all elements                            |\n"
								+ "|    Enter 6 to find minimum element of array                                      |\n"
								+ "|    Enter 7 to find maximum element of array                                      |\n"
								+ "|    Enter 8 to find any element existance in array                                |\n"
								+ "|    Enter 9 to find any element existance in array starting from specific index   |\n"
								+ "|    Enter 10 to find frequency of any element from array                          |\n"
								+ "|    Enter 11 to delete an element at specific index in array                      |\n"
								+ "|    Enter 12 to set an element at specific index in array                         |\n"
								+ "|    Enter 13 to get an element at specific index in array                         |\n"
								+ "|    Enter any other key to quit the program                                       |\n"
								+ "------------------------------------------------------------------------------------");

				String option = sc.next();
				switch (option) {// Used switch case to perform operations uniquely for different options.
				case "1": {
					arr = new DynamicArray();
					System.out.println(
							"Enter the array elements as Integers and enter \"stop\" to stop entering elements:");
					initializeArray(sc, arr);
					System.out.println("Array elements are " + arr);
					break;
				}
				case "2": {
					arr.reverse();
					System.out.println("Array after reversing the order " + arr);
					break;
				}
				case "3": {
					arr.sort();
					System.out.println("Array after sorting " + arr);
					break;
				}
				case "4": {
					System.out.println("The sum of all elements is : " + arr.getSum() + " in array " + arr);
					break;
				}
				case "5": {
					System.out.println("The average of all elements is : " + arr.getAverage() + " in array " + arr);
					break;
				}
				case "6": {
					System.out.println("The minimum of all elements is : " + arr.getMinimum() + " in array " + arr);
					break;
				}
				case "7": {
					System.out.println("The maximum of all elements is : " + arr.getMaximum() + " in array " + arr);
					break;
				}
				case "8": {
					System.out.println("Enter any element to find and display it's index position");
					int toFind = sc.nextInt();
					int found = arr.find(toFind);

					if (found >= 0)
						System.out.println("The element " + toFind + " is at index " + found + " in the array! " + arr);
					else
						System.out.println("The element " + toFind + " is not present in the array! " + arr);
					break;
				}
				case "9": {
					System.out.println("Enter the element you want to find starting from specific index : ");

					int findFrom = sc.nextInt();

					System.out.println("Enter the index you want to find starting froms : ");

					int from = sc.nextInt();

					int result = arr.find(findFrom, from);

					if (result >= 0)
						System.out.println(
								"The element " + findFrom + " is at index " + result + " in the array! " + arr);
					else
						System.out.println("The element " + findFrom + " is not present in the array! " + arr);
					break;
				}
				case "10": {
					System.out.println("Enter any element to find and display it's frequency in the array");
					int frequencyOf = sc.nextInt();
					System.out.println("The frequency of " + frequencyOf + " in the array is "
							+ arr.getFrequency(frequencyOf) + " in array " + arr);
					break;
				}
				case "11": {
					System.out.println("Enter the index to remove from array");
					int delete = sc.nextInt();
					arr.remove(delete);
					System.out.println("Deleted the element " + delete + " from array " + arr.displayArray());
					break;
				}
				case "12": {
					System.out.println("Please enter any element to set in array ");
					int set = sc.nextInt();
					System.out.println("Please enter index position");
					int idx = sc.nextInt();
					arr.set(set, idx);
					System.out.println("The element successfully updated in the array " + arr);
					break;
				}
				case "13": {
					System.out.println("Please enter an index from array to display the element");
					int get = sc.nextInt();
					System.out.println("The element at index " + get + " is " + arr.get(get) + " in arry " + arr);
					break;
				}
				default: {
					exit = true;
				}
				}
				if (exit)
					break;
				System.out
						.println("\n\nEnter 0 to return to menu \n" + "Please Enter any other key to quit the program");
			} while (sc.next().equalsIgnoreCase("0"));

		} catch (Exception e) {// catching thrown exceptions to handle

			if (e instanceof InputMismatchException) // handling the InputMismatchException with a user friendly message
				System.out.println("Please enter integers!");

			else if (e instanceof IndexOutOfBoundsException) {// handling the IndexOutOfBoundsException with a user
																// friendly message
				System.out.println("Please enter valid index position!");
			} else
				e.printStackTrace(); // Other unhandled Exceptions trace will be printed if there's any
		} catch (IllegalAccessError e) {
			System.out.println("Array is null!");
		}

	}

	/**
	 * This method takes input from users and initializes array.
	 * 
	 * @param sc as Scanner
	 */
	public static void initializeArray(Scanner sc, DynamicArray arr) {
		String input = "";
		while (true) {// Getting array elements from user until user says "stop"
			input = sc.next();
			if (input.equalsIgnoreCase("stop"))
				break;
			Integer element = Integer.parseInt(input);
			arr.add(element);
		}
	}
}