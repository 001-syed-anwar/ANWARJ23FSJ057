package basic.closedlab;

public class AccessModifier {
	// scope of the private access modifier is within the class
	private int i_private = 10;

	/*
	 * scope of the default access modifier is within the class and within the
	 * package
	 */
	int i_default = 10;

	/*
	 * scope of the protected access modifier is within the class, within the
	 * package and for the sub classes.
	 */
	protected int i_protected = 10;

	/*
	 * scope of the protected access modifier is within the class, within the
	 * package, for the sub classes and for any classes from any package.
	 */
	public int i_public = 10;

	// scope of the private access modifier is within the class
	private void met_private() {
		System.out.println("Private method");
	}

	/*
	 * scope of the default access modifier is within the class and within the
	 * package
	 */
	void met_default() {
		System.out.println("default method");
	}

	/*
	 * scope of the protected access modifier is within the class, within the
	 * package and for the sub classes.
	 */
	protected void met_protected() {
		System.out.println("protected method");
	}

	/*
	 * scope of the protected access modifier is within the class, within the
	 * package, for the sub classes and for any classes from any package.
	 */
	public void met_public() {
		System.out.println("Public method");
	}

//	testing from same class and same package using instance block
	{
		AccessModifier obj = new AccessModifier();
		System.out.println(obj.i_private);
		System.out.println(obj.i_default);
		System.out.println(obj.i_protected);
		System.out.println(obj.i_public);
		obj.met_private();
		obj.met_default();
		obj.met_protected();
		obj.met_public();
	}
}
