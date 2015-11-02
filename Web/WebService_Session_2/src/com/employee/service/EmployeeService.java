package com.employee.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.employee.db.ConnectionFactory;
import com.employee.exception.EmployeeSystemException;
import com.employee.facade.EmployeeFacade;
import com.employee.model.Employee;

public class EmployeeService {

	public void create(String name, String email)
			throws EmployeeSystemException {
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();

		} catch (EmployeeSystemException e) {
			System.out.println("Coult not create connection with database ["
					+ e.getMessage() + "]");
			throw new EmployeeSystemException(
					"Coult not create connection with database ["
							+ e.getMessage() + "]", e);
		}
		EmployeeFacade employeeFacade = new EmployeeFacade();

		try {
			employeeFacade.create(name, email, connection);

			try {
				connection.commit();
			} catch (SQLException e) {
				System.out.println("Coult not commit the transaction, ["
						+ e.getMessage() + "]");
				throw new EmployeeSystemException(
						"Coult not commit the transaction, [" + e.getMessage()
								+ "]", e);
			}
		} catch (Exception e) {
			try {
				System.out.println("could not create a new employee,["
						+ e.getMessage() + "]");
				connection.rollback();
				System.out.println("Transaction roll back");
				throw new EmployeeSystemException(
						"could not create a new employee,Transaction roll back,["
								+ e.getMessage() + "]", e);
			} catch (SQLException e1) {
				System.out.println("Error in Transaction roll back,["
						+ e1.getMessage() + "]");
				throw new EmployeeSystemException(
						"Error in  Transaction roll back,[" + e1.getMessage()
								+ "]", e);
			}
		} finally {
			ConnectionFactory.closeConnection(connection);
		}

	}

	public Employee retrieveById(int id) throws EmployeeSystemException {
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();

		} catch (EmployeeSystemException e) {
			System.out.println("Coult not create connection with database ["
					+ e.getMessage() + "]");
			throw new EmployeeSystemException(
					"Coult not create connection with database ["
							+ e.getMessage() + "]", e);
		}
		EmployeeFacade employeeFacade = new EmployeeFacade();
		Employee employee = new Employee();
		try {
			employee = employeeFacade.retrieveById(id, connection);

			try {
				connection.commit();
			} catch (SQLException e) {
				System.out.println("Coult not commit the transaction, ["
						+ e.getMessage() + "]");
				throw new EmployeeSystemException(
						"Coult not commit the transaction, [" + e.getMessage()
								+ "]", e);
			}
		} catch (Exception e) {
			try {
				System.out.println("could not get employee by name,["
						+ e.getMessage() + "]");
				connection.rollback();
				System.out.println("Transaction roll back");
				throw new EmployeeSystemException(
						"could not get employee by name,Transaction roll back,["
								+ e.getMessage() + "]", e);
			} catch (SQLException e1) {
				System.out.println("Error in Transaction roll back,["
						+ e1.getMessage() + "]");
				throw new EmployeeSystemException(
						"Error in  Transaction roll back,[" + e1.getMessage()
								+ "]", e);
			}
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		return employee;
	}

	public List<Employee> retrieveAllByName(String name)
			throws EmployeeSystemException {
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();

		} catch (EmployeeSystemException e) {
			System.out.println("Coult not create connection with database ["
					+ e.getMessage() + "]");
			throw new EmployeeSystemException(
					"Coult not create connection with database ["
							+ e.getMessage() + "]", e);
		}
		EmployeeFacade employeeFacade = new EmployeeFacade();
		List<Employee> employees;
		try {
			employees = employeeFacade.retrieveAllByName(name, connection);

			try {
				connection.commit();
			} catch (SQLException e) {
				System.out.println("Coult not commit the transaction, ["
						+ e.getMessage() + "]");
				throw new EmployeeSystemException(
						"Coult not commit the transaction, [" + e.getMessage()
								+ "]", e);
			}
		} catch (Exception e) {
			try {
				System.out.println("could not get employee by name,["
						+ e.getMessage() + "]");
				connection.rollback();
				System.out.println("Transaction roll back");
				throw new EmployeeSystemException(
						"could not get employee by name,Transaction roll back,["
								+ e.getMessage() + "]", e);
			} catch (SQLException e1) {
				System.out.println("Error in Transaction roll back,["
						+ e1.getMessage() + "]");
				throw new EmployeeSystemException(
						"Error in  Transaction roll back,[" + e1.getMessage()
								+ "]", e);
			}
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		return employees;
	}

	public List<Employee> retrieveAll() throws EmployeeSystemException {
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();

		} catch (EmployeeSystemException e) {
			System.out.println("Coult not create connection with database ["
					+ e.getMessage() + "]");
			throw new EmployeeSystemException(
					"Coult not create connection with database ["
							+ e.getMessage() + "]", e);
		}
		EmployeeFacade employeeFacade = new EmployeeFacade();
		List<Employee> employees;
		try {
			employees = employeeFacade.retrieveAll(connection);

			try {
				connection.commit();
			} catch (SQLException e) {
				System.out.println("Coult not commit the transaction, ["
						+ e.getMessage() + "]");
				throw new EmployeeSystemException(
						"Coult not commit the transaction, [" + e.getMessage()
								+ "]", e);
			}
		} catch (Exception e) {
			try {
				System.out.println("could not get all employees,["
						+ e.getMessage() + "]");
				connection.rollback();
				System.out.println("Transaction roll back");
				throw new EmployeeSystemException(
						"could not get all employees,Transaction roll back,["
								+ e.getMessage() + "]", e);
			} catch (SQLException e1) {
				System.out.println("Error in Transaction roll back,["
						+ e1.getMessage() + "]");
				throw new EmployeeSystemException(
						"Error in  Transaction roll back,[" + e1.getMessage()
								+ "]", e);
			}
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		return employees;
	}

	public void deleteById(int id) throws EmployeeSystemException {
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();

		} catch (EmployeeSystemException e) {
			System.out.println("Coult not create connection with database ["
					+ e.getMessage() + "]");
			throw new EmployeeSystemException(
					"Coult not create connection with database ["
							+ e.getMessage() + "]", e);
		}
		EmployeeFacade employeeFacade = new EmployeeFacade();

		try {
			employeeFacade.deleteById(id, connection);

			try {
				connection.commit();
			} catch (SQLException e) {
				System.out.println("Coult not commit the transaction, ["
						+ e.getMessage() + "]");
				throw new EmployeeSystemException(
						"Coult not commit the transaction, [" + e.getMessage()
								+ "]", e);
			}
		} catch (Exception e) {
			try {
				System.out.println("could not delete an employee by id,["
						+ e.getMessage() + "]");
				connection.rollback();
				System.out.println("Transaction roll back");
				throw new EmployeeSystemException(
						"could not delete an employee by id,Transaction roll back,["
								+ e.getMessage() + "]", e);
			} catch (SQLException e1) {
				System.out.println("Error in Transaction roll back,["
						+ e1.getMessage() + "]");
				throw new EmployeeSystemException(
						"Error in  Transaction roll back,[" + e1.getMessage()
								+ "]", e);
			}
		} finally {
			ConnectionFactory.closeConnection(connection);
		}

	}
}
