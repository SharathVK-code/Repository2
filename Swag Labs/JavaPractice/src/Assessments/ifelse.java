package Assessments;

import java.util.Scanner;

public class ifelse {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("What is the number?");
		int usernumber = scanner.nextInt();
		if (usernumber%2 == 0) {
			System.out.println("The number is Even number");
		}
		else {
			System.out.println("The number is Odd number");
		}
		scanner.close();
	}

}