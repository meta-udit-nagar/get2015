import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class CheckFrequencyTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testCheckFrequencyAllUniqueCharacter() {
		CheckFrequency checkFrequency = new CheckFrequency();
		assertEquals(4, checkFrequency.checkFrequency("udit"));
	}

	@Test
	public void testCheckFrequencyAllSameCharacter() {
		CheckFrequency checkFrequency = new CheckFrequency();
		assertEquals(1, checkFrequency.checkFrequency("aaaaa"));
	}

	@Test
	public void testCheckFrequencyMixedCharacter() {
		CheckFrequency checkFrequency = new CheckFrequency();
		assertEquals(5, checkFrequency.checkFrequency("abacdf"));
	}

}
