package designpattern1qn2;

import org.junit.Test;

public class EngineerFactoryTest {

	@Test
	public void testCreateEnginnerDeveloper() {
		EngineerFactory engineerFactory = new EngineerFactory();
		assert (engineerFactory.createEnginner("developer") instanceof Developer);

	}

	@Test
	public void testCreateEnginnerTester() {
		EngineerFactory engineerFactory = new EngineerFactory();
		assert (engineerFactory.createEnginner("tester") instanceof Tester);

	}

}
