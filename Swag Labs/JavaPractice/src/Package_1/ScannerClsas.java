package Package_1;

import java.util.Scanner;

public class ScannerClsas {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Hello!, what is your name?");
		String name = scanner.nextLine();
		System.out.println("Hi "+ name + " what is your age?");
		int age = scanner.nextInt();
		System.out.println("Ok "+ name +" Thank you for the " +age+ ", confirmation on your age");
		System.out.println("Thanks for the info");
		scanner.close();
	}

}
