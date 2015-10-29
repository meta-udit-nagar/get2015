package com.metacube.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.CarAlreadyExistException;
import com.metacube.MetaException;
import com.metacube.model.Car;
import com.metacube.service.CarDekhoService;

/**
 * Servlet implementation class DoCreateCar
 */
@WebServlet("/DoCreateCar")
public class DoCreateCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoCreateCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   response.sendRedirect("view/create.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forwardUrl = "view/loggedin.jsp";
		Car car = createCar(request);
		CarDekhoService service= new CarDekhoService();
		try {
           service.createCar(car);
			request.setAttribute("message", "Created Successfully");
		} catch (MetaException e) {
			System.out.println("Exception while creating car " + e.getMessage());
			forwardUrl = "view/create.jsp";
			request.setAttribute("message", e.getMessage());
		}catch(CarAlreadyExistException e)
		{
			System.out.println("Exception while creating car " + e.getMessage());
			forwardUrl = "view/create.jsp";
			request.setAttribute("message", e.getMessage());
		}
		
		response.sendRedirect(forwardUrl);
	}

		
	
		
	
	
	private Car createCar(HttpServletRequest request)
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
		
		return car;
		
		
	}

}
