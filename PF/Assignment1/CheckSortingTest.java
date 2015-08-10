import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CheckSortingTest {

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
		CheckSorting checkSorting= new CheckSorting();
		int a[]={1,2,3};
		assertEquals(1, checkSorting.checkSorting(a));
		
		
		int a1[]={1,2,1};
		assertEquals(0, checkSorting.checkSorting(a1));
		
		
		int a2[]={3,2,1};
		assertEquals(2, checkSorting.checkSorting(a2));
	}

	
	
	
	@Test
	public void messageTest() {
		CheckSorting checkSorting= new CheckSorting();
		int a=1;
		assertEquals("Array is in accending order", checkSorting.returnMessage(a));
		
		
		int a1=2;
		assertEquals("Array is in decending order", checkSorting.returnMessage(a1));
		
		
		int a2=0;
		assertEquals("Array is not sorted", checkSorting.returnMessage(a2));
	}
}
