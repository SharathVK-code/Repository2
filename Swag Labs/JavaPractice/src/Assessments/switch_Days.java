package Assessments;

import java.util.Scanner;

public class switch_Days {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Hi mowa, Enter the day:");
		String day = scanner.nextLine().toLowerCase();

		switch (day) {

		case "monday":
			System.out.println(day+ " ra idi bokka lo di");
			break;

		case "tuesday":
			System.out.println(day+ " ra idi bokka lo di");
			break;

		case "wednesday":
			System.out.println(day+ " ra idi bokka lo di");
			break;

		case "thrusday":
			System.out.println(day+ " ra idi bokka lo di");
			break;

		case "friday":
			System.out.println(day+ " ra idi bokka lo di");
			break;

		case "saturday":
			System.out.println(day+ " idi, ante weekenduuu.....baraabar enjoy cheddam pa");
			break;

		case "sunday":
			System.out.println(day+ " idi, ante weekenduuu.....baraabar enjoy cheddam pa");
			break;

		default:
			System.err.println("The text you've entered is invalid");
			break;
		}
		scanner.close();

	}


}
