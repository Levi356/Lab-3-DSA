package Balance;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter Balancing Bracket Expression");
		String expression = scanner.nextLine();
		Balance balancingBrackets = new Balance();
		if (balancingBrackets.BalancedBrackets(expression)) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered String do not contain Balanced Brackets");
		}
		scanner.close();
	}

}
