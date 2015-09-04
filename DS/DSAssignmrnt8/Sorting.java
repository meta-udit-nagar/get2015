public class Sorting {

	private int[] numbers;
	private int number;

	public int[] bubbleSort(int a[]) {
		boolean swapped;
		int indexOfLastUnsortedElement = a.length - 1;
		do {
			swapped = false;
			for (int i = 0; i < indexOfLastUnsortedElement; i++) {

				if (a[i] > a[i + 1]) {
					int temp;
					temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					swapped = true;

				}

			}

			indexOfLastUnsortedElement--;

		} while (swapped);
		return a;
	}

	public int[] quicksort(int[] a) {

		if (a == null || a.length == 0) {
			return a;
		}
		numbers = a;
		number = a.length;
		quicksort(0, number - 1);
		return numbers;
	}

	private void quicksort(int low, int high) {
		int i = low, j = high;

		int pivot = numbers[low];

		while (i <= j) {
			while (numbers[i] < pivot) {
				i++;
			}
			while (numbers[j] > pivot) {
				j--;
			}

			if (i <= j) {

				int temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;

				i++;
				j--;
			}
		}

		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}

	public int[] radixSort(int a[]) {

		int count, first = a[0], exp = 1, n = a.length;
		int[] b = new int[10];
		for (count = 1; count < n; count++)
			if (a[count] > first)
				first = a[count];
		while (first / exp > 0) {
			int[] bucket = new int[10];

			for (count = 0; count < n; count++)
				bucket[(a[count] / exp) % 10]++;
			for (count = 1; count < 10; count++)
				bucket[count] += bucket[count - 1];
			for (count = n - 1; count >= 0; count--)
				b[--bucket[(a[count] / exp) % 10]] = a[count];
			for (count = 0; count < n; count++)
				a[count] = b[count];
			exp *= 10;
		}

		return a;

	}

	public int[] countingSort(int a[]) {
		int max=a[0];
		for(int i=1;i<a.length;i++)
		{
			if(max<a[i])
				max=a[i];
			
		}
		int key[] = new int[max+1];
		for (int i = 0; i < a.length; i++) {
			key[a[i]]++;
		}
		int count = 0;
		for (int i = 0; i < 100; i++) {

			for (int j = 0; j < key[i]; j++) {
				a[count++] = i;
			}

		}

		return a;

	}

}