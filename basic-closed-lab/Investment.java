package basic.closedlab;

public class Investment {
	public static void main(String[] args) {
		double investment = 14000;

		System.out.println("The initial investment is : " + investment);
		System.out.println("The profit in the first year is 40% ,");
		System.out.println("The investment money after profit : " + (investment += getPercentValue(investment, 40)));
		System.out.println("The loss in the second year is 1400 ,");
		System.out.println("The investment money after loss : " + (investment -= 1400));
		System.out.println("The profit in the third year is 12%");
		System.out.println("The investment money after profit : " + (investment += getPercentValue(investment, 12)));

	}

	public static double getPercentValue(double investment, int percent) {

		return (investment * percent) / 100;
	}
}
