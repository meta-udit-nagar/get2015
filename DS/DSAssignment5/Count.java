import java.util.HashMap;

public class Count {

	public String countFrequency(String args[]) {

		String input = "";
		for (int i = 0; i < args.length; i++)
			input = input + args[i];
		
		
		HashMap<Character, String> hm = new HashMap<Character, String>();

		for (int i = 0; i < input.length(); i++) {

			if (hm.containsKey(input.charAt(i))) {
				hm.put(input.charAt(i), hm.get(input.charAt(i)) + "," + i);
			} else {
				String s = "" + i;
				hm.put(input.charAt(i), s);

			}

		}
		String output = "";

		for (char c : hm.keySet()) {

			output = output + c + " " + hm.get(c) + " ";
		}

		return output;

	}

	public static void main(String args[]) {
		Count count= new Count();
		System.out.println(count.countFrequency(args));

	}

}
