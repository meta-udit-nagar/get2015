public class Dublicate {

	public static int[] removeDuplicates(int[] input) {

		/* radix sort */

		int count, first = input[0], exp = 1, n = input.length;
		int[] b = new int[10];
		for (count = 1; count < n; count++)
			if (input[count] > first)
				first = input[count];
		while (first / exp > 0) {
			int[] bucket = new int[10];

			for (count = 0; count < n; count++)
				bucket[(input[count] / exp) % 10]++;
			for (count = 1; count < 10; count++)
				bucket[count] += bucket[count - 1];
			for (count = n - 1; count >= 0; count--)
				b[--bucket[(input[count] / exp) % 10]] = input[count];
			for (count = 0; count < n; count++)
				input[count] = b[count];
			exp *= 10;
		}

		/*------*/
		int j = 0;
		int i = 1;
		if (input.length < 2) {
			return input;
		}
		while (i < input.length) {
			if (input[i] == input[j]) {
				i++;
			} else {
				input[++j] = input[i++];
			}
		}
		int[] output = new int[j + 1];
		for (int k = 0; k < output.length; k++) {
			output[k] = input[k];
		}

		return output;
	}

}
