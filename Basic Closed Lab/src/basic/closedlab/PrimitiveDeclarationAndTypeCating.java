package basic.closedlab;

public class PrimitiveDeclarationAndTypeCating {
	/*
	 * primitive data types declared in field, may be left uninitialized, They will
	 * be assigned their default values anyways.thus, there will be no exceptions
	 * thrown.
	 */

	// static or class level variables
	static int i;
	static byte b;
	static boolean bool;
	static char c;
	static float f;
	static double d;
	static long l;
	static short s;

	// instance or object level variables
	int i1;
	byte b1;
	boolean bool1;
	char c1;
	float f1;
	double d1;
	long l1;
	short s1;

	public static void main(String[] args) {
		/*
		 * Local variables must have been initialized, before it is being used.
		 */

		// local variables
		int i2 = 1; // 4 bytes
		byte b2 = 1; // 1 byte

		@SuppressWarnings("unused")
		// boolean data type can't be type casted with any data type in java.
		boolean bool2 = false; // 1 byte
		char c2 = '1'; // 2 bytes
		float f2 = 1f; // 4 bytes
		double d2 = 1d; // 8 bytes
		long l2 = 1l; // 8 bytes
		short s2 = 1; // 2 bytes

		/*
		 * casting possible, as long as the int variable carrying integer value is
		 * within the range of byte. It is called explicit type casting, when we try to
		 * assign large sized data type variables/values into smaller ones. we can
		 * identify which data type is smaller, which one is greater by their byte
		 * size.
		 */
		b2 = (byte) i2;

		// another example
		s2 = (short) i2;

		/*
		 * this is called implicit type casting;
		 */
		i2 = b2;

		/*
		 * in java, any integer data type can be casted with char data type as well.
		 * But, of course char has range limits too, plus it only accepts positive
		 * integer.
		 */
		c2 = 0;
		c2 = 11;

		/*
		 * Since, there could negative numbers in byte,short and int we need to do
		 * explicit casting.
		 */
		c2 = (char) b2;
		c2 = (char) s2;
		c2 = (char) i2;

		/*
		 * this is not possible i2=-1; c2=(char)12; c2=-1;
		 */

		// some more casting with char.
		b2 = (byte) c2;
		s2 = (short) c2;
		i2 = c2;

		// casting with decimal point data types.
		/*
		 * when casting decimal data types with Integer data types (int,byte,short) two
		 * things should be considered.First, decimal points values will be truncated.
		 * Second, double and long data types can't be casted with a int data type
		 * beyond it's memory limits. Doing that will lead to truncation of values, it
		 * may not throw any errors but you will lose the actual values.For example,
		 * byte range goes from -127 to 128, when casting any large values stored in
		 * decimal data types, let's say 129 then it will go in loop within it's range
		 * and stops at where the larger values leads them into. So, In this case byte
		 * data type will end up having -127 instead of 129.
		 */
		System.out.println(d2);
		i2 = (int) d2;
		System.out.println(i2);
		i2 = (int) f2;
		i2 = (int) l2;

		d2 = 129;
		b2 = (byte) d2;
		System.out.println(b2);
	}
}