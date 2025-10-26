package Package_1;

public class Bank {

	static int currentBalance = 5000;
	public static void greet() {
	
		System.out.println("Hello, Welcome to the TCS bank");
	}
	
	public void deposit(int amount) {
		currentBalance = currentBalance + amount;
		System.out.println("Money deposited and "+currentBalance+" is your current balance");
	}
	
    public void withdrawl(int amount) {
    	currentBalance = currentBalance - amount;
		System.out.println("Money withdrawn and "+currentBalance+" is your current balance");
	}
    
    public static int getCurrentBalance() {
    	System.out.println("current balance is - "+ currentBalance);
		return currentBalance;
		
	}
	
	
	public static void main(String[] args) {

		Bank bank = new Bank();
		greet();
		getCurrentBalance();
		bank.deposit(10);
		bank.withdrawl(2000);
		getCurrentBalance();
	}
	
}
