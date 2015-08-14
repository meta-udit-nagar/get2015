import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ShapeTest {

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
	public void testGetArea() {
		Square square = new Square(4);
		assertEquals(16.0, square.getArea(), 0.001);
		
		
		Square square1 = new Square(5);
		assertEquals(25.0, square1.getArea(), 0.001);
		
		
		Square square2 = new Square(5);
		assertEquals(25.0, square2.getArea(), 0.001);
	
	   
	}

}
