package com.metacube.facade;

import java.sql.Connection;
import java.util.List;

import com.metacube.CarAlreadyExistException;
import com.metacube.MetaException;
import com.metacube.db.helper.AdminDbHelper;
import com.metacube.db.helper.CarDbHelper;
import com.metacube.db.helper.VehicleDbHelper;
import com.metacube.model.Admin;
import com.metacube.model.Car;
import com.metacube.model.Vehicle;

public class CarDekhoFacade {

	public Car create(Connection connection, Car car) throws MetaException,
			CarAlreadyExistException {
		Car carFromDb = null;

		VehicleDbHelper vehicleDbHelper = new VehicleDbHelper();
		CarDbHelper carDbHelper = new CarDbHelper();
		try {
			carFromDb = vehicleDbHelper.getCarByMakeModel(connection, car);
			if (carFromDb == null) {
				carDbHelper.create(connection, car);
				carFromDb = vehicleDbHelper.getCarByMakeModel(connection, car);
			} else {
				throw new CarAlreadyExistException("car with model "
						+ car.getModel() + " and make " + car.getMake()
						+ " already exists.");
			}
		} catch (MetaException e) {
			System.out.println("Exception while creating sales person "
					+ e.getMessage());
			throw e;
		}
		return carFromDb;
	}

	public boolean isValidAdmin(Connection connection, Admin admin)
			throws MetaException {
		boolean returnValue = false;
		try {
			returnValue = AdminDbHelper.isValidAdmin(connection, admin);
		} catch (MetaException e) {
			System.out.println("Exception while Login " + e.getMessage());
			throw e;
		}
		return returnValue;
	}

	public List<Vehicle> getVehicleMake(Connection connection, Vehicle vehicle) throws MetaException{
		List<Vehicle> listofVehicle = null;

		try {
				
			listofVehicle=VehicleDbHelper.getVehicleMake(connection,vehicle);
			
		} catch (MetaException e) {
			System.out.println("Exception while creating sales person "
					+ e.getMessage());
			throw e;
		}
		return listofVehicle;
	}
	
	public List<String> getDistinctMake(Connection connection) throws MetaException{
		List<String> listofCar = null;

		try {
				
			listofCar=VehicleDbHelper.getDistinctMake(connection);
			
		} catch (MetaException e) {
			System.out.println("Exception while creating sales person "
					+ e.getMessage());
			throw e;
		}
		return listofCar;
	}
	
	
	public Car getVehicleId(Connection connection,Car car) throws MetaException {
		Car car2=null;

		try {
			
			car2=VehicleDbHelper.getVehicleId(connection, car);
			
		} catch (MetaException e) {
			System.out.println("Exception while creating sales person "
					+ e.getMessage());
			throw e;
		}
		return car2;
	}
	
	public boolean edit(Connection connection,Car car) throws MetaException {
		boolean result=false;
     CarDbHelper carDbHelper= new CarDbHelper();
		try {
			
			result=carDbHelper.edit(connection, car);
			
		} catch (MetaException e) {
			System.out.println("Exception while creating sales person "
					+ e.getMessage());
			throw e;
		}
		return result;
	}

}
