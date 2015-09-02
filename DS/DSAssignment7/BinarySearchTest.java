import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySearchTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testBinarySearchForAllDifferentElements() {
		BinarySearch binarySearch = new BinarySearch();
		int a[] = { 1, 2, 3, 4, 5 };
		int expected = 2;
		assertEquals(expected, binarySearch.binarySearch(a, 0, a.length - 1, 2));

	}

	@Test
	public void testBinarySearchForDublicateElementsInArray() {
		BinarySearch binarySearch = new BinarySearch();
		int a[] = { 1, 2, 2, 2, 5 };
		int expected = 2;
		assertEquals(expected, binarySearch.binarySearch(a, 0, a.length - 1, 2));

	}

	@Test
	public void testBinarySearchForSameElementsInArray() {
		BinarySearch binarySearch = new BinarySearch();
		int a[] = { 2, 2, 2, 2, 2 };
		int expected = 1;
		assertEquals(expected, binarySearch.binarySearch(a, 0, a.length - 1, 1));

	}

	@Test
	public void testBinarySearchForElementNotInArray() {
		BinarySearch binarySearch = new BinarySearch();
		int a[] = { 1, 2, 2, 3, 5 };
		int expected = -1;
		assertEquals(expected, binarySearch.binarySearch(a, 0, a.length - 1, 6));

	}

}
