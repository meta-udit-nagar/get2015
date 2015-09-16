import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import pOJOClasses.Title;
import queryPackage.QueryClass;

public class TestQueryClass {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testGetNoOfDeleatedRow() {
		// there was 1 row matching the condition
		QueryClass.initConnection();
		QueryClass.setAutocommit(false);
		int expected = 1;
		assertEquals(expected, QueryClass.getNoOfDeleatedRow());
		QueryClass.rollback();
		QueryClass.closeConnection();
	}

	@Test
	public void testIsInsertedProperlyTrue() {
		// inserted properly
		QueryClass.initConnection();
		QueryClass.setAutocommit(false);
		assertTrue(QueryClass.isInsertedProperly("a", 1001));
		QueryClass.rollback();
		QueryClass.closeConnection();
	}

	@Test
	public void testIsInsertedProperlyNullAccessionNo() {
		// Not Inserted-null accession no-no book present with title_name c
		QueryClass.initConnection();
		QueryClass.setAutocommit(false);
		assertFalse(QueryClass.isInsertedProperly("d", 1003));
		QueryClass.rollback();
		QueryClass.closeConnection();
	}

	@Test
	public void testIsInsertedProperlyWrongMemberId() {
		// Not Inserted-Voilating forign key constraint
		QueryClass.initConnection();
		QueryClass.setAutocommit(false);
		assertFalse(QueryClass.isInsertedProperly("a", 2003));
		QueryClass.rollback();
		QueryClass.closeConnection();
	}

	@Test
	public void testGetListOfBooksByAuthorName() {
		ArrayList<Title> expectedListOfTitles = new ArrayList<Title>();
		expectedListOfTitles.add(new Title(1202, "a", 701, 2));
		QueryClass.initConnection();
		QueryClass.setAutocommit(false);
		assertEquals(expectedListOfTitles,
				QueryClass.getListOfBookByAuthorName("yashwant kanitkar"));
		QueryClass.rollback();
		QueryClass.closeConnection();
	}

}
