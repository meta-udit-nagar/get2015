package com.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.ConnectionUtil;
import com.model.User;

public class UserHelper {

	public static boolean addUser(User user) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		ConnectionUtil util = new ConnectionUtil();
		con = util.getConnection();

		String query = "INSERT INTO tbl_user(username,password,email) VALUES(?,?,?)";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			result = ps.executeUpdate();

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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result > 0)
			return true;
		else
			return false;

	}

	public static boolean isValidUser(User user) {
		boolean result = false;
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		ConnectionUtil util = new ConnectionUtil();
		con = util.getConnection();

		String query = "SELECT email,password FROM tbl_user WHERE email=? and password=?";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();

			if (rs.next()) {
				result = true;
			}
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

}
