package Assessments;

import java.util.Scanner;

public class switch_evenodd {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a value:");
		int i = scanner.nextInt();

		switch(i%2) {

		case 0:
			System.out.println(i+ " is an even number");
			break;
		case 1:
			System.out.println(i+ " is an Odd number");
			break;
		default:
			System.out.println("please enter valid number");
			break;

		}
		scanner.close();
	}
}