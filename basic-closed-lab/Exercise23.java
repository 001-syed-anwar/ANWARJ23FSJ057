package basic.closedlab;

public class Exercise23 {
	// protected property
	protected int data;

	public static void main(String[] args) {
		Exercise23 exercise23 = new Exercise23();
		exercise23.data = 10;
		System.out.println("The protected data before manipulation : " + exercise23.data);
		Test.manipulateProtectedData(exercise23, 15);
		System.out.println("The protected data after manipulation : " + exercise23.data);
	}
}

class Test {

	// manipulates the protected data
	public static void manipulateProtectedData(Exercise23 obj, int value) {
		obj.data = value;
	}
}
