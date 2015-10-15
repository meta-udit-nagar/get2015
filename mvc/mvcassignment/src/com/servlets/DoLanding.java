package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import com.helper.EmployeeHelper;

/**
 * Servlet implementation class DoLanding
 */
public class DoLanding extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoLanding() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeHelper.loadEmployee();
		String text = "Metacube is a software engineering services company that has deep experience in"
				+ " developing enterprise level products and applications for a wide spectrum of domains including global trade management, "
				+ "supply chain analytics, manufacturing analytics, "
				+ "business continuity planning, CRM, publishing and eCommerce."
				+ " These applications have been developed on a variety of platforms."
				+ " The common denominator in all our services has been our total customer focus,"
				+ " ensuring that each engagement is a success and provides the desired value to the customer.";
		request.setAttribute("content", text);
		PrintWriter out = response.getWriter();
		out.println("hello");
		request.getRequestDispatcher("jsp/landingPage.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
