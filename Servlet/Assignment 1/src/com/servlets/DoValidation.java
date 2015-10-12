package com.servlets;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public  class DoValidation extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse respond)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		PrintWriter out = respond.getWriter();

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

		if (error.equals("")) {
			out.println("All inputes are validate and correct");
		} else {
			out.println(error);

		}

	}
}