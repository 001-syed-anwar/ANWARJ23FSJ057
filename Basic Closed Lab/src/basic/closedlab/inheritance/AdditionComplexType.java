package basic.closedlab.inheritance;

public class AdditionComplexType {
public static void main(String[] args) {
	int x,y;
	x=y=10;
	ComplexType obj=new ComplexType(x, y);
	System.out.println("The sum of "+x+" and "+y+" is "+obj.getSum());
}
}
class ComplexType{
	private int x, y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public ComplexType(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public int getSum() {
		return this.x+this.y;
	}
	
}