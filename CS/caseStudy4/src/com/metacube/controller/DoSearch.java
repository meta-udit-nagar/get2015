package com.metacube.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.MetaException;
import com.metacube.db.helper.VehicleDbHelper;
import com.metacube.model.Vehicle;

/**
 * Servlet implementation class DoSearch
 */
@WebServlet("/DoSearch")
public class DoSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoSearch() {
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

		String url = "view/search.jsp";
		HttpSession session = request.getSession();
		try {
			session.setAttribute("listOfMake",
					VehicleDbHelper.getDistinctMake());
		} catch (MetaException e) {
			url = "view/homepage.jsp";
			System.out.println("error in search Dosearch");
		}

		response.sendRedirect(url);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "view/searchresult.jsp";
		String make = request.getParameter("make");
		Vehicle vehicle = new Vehicle();
		vehicle.setMake(make);

		HttpSession session = request.getSession();
		try {
			session.setAttribute("listofVehicle",
					VehicleDbHelper.getVehicleMake(vehicle));
		} catch (MetaException e) {

			System.out.println("error in DoSearch doPost servlet");
			url = "view/search.jsp";

		}

		response.sendRedirect(url);
	}

}
