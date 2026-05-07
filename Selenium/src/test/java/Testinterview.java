import java.util.LinkedHashMap;
import java.util.Map;

public class Testinterview {

	public static void main(String[] args) {

		String input = "automation";

		Map<Character, Integer> charCount = new LinkedHashMap<Character, Integer>();
		for (char ch : input.toCharArray()) {

			charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
		}

		for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
			if (entry.getValue() == 1) {

				System.out.println("First non repeating charecter is " + entry.getKey());
				break;

			}

		}

	}

}
