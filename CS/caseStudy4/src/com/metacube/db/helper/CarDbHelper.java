package com.metacube.db.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.metacube.MetaException;
import com.metacube.db.ConnectionFactory;
import com.metacube.model.Car;
public class CarDbHelper extends VehicleDbHelper{


	private String insert_car_query="insert into tbl_car(vehicle_id,ac,power_steering,accessory_kit,created_by,created_time) values(?,?,?,?,?,?)";
    private String update_car_query="update tbl_car set vehicle_id=?,ac=?,power_steering=?,accessory_kit=?,created_by=?,created_time=? where vehicle_id=?";   
  
	
	public boolean create(Car car) throws MetaException {
		boolean created = false;
		Connection connection = ConnectionFactory.getConnection();
		if(connection != null) {
			PreparedStatement preparedStatement = null;
				try {
					super.create(connection, car);
					super.getLastVehicleId(connection, car);
					
						preparedStatement = connection.prepareStatement(insert_car_query);
						preparedStatement.setInt(1, car.getVehicle_id());
						preparedStatement.setString(2, car.isAC()+"");
						preparedStatement.setString(3, car.isPowerSteering()+"");
						preparedStatement.setString(4, car.isAccessoryKit()+"");
						preparedStatement.setString(5, car.getCreatedBy());
						preparedStatement.setTimestamp(6, new Timestamp(car.getCreatedTime().getTime()));
						created = preparedStatement.execute();
						connection.commit();
					
				} catch(MetaException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not roleback.");
				}
				throw e;
			} catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not roleback.");
				}
				throw new MetaException("Could not create car, [" + e.getMessage() + "]");
			} finally {
				if(preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						System.out.println("Could not close prepared statement, [" + e.getMessage() + "]");
					}
				}
				ConnectionFactory.closeConnection(connection);
			}
		}
		
		return created;
	}
	
	
	
	
	public boolean edit(Car car) throws MetaException {
		boolean created = false;
		Connection connection = ConnectionFactory.getConnection();
		if(connection != null) {
			PreparedStatement preparedStatement = null;
				try {
					super.create(connection, car);
					super.getLastVehicleId(connection, car);
					
						preparedStatement = connection.prepareStatement(update_car_query);
						preparedStatement.setInt(1, car.getVehicle_id());
						preparedStatement.setString(2, car.isAC()+"");
						preparedStatement.setString(3, car.isPowerSteering()+"");
						preparedStatement.setString(4, car.isAccessoryKit()+"");
						preparedStatement.setString(5, car.getCreatedBy());
						preparedStatement.setTimestamp(6, new Timestamp(car.getCreatedTime().getTime()));
						preparedStatement.setInt(7, car.getVehicle_id());
						created = preparedStatement.execute();
						connection.commit();
					
				} catch(MetaException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not roleback.");
				}
				throw e;
			} catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not roleback.");
				}
				throw new MetaException("Could not create car, [" + e.getMessage() + "]");
			} finally {
				if(preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						System.out.println("Could not close prepared statement, [" + e.getMessage() + "]");
					}
				}
				ConnectionFactory.closeConnection(connection);
			}
		}
		
		return created;
	}
}
