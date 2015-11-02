package com.employee.facade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.employee.db.EmployeeDao;
import com.employee.exception.EmployeeSystemException;
import com.employee.model.Employee;

public class EmployeeFacade {

	public void create(String name, String email, Connection connection)
			throws EmployeeSystemException, SQLException {
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.create(name, email, connection);
	}

	public Employee retrieveById(int id, Connection connection)
			throws EmployeeSystemException, SQLException {
		EmployeeDao employeeDao = new EmployeeDao();
		Employee employee = employeeDao.retrieveById(id, connection);
		return employee;
	}

	public List<Employee> retrieveAllByName(String name, Connection connection)
			throws EmployeeSystemException, SQLException {
		EmployeeDao employeeDao = new EmployeeDao();
		List<Employee> employees = employeeDao.retrieveAllByName(name,
				connection);
		return employees;
	}

	public List<Employee> retrieveAll(Connection connection)
			throws EmployeeSystemException, SQLException {
		EmployeeDao employeeDao = new EmployeeDao();
		List<Employee> employees = employeeDao.retrieveAll(connection);
		return employees;
	}

	public void deleteById(int id, Connection connection)
			throws EmployeeSystemException, SQLException {
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.deleteById(id, connection);
	}
}
