package com.model;

public class Employee {
	private int employeeId;
	private String name;
	private String email;
	private int age;
	private String dateOfRegistration;

	
	
	
	
	public Employee(int employeeId, String name, String email, int age,
			String dateOfRegistration) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
		this.age = age;
		this.dateOfRegistration = dateOfRegistration;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

}
