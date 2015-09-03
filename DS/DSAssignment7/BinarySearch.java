public class BinarySearch {

	private boolean flag = false;
	private int position = 0;

	public int binarySearch(int input[], int key) {
		int start = 0;
		int end = input.length - 1;
		int position = binarySearch(input, start, end, key);
		return position;

	}

	private int binarySearch(int input[], int start, int end, int key) {

		if (start > end) {
			return (position + 1);
		}

		else if (start == end) {

			if (input[start] == key) {
				position = start;
			} else if (flag == false) {
				return -1;
			}
		} else {

			int mid = (start + end) / 2;

			if (input[mid] == key) {

				position = mid;
				flag = true;
				return binarySearch(input, start, mid - 1, key);
			}

			else if (input[mid] > key) {
				return binarySearch(input, start, mid - 1, key);
			}

			else {
				return binarySearch(input, mid + 1, end, key);
			}
		}
		return (position + 1);
	}

}
