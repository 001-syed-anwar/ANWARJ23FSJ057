package basic.closedlab.inheritance;

public class PBV_PBR {
	int j=5;
	public static void passByValue(int i) {
		i=10;
	}
	public void passByRef(PBV_PBR obj) {
		obj.j=10;
	}
	
	public static void passBRefArray(int[] arr) {
		arr[0]=10;
	}
	public static void main(String[] args) {
		int i=5;
		int[] arr= {1,2,3,4};
		PBV_PBR  obj=new PBV_PBR();
		
		System.out.println("int data before..."+i);
		passByValue(i);
		System.out.println("int data after..."+i);
		System.out.println("array element before.."+arr[0]);
		passBRefArray(arr);
		System.out.println("array element after.."+arr[0]);
		System.out.println("Instance variable before.."+obj.j);
		obj.passByRef(obj);
		System.out.println("Instance variable after.."+obj.j);
	}
}
