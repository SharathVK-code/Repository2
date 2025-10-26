package Assessments;

import java.util.Scanner;

public class switch_ArithmeticOperations {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Hi Mowa!");
		System.out.print("Enter number1:");
		int n1 = scanner.nextInt();
		System.out.print("Enter number2:");
		int n2 = scanner.nextInt();
		System.out.print("Enter the Target Operation (+,-,*,/,%):");
		char operator = scanner.next().charAt(0);
		
		switch(operator) {
		
		case '+':
			int result = n1+n2;
			System.out.println(result+ " is the output");
			break;
		case '-':
			int result1 = n1-n2;
			System.out.println(result1+ " is the output");
			break;
		case '*':
			int result2 = n1*n2;
			System.out.println(result2+ " is the output");
			break;
		case '/':
			int result3 = n1/n2;
			System.out.println(result3+ " is the output");
			break;
		case '%':
			int result4 = n1%n2;
			System.out.println(result4+ " is the output");
			break;
			default:
				System.err.println("please enter valid operator");
				break;
		
		}
		scanner.close();
	}

}
