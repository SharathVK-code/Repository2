package Assessments;

import java.util.Scanner;

public class ifElse_days {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Hello bayya, nee name endi?");
		String name = scanner.nextLine();
		System.out.println(name+ " kaaka namaste!!, antha manchige unnada ?");

		System.out.println("Enter the day(iyaala em dinam ?)");
		String day = scanner.nextLine().toLowerCase();		

//		if(day.equals("monday")) {
//			System.out.println("Deenamma idi "+day+" ra ayya");
//		}
//		else if(day.equals("tuesday")) {
//			System.out.println("Deenamma idi "+day+" ra ayya");
//		}
//		else if(day.equals("wednesday")) {
//			System.out.println("Deenamma idi "+day+" ra ayya");
//		}
//		else if(day.equals("thursday")) {
//			System.out.println("Deenamma idi "+day+" ra ayya");
//		}
//		else if(day.equals("friday")) {
//			System.out.println("Deenamma idi "+day+" ra ayya");
//		}
//		else if(day.equals("saturday")) {
//			System.out.println("Hammayya idi "+day+" , Hurray!!");
//		}
//		else if(day.equals("sunday")) {
//			System.out.println("Hammayya idi "+day+" , Hurray!!");
//		}
//		else {
//			System.out.println("Enter a valid day");
//		}
		
		
		if (day.equals("monday")||day.equals("tuesday")||day.equals("wednesday")||day.equals("thursday")||day.equals("friday")){
			System.out.println("Uff!!, it's a weekeday");
		}
		else if(day.equals("saturday")||day.equals("sunday")) {
			System.out.println("yay!, it's a weekend");
		}
		else {
			System.out.println("please enter a valid day");
		}
		scanner.close();
	}
}

