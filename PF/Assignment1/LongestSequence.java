public class LongestSequence {

	public static int[] longestSequence(int a[]) {

		int count = 1;
		int max = 1;
		int start = 0;
		int last = 0;

		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] < a[i + 1]) {

				count++;
			} else {
				if (count > max) {
					last = i;
					max = count;
				}
				count = 1;

			}
		}
		if (count > max) {
			last = a.length - 1;
			max = count;
		}
		int result[] = new int[max];
		start = last - max + 1;
		int counter = 0;
		for (int i = start; i <= last; i++) {
			result[counter] = a[i];

			counter++;
		}
		return result;
	}

}
