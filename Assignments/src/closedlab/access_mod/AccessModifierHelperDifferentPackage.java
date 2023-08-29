package closedlab.access_mod;

import basic.closedlab.AccessModifier;

public class AccessModifierHelperDifferentPackage extends AccessModifier {
//	testing from different class, different package and from a sub class using instance block
	{
		AccessModifierHelperDifferentPackage obj = new AccessModifierHelperDifferentPackage();
		System.out.println(obj.i_protected);
		System.out.println(obj.i_public);
		obj.met_protected();
		obj.met_public();
	}
}

class AccessModHelper {
//	testing from different class and different package using instance block
	{
		AccessModifier obj = new AccessModifier();
		System.out.println(obj.i_public);
		obj.met_public();
	}
}