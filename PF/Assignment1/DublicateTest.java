import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DublicateTest {

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

		int expected[] = { 1, 2, 3 };
		int input[] = { 1, 2, 3 };
		assertArrayEquals(expected, Dublicate.removeDuplicates(input));

		int expected1[] = { 1 };
		int input1[] = { 1, 1 };
		assertArrayEquals(expected1, Dublicate.removeDuplicates(input1));

		int expected2[] = { 1, 2 };
		int input2[] = { 1, 2, 1 };
		assertArrayEquals(expected2, Dublicate.removeDuplicates(input2));
	}

}
