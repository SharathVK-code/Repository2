package Assessments;

import java.util.Scanner;

public class gradingSystem {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("What is the name of the Student?");
		String studentName = scanner.nextLine();
		System.out.println("How many marks did "+studentName+" scored?");
		int studentmarks = scanner.nextInt();

		if (studentmarks>=35) {
			System.out.println(studentName+" is Passed");
			if (studentmarks>=35 && studentmarks<70) {
				System.out.println(studentName+" passed in Third grade, enduku ra eee mark lu teeskelli ganga lo padey");
			}
			if (studentmarks>=70 && studentmarks<85) {
				System.out.println(studentName+" passed in Second grade, next time inka improve avvali beta");
			}
			if (studentmarks>=85) {
				System.out.println(studentName+" passed in First grade, nuvvu thopu mowa");
			}
		}
		else {
			System.out.println(studentName+" neeku saduvu Bokka ra , nuvvu Fail ayinaav");
		}
		scanner.close();
	}
}