package com.metacube.db.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.MetaException;
import com.metacube.db.ConnectionFactory;
import com.metacube.model.Admin;

public class AdminDbHelper {

	private static String query_valid_admin = "SELECT username,password FROM tbl_admin WHERE username=? and password=?";

	public static boolean isValidAdmin(Connection con, Admin admin)
			throws MetaException {
		boolean result = false;
		ResultSet rs = null;
		PreparedStatement ps = null;

		con = ConnectionFactory.getConnection();

		if (con != null) {
			try {
				ps = con.prepareStatement(query_valid_admin);
				ps.setString(1, admin.getUsername());
				ps.setString(2, admin.getPassword());
				rs = ps.executeQuery();
				con.commit();

				if (rs.next()) {
					result = true;
				}
			} catch (SQLException e) {
				try {
					con.rollback();
				} catch (SQLException e1) {

					System.out.println("could not rol back");
				}
				throw new MetaException("could not login " + e.getMessage());
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					System.out.println("error in connection closing");
				}
			}
		}
		return result;
	}
}
