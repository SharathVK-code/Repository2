package Assessments;

import java.util.Scanner;

public class gradingSystem_1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is the name of the Student?");
		String StudName = scanner.nextLine();
		System.out.println("How many marks did the "+StudName+" scored ?");
		int StudMarks = scanner.nextInt();
		
		if (StudMarks>=35) {
			System.out.println(StudName +" has passed in the exam");
			if (StudMarks>=35 && StudMarks<65) {
				System.out.println(StudName+" has been passed in 3rd grade with "+StudMarks+ " marks");
			}
			if (StudMarks>=65 && StudMarks<85) {
				System.out.println(StudName+" has been passed in 2nd grade with "+StudMarks+ " marks" );
			}
			if (StudMarks>=85 && StudMarks<=100) {
				System.out.println(StudName+" has been passed in 1st grade with "+StudMarks+ " marks");
			}
			
		} 
		else {
			System.out.println(StudName +" has been failed");

		}
		scanner.close();	
	}
}