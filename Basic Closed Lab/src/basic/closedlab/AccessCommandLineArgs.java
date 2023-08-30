package basic.closedlab;

public class AccessCommandLineArgs {
	public static void main(String[] args) {
		// flag for checking whether command line arguments passed or not
		boolean flag = false;

		// accessing and printing all command line arguments
		for (String s : args) {
			if (!flag)
				flag = !flag;
			System.out.println("The element of command line String array argument: " + s);
		}
		if (!flag)
			System.out.println("The command line argument is null");
	}
}