import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MatrixTest {

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

	Matrix matrix = new Matrix(4, 4);

	@Test
	public void testAddElements1() {

		matrix.addElements(1, 1, 2);
		assertEquals(2, matrix.data[1][1]);
	}

	@Test
	public void testAddElements2() {
		matrix.addElements(0, 0, 5);
		assertEquals(5, matrix.data[0][0]);

	}

	@Test
	public void testAddElements3() {
		matrix.addElements(0, 1, -4);
		assertEquals(-4, matrix.data[0][1]);

	}

	public static boolean isArrayEqual(int expected[][], int output[][]) {
		boolean b = true;
		int loopCount1;
		int loopCount2;
		for (loopCount1 = 0; loopCount1 < output.length; loopCount1++) {
			for (loopCount2 = 0; loopCount2 < output[0].length; loopCount2++) {
				if (expected[loopCount1][loopCount2] != output[loopCount1][loopCount2])
					return false;
			}
		}
		return b;
	}

	@Test
	public void testTranspose() {
		Matrix matrix = new Matrix(2, 2);
		matrix.addElements(0, 0, 1);
		matrix.addElements(0, 1, 2);
		matrix.addElements(1, 0, 3);
		matrix.addElements(1, 1, 4);
		Matrix m = new Matrix(2, 2);
		m = matrix.transpose();
		Matrix expected = new Matrix(2, 2);
		expected.addElements(0, 0, 1);
		expected.addElements(0, 1, 3);
		expected.addElements(1, 0, 2);
		expected.addElements(1, 1, 4);

		assertEquals(true, MatrixTest.isArrayEqual(expected.data, m.data));

	}

	public void testTranspose2() {
		Matrix matrix = new Matrix(1, 1);
		matrix.addElements(0, 0, 1);

		Matrix m = new Matrix(1, 1);
		m = matrix.transpose();
		Matrix expected = new Matrix(1, 1);
		expected.addElements(0, 0, 1);

		assertEquals(true, MatrixTest.isArrayEqual(expected.data, m.data));

	}

	public void testTranspose3() {
		Matrix matrix = new Matrix(3, 3);
		matrix.addElements(0, 0, 1);
		matrix.addElements(0, 1, 2);
		matrix.addElements(0, 2, 3);
		matrix.addElements(1, 0, 4);
		matrix.addElements(1, 1, 5);
		matrix.addElements(1, 2, 6);
		matrix.addElements(2, 0, 7);
		matrix.addElements(2, 1, 8);
		matrix.addElements(2, 2, 9);

		Matrix m = new Matrix(3, 3);
		m = matrix.transpose();
		Matrix expected = new Matrix(3, 3);
		expected.addElements(0, 0, 1);
		expected.addElements(0, 1, 4);
		expected.addElements(0, 2, 7);
		expected.addElements(1, 0, 2);
		expected.addElements(1, 1, 5);
		expected.addElements(1, 2, 8);
		expected.addElements(2, 0, 3);
		expected.addElements(2, 1, 6);
		expected.addElements(2, 2, 9);

		assertEquals(true, MatrixTest.isArrayEqual(expected.data, m.data));

	}

}
