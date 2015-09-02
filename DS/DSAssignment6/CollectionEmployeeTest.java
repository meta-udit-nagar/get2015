import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class CollectionEmployeeTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testAddEmployeeSuccessfully() {
		CollectionEmployee collectionEmployee = new CollectionEmployee();
		collectionEmployee.addEmployee(101, "abc", "pqr");
		assert (collectionEmployee.addEmployee(102, "abc", "pqr"));
	}

	@Test
	public void testAddEmployeeRejected() {
		CollectionEmployee collectionEmployee = new CollectionEmployee();
		collectionEmployee.addEmployee(101, "abc", "pqr");
		assertEquals(false, collectionEmployee.addEmployee(101, "gdf", "hjd"));
	}

}
