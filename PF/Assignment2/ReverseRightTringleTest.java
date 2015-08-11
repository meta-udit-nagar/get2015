import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReverseRightTringleTest {

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
	public void testSpaces() {

		assertEquals(1, ReverseRightTringle.spaces(2, 5).length());
		assertEquals(0, ReverseRightTringle.spaces(1, 5).length());
		assertEquals(4, ReverseRightTringle.spaces(5, 5).length());
		assertEquals("wrong input", ReverseRightTringle.spaces(100, 5));
		assertEquals("wrong input", ReverseRightTringle.spaces(-5, 5));

	}

	@Test
	public void testNumbers() {
		assertEquals("12345", ReverseRightTringle.numbers(1, 5));
		assertEquals("1", ReverseRightTringle.numbers(5, 5));
		assertEquals("1234", ReverseRightTringle.numbers(2, 5));
		assertEquals("wrong input", ReverseRightTringle.numbers(100, 2));
		assertEquals("wrong input", ReverseRightTringle.spaces(-5, 5));
	}

	@Test
	public void testReversrRightTringle() {
		String expected[] = { "123", " 12", "  1" };
		assertArrayEquals(expected, ReverseRightTringle.reversrRightTringle(3));

		String expected1[] = { "1" };
		assertArrayEquals(expected1, ReverseRightTringle.reversrRightTringle(1));
	}

}
