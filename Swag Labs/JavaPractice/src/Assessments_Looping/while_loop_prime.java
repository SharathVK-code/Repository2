package Assessments_Looping;

public class while_loop_prime {

	public static void main(String[] args) {

		int primenum = 50;
		System.out.println("Prime numbers in between 50 and 150 are:");
		
		while (primenum<=150) {
			if (isPrime(primenum)) {
				System.out.println(primenum);
			}
			primenum++;
			
		}
		
	}

	public static boolean isPrime(int num) {

		if (num<=1) {
			return false;
		}
	
		for (int i = 2; i < Math.sqrt(num); i++) {
			if (num%i==0) {
				return false;
			}
		}
		return true;
	}

}