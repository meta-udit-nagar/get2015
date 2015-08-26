import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


public class InfixToPostfixTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testdoTranse() {
		String input="a+b";
		String expected="ab+";
	InfixToPostfix infixToPostfix= new InfixToPostfix(input);
	assertEquals(expected, infixToPostfix.doTrans());
	
	     input="a+b+c+d";
	     expected="ab+c+d+";
	     InfixToPostfix infixToPostfix1= new InfixToPostfix(input);
	 	assertEquals(expected, infixToPostfix1.doTrans());		 
	
	}

}
