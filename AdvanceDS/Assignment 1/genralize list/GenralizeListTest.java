package addsAssignment;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class GenralizeListTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testToStringNode() {
		GenralizeList genralizeList = new GenralizeList("(1,(2,1),7)");
		String expected = "1217";
		assertEquals(expected, genralizeList.toString(genralizeList.getStart()));
	}

	@Test
	public void testCalculateMax() {
		GenralizeList genralizeList = new GenralizeList("(1,(2,1),7)");
		int expected = 7;
		assertEquals(expected,
				genralizeList.calculateMax(genralizeList.getStart()));
	}

	@Test
	public void testCalculateSum() {
		GenralizeList genralizeList = new GenralizeList("(1,(2,1),7)");
		int expected = 11;
		assertEquals(expected,
				genralizeList.calculateSum(genralizeList.getStart()));
	}

	@Test
	public void testSearchTrue() {
		GenralizeList genralizeList = new GenralizeList("(1,(2,1),7)");
		assertTrue(genralizeList.search(genralizeList.getStart(), 2));

	}

	@Test
	public void testSearchFalse() {
		GenralizeList genralizeList = new GenralizeList("(1,(2,1),7)");
		assertFalse(genralizeList.search(genralizeList.getStart(), 10));

	}

}
