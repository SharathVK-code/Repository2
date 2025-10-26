package Package_1;

public class OperatorPractice {

	public int Small() {

		int a = 2;
		int b = 3;
		int d = a+b;
		return d;
	}
	public static void main(String[] args) {

		OperatorPractice c = new OperatorPractice();
		int e = c.Small();

		int i = 20;
		int j = 10;

		System.out.println(e+i-j);
		System.out.println(e*i);
		System.out.println(i/j);

		System.out.println(++e);
		System.out.println(i--);
		System.out.println(i);
		System.out.println(--j);

		System.out.println(i>j);
		System.out.println(i<j);
		System.out.println(i==j);
		System.out.println(i>=j);
		System.out.println(i<=j);
		System.out.println(e<j);

		System.out.println((i>j || i<j) || (e>=i || j>=e));

		System.out.println(i+=5);
		System.out.println(e-=5);
		System.out.println(j*=5);
	}

}