package com.employee.controller;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.employee.exception.EmployeeSystemException;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@Path("/employeeWebController")
public class EmployeeWebController {

	@GET
	@Path("/create/{name}/{email}")
	public void create(@PathParam("name") String name,
			@PathParam("email") String email) {

		EmployeeService employeeService = new EmployeeService();
		try {
			employeeService.create(name, email);
		} catch (EmployeeSystemException e) {
			// TODO Auto-generated catch block
			System.out.println("[" + e.getMessage() + "]");
		}
	}

	@GET
	@Path("/getById/{id : \\d+}")
	@Produces("application/xml")
	public String retrieveById(@PathParam("id") int id) {
		EmployeeService employeeService = new EmployeeService();
		Employee employee = null;
		String result = null;
		try {
			employee = employeeService.retrieveById(id);
			result = "<employee><employeeId>" + employee.getId()
					+ "</employeeId>" + "<employeeName>" + employee.getName()
					+ "</employeeName>" + "<employeeEmail>"
					+ employee.getEmail() + "</employeeEmail></employee>";
		} catch (EmployeeSystemException e) {
			// TODO Auto-generated catch block
			System.out.println("[" + e.getMessage() + "]");
		}
		return result;
	}

	@GET
	@Path("/getByName/{name}")
	@Produces("application/xml")
	public String retrieveAllByName(@PathParam("name") String name) {
		System.out.println("name");
		EmployeeService employeeService = new EmployeeService();
		List<Employee> employees = null;
		String result = null;
		try {
			employees = employeeService.retrieveAllByName(name);
			result = "<employee-list>";
			for (int i = 0; i < employees.size(); i++) {
				Employee employee = new Employee();
				employee = employees.get(i);
				result = result + "<employee><employeeId>" + employee.getId()
						+ "</employeeId>" + "<employeeName>"
						+ employee.getName() + "</employeeName>"
						+ "<employeeEmail>" + employee.getEmail()
						+ "</employeeEmail></employee>";
			}
			result = result + "</employee-list>";
		} catch (EmployeeSystemException e) {
			// TODO Auto-generated catch block
			System.out.println("[" + e.getMessage() + "]");
		}
		return result;
	}

	@GET
	@Path("/retrieveAll")
	@Produces("application/xml")
	public String retrieveAll() {
		EmployeeService employeeService = new EmployeeService();
		List<Employee> employees = null;
		String result = null;
		try {
			employees = employeeService.retrieveAll();
			result = "<employee-list>";
			for (int i = 0; i < employees.size(); i++) {
				Employee employee = new Employee();
				employee = employees.get(i);
				result = result + "<employee><employeeId>" + employee.getId()
						+ "</employeeId>" + "<employeeName>"
						+ employee.getName() + "</employeeName>"
						+ "<employeeEmail>" + employee.getEmail()
						+ "</employeeEmail></employee>";
			}
			result = result + "</employee-list>";
		} catch (EmployeeSystemException e) {
			// TODO Auto-generated catch block
			System.out.println("[" + e.getMessage() + "]");
		}
		return result;
	}

	@GET
	@Path("/deleteById/{id}")
	public void deleteById(@PathParam("id") int id) {

		EmployeeService employeeService = new EmployeeService();
		try {
			employeeService.deleteById(id);
		} catch (EmployeeSystemException e) {
			// TODO Auto-generated catch block
			System.out.println("[" + e.getMessage() + "]");
		}
	}
}
