package dbmain;

import java.util.List;

import dbHelper.DbHelperClass;
import pOJOClasses.Authors;
import pOJOClasses.Members;
import pOJOClasses.Title;

public class DbMainClass {

	public static List<Title> getListOfBooks(Authors authors) {

		return DbHelperClass
				.getListOfBookByAuthorName(authors.getAuthor_name());
	}

	public static boolean isInsertedProperly(Title title, Members member) {
		return DbHelperClass.isInsertedProperly(title.getTitle_name(),
				member.getMember_id());
	}

	public static int getNoOfDeleatedRows() {

		return DbHelperClass.getNoOfDeleatedRow();
	}
}
