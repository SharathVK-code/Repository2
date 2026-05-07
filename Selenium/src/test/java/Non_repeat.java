import java.util.LinkedHashMap;
import java.util.Map;

public class Non_repeat {

	public static void main(String[] args) {

		String input = "Salesforce";

		Map<Character, Integer> charCount = new LinkedHashMap<>();
		for (char ch : input.toCharArray()) {

			charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
		}

		for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {

			if (entry.getValue() == 1) {
				System.out.println("First non repeating character: " + entry.getKey());
				break;
			}
		}

	}

}
