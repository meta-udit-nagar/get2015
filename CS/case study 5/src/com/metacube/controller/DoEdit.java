package com.metacube.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.MetaException;
import com.metacube.model.Car;
import com.metacube.service.CarDekhoService;

/**
 * Servlet implementation class DoEdit
 */
@WebServlet("/DoEdit")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "view/edit.jsp";
		int vehicle_id = Integer.parseInt(request.getParameter("id"));
		Car car = new Car();
		car.setVehicle_id(vehicle_id);
         CarDekhoService service= new CarDekhoService();
		HttpSession session = request.getSession();
		try {
			session.setAttribute("car", service.getVehicleId(car));
			session.setAttribute("vehicle_id", vehicle_id);
		} catch (MetaException e) {
			System.out.println("error in doget.DoEdit servlet");

			url = "view/searchresult.jsp";
		}
		response.sendRedirect(url);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String forwardUrl = "view/loggedin.jsp";
			Car car = editCar(request);
			CarDekhoService service= new CarDekhoService();
			try {
	            service.edit(car);
				request.setAttribute("message", "Edited Successfully");
			} catch (MetaException e) {
				System.out.println("Exception while editing car " + e.getMessage());
				forwardUrl = "view/create.jsp";
				request.setAttribute("message", e.getMessage());
			}
			
			response.sendRedirect(forwardUrl);
		}

			
		
			
		
		
		private Car editCar(HttpServletRequest request)
		{
			String make=request.getParameter("company");
			String model=request.getParameter("model");
			int enginInCc=Integer.parseInt(request.getParameter("enginInCc"));
			int fuelCapacity=Integer.parseInt(request.getParameter("fuelCapacity"));
			int milage=Integer.parseInt(request.getParameter("milage"));
			double price=Double.parseDouble(request.getParameter("showroomPrice"));
			double roadTax=Double.parseDouble(request.getParameter("roadTax"));
			boolean ac= Boolean.parseBoolean(request.getParameter("ac"));
			boolean powerStearing=Boolean.parseBoolean(request.getParameter("powerStering"));
			boolean accessoryKit= Boolean.parseBoolean(request.getParameter("accessoryKit"));
			int vehicle_id=Integer.parseInt(request.getParameter("vehicle_id"));
			
			Car car= new Car();
			car.setMake(make);
			car.setModel(model);
			car.setEnginInCC(enginInCc);
			car.setFuelCapacity(fuelCapacity);
			car.setMilage(milage);
			car.setPrice(price);
			car.setRoadTax(roadTax);
			car.setAC(ac);
			car.setPowerSteering(powerStearing);
			car.setAccessoryKit(accessoryKit);
			car.setCreatedBy("admin");
			car.setCreatedTime(Calendar.getInstance().getTime());
			car.setVehicle_id(vehicle_id);
			
			return car;
			
			
		}

}
