import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class BinaryToOctalTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	

	
	@Test
	
	public void binaryToOctalTest() {
		int n=1011;
		int nCopy=n;
		int lastDigit;
			while(nCopy!=0)
			{
				lastDigit=nCopy%10;
				if(lastDigit>1)
				{
					
					fail("error");
				}
				nCopy=nCopy/10;
				
			}
			System.out.print(""+BinaryToOctal.convertBinaryToOctal(n));
		assertEquals(13, BinaryToOctal.convertBinaryToOctal(n));
				
		 n=0000;
		 nCopy=n;
		
			while(nCopy!=0)
			{
				lastDigit=nCopy%10;
				if(lastDigit>1)
				{
					
					fail("error");
				}
				nCopy=nCopy/10;
				
			}
		assertEquals(0, BinaryToOctal.convertBinaryToOctal(n));
	      n=111;
		  nCopy=n;
	
			while(nCopy!=0)
			{
				lastDigit=nCopy%10;
				if(lastDigit>1)
				{
					
					fail("error");
				}
				nCopy=nCopy/10;
				
			}
		assertEquals(7, BinaryToOctal.convertBinaryToOctal(n));
		
	}

}
