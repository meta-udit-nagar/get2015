package com.metacube.webservices;

public class Client {

	public static void main(String[] args) {
		FaranhiteToCelciousServiceLocator Locator = new FaranhiteToCelciousServiceLocator();
		Locator.setFaranhiteToCelciousEndpointAddress("http://localhost:8080/SimpleSOAPExample/services/FaranhiteToCelcious");
		
		try {
			FaranhiteToCelcious calcCTCWebService = Locator.getFaranhiteToCelcious();
			System.out.println(calcCTCWebService.convert(34.0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
