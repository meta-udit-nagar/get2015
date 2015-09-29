package dbHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConnectionUtil;
import pOJOClasses.Title;

public class DbHelperClass {

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static PreparedStatement psUpdate = null;

	public static void setAutocommit(boolean autoCommit) {

		try {
			con.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initConnection() {
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
	}

	public static void rollback() {

		try {
			con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void closeConnection() {

		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (psUpdate != null) {
			try {
				psUpdate.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static ArrayList<Title> getListOfBookByAuthorName(String author_name) {
		ArrayList<Title> listOfTitles = new ArrayList<Title>();
		String query = "select t.* from title t,title_author ta, author a where t.title_id=ta.title_id and ta.author_id=a.author_id and a.author_name=?";

		try {
			ps = con.prepareStatement(query);
			ps.setString(1, author_name);
			System.out.println(ps.execute());
			rs = ps.executeQuery();

			while (rs.next()) {
				Title title = new Title();
				title.setTitle_id(rs.getInt("title_id"));
				title.setSubject_id(rs.getInt("subject_id"));
				title.setPublisher_id(rs.getInt("publisher_id"));
				title.setTitle_name(rs.getString("title_name"));
				listOfTitles.add(title);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfTitles;
	}

	static public boolean isInsertedProperly(String title_name, int member_id) {
		int result = 0;
		String query = "insert into book_issue values(now(),(select b.accession_no from books b,title t where b.title_id=t.title_id an"
				+ "d title_name=? and status=1 limit 1),?,now()+interval 15 day)";
		String updateQuery = "update books b set status=0 where b.accession_no =(Select bi.accession_no from book_issue bi where bi.member_id=? order by issue_date desc limit 1) and status= 1";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, title_name);
			ps.setInt(2, member_id);
			result = ps.executeUpdate();

			if (result > 0) {
				psUpdate = con.prepareStatement(updateQuery);
				psUpdate.setInt(1, member_id);
				psUpdate.executeUpdate();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result > 0)
			return true;
		else
			return false;

	}

	static public int getNoOfDeleatedRow() {
		int result = 0;
		String query = "delete from books where accession_no in(select bi.accession_no from "
				+ "book_issue bi where datediff(now(),bi.issue_date)>365) or accession_no "
				+ "not in(Select distinct accession_no from book_issue)";

		try {
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
