package Assessments;

import java.util.Iterator;

public class interview_code {

	public static void main(String[] args) {

		String input = "Fajabdh234";
		int charcount = 0;
		int digitcount = 0;
		
		for (int i=0; i < input.length(); i++)
		{
		
			char ch = input.charAt(i);
			 if (Character.isLetter(ch)) {
				 charcount++ ;
			 }
				 else if(Character.isDigit(ch))	 
				 {
					 digitcount++ ; 
				 }
				 
			 }
			 System.out.println("number of characters(letters)-"+charcount);
			 System.out.println("number of digits-"+ digitcount);
			
		}
		
		
	}

