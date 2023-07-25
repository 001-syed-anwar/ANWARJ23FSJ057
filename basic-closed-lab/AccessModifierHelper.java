package basic.closedlab;

public class AccessModifierHelper {
	//testing from different class and same package using instance block
	{
		AccessModifier obj = new AccessModifier();
		System.out.println(obj.i_default);
		System.out.println(obj.i_protected);
		System.out.println(obj.i_public);
		obj.met_default();
		obj.met_protected();
		obj.met_public();
	}
}
