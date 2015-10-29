package com.metacube.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.metacube.CarAlreadyExistException;
import com.metacube.MetaException;
import com.metacube.db.ConnectionFactory;
import com.metacube.facade.CarDekhoFacade;
import com.metacube.model.Admin;
import com.metacube.model.Car;
import com.metacube.model.Vehicle;

public class CarDekhoService {

	
	public Car createCar(Car Car)
			throws MetaException, CarAlreadyExistException {
		Car returnValue = null;
		Connection connection = ConnectionFactory.getConnection();
		CarDekhoFacade facade = new CarDekhoFacade();
		try {
			returnValue = facade.create(connection, Car);
		} catch (MetaException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		return returnValue;
	}
	
	public boolean isValidadmin(Admin admin)
			throws MetaException {
		boolean returnValue = false;
		Connection connection = ConnectionFactory.getConnection();
		CarDekhoFacade facade = new CarDekhoFacade();
		try {
			returnValue = facade.isValidAdmin(connection,admin);
		} catch (MetaException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		return returnValue;
	}

	
	public List<String> getDistinctMake()
			throws MetaException {
		List<String> returnValue = null;
		Connection connection = ConnectionFactory.getConnection();
		CarDekhoFacade facade = new CarDekhoFacade();
		try {
			returnValue = facade.getDistinctMake(connection);
		} catch (MetaException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		return returnValue;
	}
	
	public List<Vehicle> getVehicleMake(Vehicle vehicle)
			throws MetaException {
		List<Vehicle> returnValue = null;
		Connection connection = ConnectionFactory.getConnection();
		CarDekhoFacade facade = new CarDekhoFacade();
		try {
			returnValue = facade.getVehicleMake(connection, vehicle);
		} catch (MetaException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		return returnValue;
	}
	
	
	public Car getVehicleId(Car car)
			throws MetaException {
		Car returnValue = null;
		Connection connection = ConnectionFactory.getConnection();
		CarDekhoFacade facade = new CarDekhoFacade();
		try {
			returnValue = facade.getVehicleId(connection, car);
		} catch (MetaException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		return returnValue;
	}
	
	public boolean edit(Car car)
			throws MetaException {
		boolean returnValue = false;
		Connection connection = ConnectionFactory.getConnection();
		CarDekhoFacade facade = new CarDekhoFacade();
		try {
			returnValue = facade.edit(connection, car);
		} catch (MetaException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		return returnValue;
	}

}
