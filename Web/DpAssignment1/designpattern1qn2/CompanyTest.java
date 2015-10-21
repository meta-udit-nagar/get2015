package designpattern1qn2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CompanyTest {

	@Test
	public void testGetList() {
		Company company = Company.getInstance();
		EngineerFactory factory = new EngineerFactory();
		IEngineer engineer = factory.createEnginner("developer");
		engineer.setName("udit");
		engineer.setRole("abc");
		company.add(engineer);
		engineer = factory.createEnginner("tester");
		engineer.setName("udit");
		engineer.setRole("xyz");
		company.add(engineer);

		List<IEngineer> requiredList = new ArrayList<IEngineer>();
		engineer = new Developer();
		engineer.setName("udit");
		engineer.setRole("abc");
		requiredList.add(engineer);

		engineer = new Tester();
		engineer.setName("udit");
		engineer.setRole("xyz");
		requiredList.add(engineer);

		assertEquals(requiredList, company.getList());

	}

}
