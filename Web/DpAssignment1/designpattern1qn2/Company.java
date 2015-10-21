package designpattern1qn2;

import java.util.ArrayList;
import java.util.List;

public class Company {

	private static Company company;
	private List<IEngineer> listOfEmgineer = new ArrayList<IEngineer>();

	private Company() {
	}

	public static Company getInstance() {
		if (company == null) {
			company = new Company();
		}

		return company;
	}

	public void add(IEngineer engineer) {

		listOfEmgineer.add(engineer);
	}

	public List<IEngineer> getList() {
		return listOfEmgineer;
	}

}
