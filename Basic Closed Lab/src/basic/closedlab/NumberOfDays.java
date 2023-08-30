package basic.closedlab;

import java.util.Scanner;

public class NumberOfDays {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// prompting user to enter input
			System.out.println("Enter the date in (mm-yyyy) format, for eg: (01-0001) ");

			String date = sc.next();

			System.out.println("The number of days in the month and year (" + date + ") is " + getNumOfDays(date));
		} catch (Exception e) {
			if (e instanceof IllegalArgumentException)
				System.out.println("Invalid date format!");
			else
				System.out.println("Error!");
		}
	}

	public static int getNumOfDays(String date) {
		// pattern matching for date format
		if (!date.matches("(0[1-9]|1[0-2])-(\\d{4})$"))
			throw new IllegalArgumentException();

		int days;
		String[] monthAndYear = date.split("-");
		switch (monthAndYear[0]) {
		case "01":
			days = 31;
			break;
		case "02":
			days = (Integer.parseInt(monthAndYear[1]) % 4 == 0) ? 29 : 28;
			break;
		case "03":
			days = 31;
			break;
		case "04":
			days = 30;
			break;
		case "05":
			days = 31;
			break;
		case "06":
			days = 30;
			break;
		case "07":
			days = 31;
			break;
		case "08":
			days = 31;
			break;
		case "09":
			days = 30;
			break;
		case "10":
			days = 31;
			break;
		case "11":
			days = 30;
			break;
		default:
			days = 31;

		}
		return days;
	}
}