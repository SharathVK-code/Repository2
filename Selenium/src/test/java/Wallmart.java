import java.util.Arrays;
import java.util.List;

public class Wallmart {

	public static void main(String[] args) {

		List<String> products = Arrays.asList("iphone 11", "Samsung Galaxy", "Pixel 4", "iphone 8");
		List<Integer> prices = Arrays.asList(700, 650, 899, 284);

		int maxPrice = prices.get(0);
		String expensiveProduct = products.get(0);

		for (int i = 1; i < prices.size(); i++) {

			if (prices.get(i) > maxPrice) {
				maxPrice = prices.get(i);
				expensiveProduct = products.get(i);

			}

		}

		System.out.println("Expensice Product: " + expensiveProduct);
		System.out.println("Max Price: " + maxPrice);

	}

}
