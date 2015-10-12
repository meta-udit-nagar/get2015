package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DoGetInput extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String dob = request.getParameter("dob");
	String password = request.getParameter("password");
	String confirmPassword = request.getParameter("confirmPassword");

	PrintWriter out = response.getWriter();

	String error = "";

	if (name == null || name == "")
		error += "name field can't be empty\n";

	if (email == null || email == "")
		error += "email field can't be empty\n";

	if (dob == null || dob == "")
		error += "dob field can't be empty\n";

	if (password == null || password == "")
		error += "password field can't be empty\n";

	if (confirmPassword == null || confirmPassword == "")
		error += "confirmPassword field can't be empty\n";

	if (!(password.equals(confirmPassword))) {
		error += "password and confirmPassword does not matches";
	}
    System.out.println(error);
	request.setAttribute("error", error);
	request.getRequestDispatcher("DoShowOutput").forward(request, response);
	
	}

}
