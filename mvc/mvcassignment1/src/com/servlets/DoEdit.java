package com.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helper.EmployeeHelper;
import com.model.Employee;

/**
 * Servlet implementation class DoEdit
 */
public class DoEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Employee employee=EmployeeHelper.getEmployee(id);
		int employId=Integer.parseInt(request.getParameter("employId"));
		 String name= request.getParameter("name");
		 String email=request.getParameter("email");
		 int age=Integer.parseInt(request.getParameter("age"));
		 //String date=request.getParameter("date");
         employee.setAge(age);
         employee.setEmail(email);
         employee.setName(name);
         employee.setEmployeeId(employId);
         
		 EmployeeHelper.edit(employee, id);
		 request.getRequestDispatcher("/ShowList").forward(request, response);
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doGet(request, response);
	}

}
