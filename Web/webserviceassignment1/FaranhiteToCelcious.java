package com.metacube.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class FaranhiteToCelcious {

	
	@WebMethod
	public double convert(double f)
	{
		double c;
		c=(f-32.0)*(5.0/9.0);
		return c;	
	}
	
}
