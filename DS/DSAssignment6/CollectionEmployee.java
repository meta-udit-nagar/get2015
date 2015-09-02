import java.util.HashSet;
import java.util.Set;

public class CollectionEmployee {

	private Set<Employee> Employees = new HashSet<Employee>();

	public boolean addEmployee(Integer employeeId, String address, String name) {
		int beforeSize = Employees.size();
		Employees.add(new Employee(employeeId, name, address));
		int afterSise = Employees.size();
		if (beforeSize == afterSise) {

			return false;
		}

		return true;

	}

}
