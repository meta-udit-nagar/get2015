import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeMainTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testNaturalSortMixedOrder() {
		EmployeeMain employee = new EmployeeMain();
		employee.add(101, "abc", "pqr");
		employee.add(100, "abc", "pqr");
		employee.add(1, "abc", "pqr");
		employee.add(121, "abc", "pqr");
		employee.add(111, "abc", "pqr");

		List<Employee> expected = new ArrayList<Employee>();
		expected.add(new Employee(1, "abc", "pqr"));
		expected.add(new Employee(100, "abc", "pqr"));
		expected.add(new Employee(101, "abc", "pqr"));
		expected.add(new Employee(111, "abc", "pqr"));
		expected.add(new Employee(121, "abc", "pqr"));

		employee.naturalSort();
		assertEquals(expected, employee.display());

	}

	@Test
	public void testNaturalSortDecendingOrder() {
		EmployeeMain employee = new EmployeeMain();
		employee.add(121, "abc", "pqr");
		employee.add(111, "abc", "pqr");
		employee.add(101, "abc", "pqr");
		employee.add(100, "abc", "pqr");
		employee.add(1, "abc", "pqr");

		List<Employee> expected = new ArrayList<Employee>();
		expected.add(new Employee(1, "abc", "pqr"));
		expected.add(new Employee(100, "abc", "pqr"));
		expected.add(new Employee(101, "abc", "pqr"));
		expected.add(new Employee(111, "abc", "pqr"));
		expected.add(new Employee(121, "abc", "pqr"));

		employee.naturalSort();
		assertEquals(expected, employee.display());

	}

	@Test
	public void testSortByNameMixedOrder() {
		EmployeeMain employee = new EmployeeMain();
		employee.add(101, "b", "pqr");
		employee.add(100, "a", "pqr");
		employee.add(1, "e", "pqr");
		employee.add(121, "abc", "pqr");
		employee.add(111, "r", "pqr");

		List<Employee> expected = new ArrayList<Employee>();
		expected.add(new Employee(100, "a", "pqr"));
		expected.add(new Employee(121, "abc", "pqr"));
		expected.add(new Employee(101, "b", "pqr"));
		expected.add(new Employee(1, "e", "pqr"));
		expected.add(new Employee(111, "r", "pqr"));

		employee.sortByName();
		assertEquals(expected, employee.display());

	}

	@Test
	public void testSortByNameDecendingOrder() {
		EmployeeMain employee = new EmployeeMain();
		employee.add(111, "r", "pqr");
		employee.add(1, "e", "pqr");
		employee.add(101, "b", "pqr");
		employee.add(121, "abc", "pqr");
		employee.add(100, "a", "pqr");
		List<Employee> expected = new ArrayList<Employee>();
		expected.add(new Employee(100, "a", "pqr"));
		expected.add(new Employee(121, "abc", "pqr"));
		expected.add(new Employee(101, "b", "pqr"));
		expected.add(new Employee(1, "e", "pqr"));
		expected.add(new Employee(111, "r", "pqr"));

		employee.sortByName();
		assertEquals(expected, employee.display());

	}

}
