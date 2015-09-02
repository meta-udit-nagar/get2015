import java.util.Comparator;

public class Employee implements Comparable {

	private Integer employeeId;
	private String name;
	private String address;

	public Employee(Integer employeeId, String name, String address) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}

	@Override
	public int compareTo(Object o) {
		Employee employeeNaturalOrder = (Employee) o;
		return getEmployeeId().compareTo(employeeNaturalOrder.getEmployeeId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((employeeId == null) ? 0 : employeeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		return true;
	}

	static class NameComparator implements Comparator {

		@Override
		public int compare(Object o1, Object o2) {
			Employee e1 = (Employee) o1;
			Employee e2 = (Employee) o2;
			return e1.getName().compareTo(e2.getName());
		}

	}

}
