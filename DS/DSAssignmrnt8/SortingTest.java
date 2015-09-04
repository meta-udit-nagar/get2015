import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class SortingTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testBubbleSortBestCase() {
		Sorting sorting = new Sorting();
		int input[] = { 1, 2, 3, 4, 5 };
		int expected[] = { 1, 2, 3, 4, 5 };
		assertArrayEquals(expected, sorting.bubbleSort(input));
	}

	@Test
	public void testBubbleSortAverageCase() {
		Sorting sorting = new Sorting();
		int input[] = { 1, 4, 3, 5, 2 };
		int expected[] = { 1, 2, 3, 4, 5 };
		assertArrayEquals(expected, sorting.bubbleSort(input));
	}

	@Test
	public void testBubbleSortWorstCase() {
		Sorting sorting = new Sorting();
		int input[] = { 5, 4, 3, 2, 1 };
		int expected[] = { 1, 2, 3, 4, 5 };
		assertArrayEquals(expected, sorting.bubbleSort(input));
	}

	@Test
	public void testQuicksortWorstCase() {
		Sorting sorting = new Sorting();
		int input[] = { 1, 1, 2, 2, 5 };
		int expected[] = { 1, 1, 2, 2, 5 };
		assertArrayEquals(expected, sorting.quicksort(input));
	}

	@Test
	public void testQuicksortBestCase() {
		Sorting sorting = new Sorting();
		int input[] = { 1, 2, 3, 4, 5 };
		int expected[] = { 1, 2, 3, 4, 5 };
		assertArrayEquals(expected, sorting.quicksort(input));
	}

	@Test
	public void testQuicksortAverageCase() {
		Sorting sorting = new Sorting();
		int input[] = { 4, 5, 1, 2, 3 };
		int expected[] = { 1, 2, 3, 4, 5 };
		assertArrayEquals(expected, sorting.quicksort(input));
	}

	@Test
	public void testRadixSortBestCase() {
		Sorting sorting = new Sorting();
		int input[] = { 100, 101, 201, 456, 1000 };
		int expected[] = { 100, 101, 201, 456, 1000 };
		assertArrayEquals(expected, sorting.radixSort(input));

	}

	@Test
	public void testRadixSortAverageCase() {
		Sorting sorting = new Sorting();
		int input[] = { 101, 100, 456, 201, 1000 };
		int expected[] = { 100, 101, 201, 456, 1000 };
		assertArrayEquals(expected, sorting.radixSort(input));

	}

	@Test
	public void testRadixSortWorstCase() {
		Sorting sorting = new Sorting();
		int input[] = { 1000, 456, 201, 101, 100 };
		int expected[] = { 100, 101, 201, 456, 1000 };
		assertArrayEquals(expected, sorting.radixSort(input));

	}

	@Test
	public void testCountingSortBestCase() {
		Sorting sorting = new Sorting();
		int input[] = { 1, 2, 3, 20, 99 };
		int expected[] = { 1, 2, 3, 20, 99 };
		assertArrayEquals(expected, sorting.countingSort(input));
	}

	@Test
	public void testCountingSortAverageCase() {
		Sorting sorting = new Sorting();
		int input[] = { 3, 2, 99, 20, 1 };
		int expected[] = { 1, 2, 3, 20, 99 };
		assertArrayEquals(expected, sorting.countingSort(input));
	}

	@Test
	public void testCountingSortWorstCase() {
		Sorting sorting = new Sorting();
		int input[] = { 99, 20, 3, 2, 1 };
		int expected[] = { 1, 2, 3, 20, 99 };
		assertArrayEquals(expected, sorting.countingSort(input));
	}

}
