import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeMain {
	private List<Employee> employeeList = new ArrayList<Employee>();

	public void add(Integer employeeId, String name, String address) {
		Employee employee = new Employee(employeeId, name, address);
		employeeList.add(employee);

	}

	public List<Employee> display() {
		return employeeList;

	}

	public void naturalSort() {
		Collections.sort(employeeList);

	}

	public void sortByName() {
		Collections.sort(employeeList, new Employee.NameComparator());
	}

}
