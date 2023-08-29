package assignments2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <b>Assignment from Recursion topic</b>
 * <p>
 * This class contains a method that implements logic for Tower of Hanoi problem
 * along with the main method which is already programmed for taking user inputs
 * and display the result.
 * 
 * @author Syed Anwar
 * @category Recursion
 *
 */
public class TowerOfHanoi {
	/**
	 * The main method that is preprogrammed to accept relevant inputs and print the
	 * output into the console to demonstrate the Tower of Hanoi problem's solution.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Try with resource block is being used, so we don't need to explicitly close
		 * the scanner object.
		 */
		try (Scanner sc = new Scanner(System.in)) { // scanner object is initialized with source from console

			System.out.println("Enter the Disk number : "); // prompting user to enter input

			int disks = sc.nextInt(); // using nextInt() which accepts only int data type from the source

			System.out.println("Enter the Source rod name : ");
			String src = sc.next(); // using next() to accept Strings

			System.out.println("Enter the Auxiliary rod name : ");
			String aux = sc.next();

			System.out.println("Enter the Destination rod name : ");
			String des = sc.next();

			solve(disks, src, aux, des); // solve method is being invoked and prints the result

		} catch (Exception e) { // catching thrown exceptions to handle

			if (e instanceof InputMismatchException) // handling the InputMismatchException with a user friendly message
				System.out.println("Please enter disk number in numbers");
			else if (e instanceof IllegalArgumentException) // handling the IllegalArgumentException with a user
															// friendly message
				System.out.println("Disk number can't be negative");
			else
				e.printStackTrace();// Other unhandled Exceptions trace will be printed if there's any
		}

	}

	/**
	 * <p>This solve recursive method help us solve the <i>Tower Of Hanoi</i> Puzzle We're
	 * taking number of disks as int and the three rods as char. when passing the
	 * three rods, we first pass the source rod or the starting position of disks
	 * where all the disks are initially present.Then, we pass the auxiliary or the
	 * helper rod and we finally pass the destination rod as the last argument.
	 * 
	 * @param disks as int
	 * @param rod1  as String
	 * @param rod2  as String
	 * @param rod3  as String
	 * @throws IllegalArgumentException
	 */
	public static void solve(int disks, String rod1, String rod2, String rod3) {
		/*
		 * This additional check handles the case if negative numbers have been passed
		 * as disks and prevents the recursion from infinite loop.
		 */
		if (disks < 0)
			throw new IllegalArgumentException();

		/*
		 * The base case ensures that the function won't go in infinite loop and solves
		 * the sub problem. For example, if number of disks is just one then we can
		 * directly place the disk from source to the destination rod.
		 */
		if (disks == 1) {
			System.out.println("move disk " + disks + " from " + rod1 + " to " + rod3);
			return;
		}

		/*
		 * Here,we're making recursive calls by decrementing the disks count and we're
		 * switching the last two rods order. The reason behind this is, for N number of
		 * disks, we first find the way to place all the other N-1 rods to the auxiliary
		 * rod only then we can move the bottom most rod from source to destination.
		 * When N is 1 then we can directly place the disk from source to destination
		 * but when N is more than 1 that's when the help of this recursive call come
		 * into the picture. let's assume N is 2, now in order to move the N disk from
		 * source to destination, we first need to place the other N-1 rods that are
		 * above the bottom N'th rod to some other place, In this problem we only have
		 * one extra rod, so we place the disk to the other rod by simply changing the
		 * destination to other rod. After the function call, N would be 1 and we print
		 * the statement then return and we make the destination rod as our new
		 * auxiliary rod just in case if N-1 disks are more than 1 disk just so we use
		 * the place whenever necessary.
		 */
		solve(disks - 1, rod1, rod3, rod2);

		/*
		 * After the above recursive call, after placing the first disk we can now
		 * proceed to place the current bottom disk to destination rod that was just
		 * below the top disk in the stack which we already placed and printed the
		 * statement into the console.
		 */
		System.out.println("move disk " + disks + " from " + rod1 + " to " + rod3);

		/*
		 * 
		 * This recursive call helps us to replace the disks that were temporarily
		 * placed somewhere to the actual destination rod.
		 */
		solve(disks - 1, rod2, rod1, rod3);

		/*
		 * Finally, the combination of both recursive calls helps us to solve the tower
		 * of hanoi problem.
		 */

	}

}