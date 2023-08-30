package basic.closedlab;

public class Exercise25 {
	/*
	 * If we have the two classes as inner classes, there's no issues however if we
	 * have them as two separate classes then compile time exception will be thrown
	 * stating, protected modifier is not allowed.
	 */
	protected class base {
		String Method() {
			return "Wow";
		}
	}

	class derived {
		public void useD() {
			base z = new base();
			System.out.println("base says, " + z.Method());
		}
	}

	public static void main(String[] args) {
		Exercise25 obj = new Exercise25();
		derived d = obj.new derived();
		d.useD();
	}
}