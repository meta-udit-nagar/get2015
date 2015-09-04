import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TreeSortTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testTreeSortForNullInput() {
		TreeSort treeSort = new TreeSort();
		int inputRollno[] = {};
		int expected[] = {};
		assertArrayEquals(expected, treeSort.treeSort(inputRollno));

	}

	@Test
	public void testTreeSortForBestCase() {
		TreeSort treeSort = new TreeSort();
		int inputRollno[] = { 1, 2, 3, 4, 5 };
		int expected[] = { 1, 2, 3, 4, 5 };
		assertArrayEquals(expected, treeSort.treeSort(inputRollno));

	}

	@Test
	public void testTreeSortForAverageCase() {
		TreeSort treeSort = new TreeSort();
		int inputRollno[] = { 2, 4, 1, 5, 3 };
		int expected[] = { 1, 2, 3, 4, 5 };
		assertArrayEquals(expected, treeSort.treeSort(inputRollno));

	}

	@Test
	public void testTreeSortForWorstCase() {
		TreeSort treeSort = new TreeSort();
		int inputRollno[] = { 5, 4, 3, 2, -1 };
		int expected[] = { -1, 2, 3, 4, 5 };
		assertArrayEquals(expected, treeSort.treeSort(inputRollno));

	}

}
