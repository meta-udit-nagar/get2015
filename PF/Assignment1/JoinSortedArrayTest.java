import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JoinSortedArrayTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		int a[] = { 1, 2 };
		int b[] = { 4, 5, 6 };
		int c[] = new int[a.length + b.length];
		int cExpected[] = new int[] { 1, 2, 4, 5, 6 };
		assertArrayEquals(cExpected, JoinSortedArray.join(a, 2, b, 3, c));

		int a1[] = { 1, 2, 3 };
		int b1[] = { 1, 2, 3 };
		int c1[] = new int[a1.length + b1.length];
		int cExpected1[] = new int[] { 1, 1, 2, 2, 3, 3 };
		assertArrayEquals(cExpected1, JoinSortedArray.join(a1, 3, b1, 3, c1));

		int a2[] = new int[0];
		int b2[] = { 4, 5, 6 };
		int c2[] = new int[a2.length + b2.length];
		int cExpected2[] = new int[] { 4, 5, 6 };
		assertArrayEquals(cExpected2, JoinSortedArray.join(a2, 0, b2, 3, c2));
	}

}
