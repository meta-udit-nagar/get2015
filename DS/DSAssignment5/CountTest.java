import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class CountTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testCountFrequency() {
		String expected = "r 7 d 9 e 1 w 5 h 0 l 2,3,8 o 4,6 ";
		String input[] = { "hello", "world" };
		Count count = new Count();
		assertEquals(expected, count.countFrequency(input));
	}

	@Test
	public void testCountFrequencyEmptyArgument() {
		String expected = "";
		String input[] = {};
		Count count = new Count();
		assertEquals(expected, count.countFrequency(input));
	}

	@Test
	public void testCountFrequencySingleWordArgument() {
		String expected = "a 0,1,2 ";
		String input[] = { "aaa" };
		Count count = new Count();
		assertEquals(expected, count.countFrequency(input));
	}

}
