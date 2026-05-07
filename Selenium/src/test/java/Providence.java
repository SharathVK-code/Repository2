public class Providence {

	public static void main(String[] args) {

		String str = "Hello World";

		// Split the strings into words
		String[] words = str.split(" ");
		String result = "";

		// reverse the words in the string array
		for (String word : words) {
			String reverseWord = new StringBuilder(word).reverse().toString();
			result += reverseWord + " ";

		}

		result = result.trim();

		System.out.println(result);

	}

}
