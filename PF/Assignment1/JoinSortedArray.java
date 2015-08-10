public class JoinSortedArray {

	public static int[] join(int[] a, int aLength, int[] b, int bLength,
			int c[]) {

		int i = 0, j = 0, k = 0;
		while (i < aLength && j < bLength) {
			if (a[i] < b[j]) {
				c[k] = a[i];
				i++;
			} else {
				c[k] = b[j];
				j++;
			}
			k++;
		}

		while (i < aLength) {
			c[k] = a[i];
			i++;
			k++;
		}

		while (j < bLength) {
			c[k] = b[j];
			j++;
			k++;
		}

		return c;
	}

}
