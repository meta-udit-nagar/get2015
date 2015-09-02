import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckFrequency {

	private Map<String, Integer> cache = new HashMap<String, Integer>();

	public int checkFrequency(String input) {
		int output = 0;
		Set<Character> setOfChatacter = new HashSet<Character>();

		if (cache.containsKey(input)) {
			output = cache.get(input);
		} else {
			for (int i = 0; i < input.length(); i++) {
				setOfChatacter.add(input.charAt(i));

			}
			output = setOfChatacter.size();
			cache.put(input, output);

		}
		return output;

	}

}
