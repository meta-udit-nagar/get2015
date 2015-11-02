package com.employee.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import com.employee.exception.EmployeeSystemException;
import com.employee.model.Employee;

public class EmployeeDao {

	public void create(String name, String email, Connection connection)
			throws EmployeeSystemException, SQLException {
		String query = "insert into employee (name,email) values (?,?)";

		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);

			preparedStatement.executeUpdate();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

			} catch (SQLException e) {
				System.out.println("[" + e.getMessage() + "]");
				throw new EmployeeSystemException("[" + e.getMessage() + "]", e);
			}
		}
	}

	public Employee retrieveById(int id, Connection connection)
			throws SQLException, EmployeeSystemException {
		String query = "select * from employee where id=?";
		Employee employee = new Employee();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");

				employee.setId(id);
				employee.setName(name);
				employee.setEmail(email);
			}
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e) {
				System.out.println("[" + e.getMessage() + "]");
				throw new EmployeeSystemException("[" + e.getMessage() + "]", e);
			}
		}
		return employee;
	}

	public List<Employee> retrieveAllByName(String name,
			Connection connection) throws SQLException, EmployeeSystemException {
		String query = "select * from employee where name=?";
		List<Employee> employees = new ArrayList<Employee>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, name);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String empName = resultSet.getString("name");
				String email = resultSet.getString("email");
				int id = resultSet.getInt("id");
				Employee employee = new Employee();
				employee.setId(id);
				employee.setName(empName);
				employee.setEmail(email);
				employees.add(employee);
			}
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e) {
				System.out.println("[" + e.getMessage() + "]");
				throw new EmployeeSystemException("[" + e.getMessage() + "]", e);
			}
		}
		return employees;
	}

	public List<Employee> retrieveAll(Connection connection)
			throws SQLException, EmployeeSystemException {
		String query = "select * from employee";
		List<Employee> employees = new ArrayList<Employee>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(query);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String empName = resultSet.getString("name");
				String email = resultSet.getString("email");
				int id = resultSet.getInt("id");
				Employee employee = new Employee();
				employee.setId(id);
				employee.setName(empName);
				employee.setEmail(email);
				employees.add(employee);
			}
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e) {
				System.out.println("[" + e.getMessage() + "]");
				throw new EmployeeSystemException("[" + e.getMessage() + "]", e);
			}
		}
		return employees;
	}

	public void deleteById(int id, Connection connection)
			throws SQLException, EmployeeSystemException {
		String query = "delete from employee where id=?";
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();

		} finally {
			try {

				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e) {
				System.out.println("[" + e.getMessage() + "]");
				throw new EmployeeSystemException("[" + e.getMessage() + "]", e);
			}
		}

	}

}
