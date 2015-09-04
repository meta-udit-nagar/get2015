import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class SortingApplicationTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testProcessBubbleSort() {
		SortingApplication application = new SortingApplication();
		int input[] = { 5, 4, 2, 3, 1 };
		String expected = "System has used bubbleSort sorting technique and sorted list as : 1 2 3 4 5";
		assertEquals(expected, application.process(1, input));

	}

	@Test
	public void testProcessQuickSort() {
		SortingApplication application = new SortingApplication();
		int input[] = { 5, 4, 2, 3, 1, 10, 9, 8, 7, 6, 11 };
		String expected = "System has used quickSort sorting technique and sorted list as : 1 2 3 4 5 6 7 8 9 10 11";
		assertEquals(expected, application.process(1, input));

	}

	@Test
	public void testProcessCountingSort() {
		SortingApplication application = new SortingApplication();
		int input[] = { 5, 4, 2, 3, 1, 10, 9, 8, 7, 6, 11 };
		String expected = "System has used countingSort sorting technique and sorted list as : 1 2 3 4 5 6 7 8 9 10 11";
		assertEquals(expected, application.process(2, input));

	}

	@Test
	public void testProcessRadixSort() {
		SortingApplication application = new SortingApplication();
		int input[] = { 50, 400, 212, 3, 1, };
		String expected = "System has used radixSort sorting technique and sorted list as : 1 3 50 212 400";
		assertEquals(expected, application.process(2, input));

	}

}
