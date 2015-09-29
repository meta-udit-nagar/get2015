import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import dbHelper.DbHelperClass;
import dbmain.DbMainClass;
import pOJOClasses.Authors;
import pOJOClasses.Members;
import pOJOClasses.Title;

public class TestDbMainClass {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testGetNoOfDeleatedRow() {
		// there was 3 row matching the condition

		DbHelperClass.initConnection();
		DbHelperClass.setAutocommit(false);
		int expected = 3;
		assertEquals(expected, DbMainClass.getNoOfDeleatedRows());
		DbHelperClass.rollback();
		DbHelperClass.closeConnection();
	}

	@Test
	public void testIsInsertedProperlyTrue() {
		// inserted properly
		Title title = new Title();
		title.setTitle_name("a");
		Members members = new Members();
		members.setMember_id(1001);
		DbHelperClass.initConnection();
		DbHelperClass.setAutocommit(false);
		assertTrue(DbMainClass.isInsertedProperly(title, members));
		DbHelperClass.rollback();
		DbHelperClass.closeConnection();
	}

	@Test
	public void testIsInsertedProperlyNullAccessionNo() {
		// Not Inserted-null accession no-no book present with title_name c
		Title title = new Title();
		title.setTitle_name("d");
		Members members = new Members();
		members.setMember_id(1003);
		DbHelperClass.initConnection();
		DbHelperClass.setAutocommit(false);
		assertFalse(DbMainClass.isInsertedProperly(title, members));
		DbHelperClass.rollback();
		DbHelperClass.closeConnection();
	}

	@Test
	public void testIsInsertedProperlyWrongMemberId() {
		// Not Inserted-Voilating forign key constraint
		Title title = new Title();
		title.setTitle_name("a");
		Members members = new Members();
		members.setMember_id(2003);
		DbHelperClass.initConnection();
		DbHelperClass.setAutocommit(false);
		assertFalse(DbMainClass.isInsertedProperly(title, members));
		DbHelperClass.rollback();
		DbHelperClass.closeConnection();
	}

	@Test
	public void testGetListOfBooksByAuthorName() {
		ArrayList<Title> expectedListOfTitles = new ArrayList<Title>();
		expectedListOfTitles.add(new Title(1202, "a", 701, 2));
		Authors authors = new Authors();
		authors.setAuthor_name("yashwant kanitkar");
		DbHelperClass.initConnection();
		DbHelperClass.setAutocommit(false);
		assertEquals(expectedListOfTitles, DbMainClass.getListOfBooks(authors));
		DbHelperClass.rollback();
		DbHelperClass.closeConnection();
	}

}
