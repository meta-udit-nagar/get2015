package com.metacube.db.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.metacube.MetaException;
import com.metacube.db.ConnectionFactory;
import com.metacube.model.Car;
import com.metacube.model.Vehicle;

public class VehicleDbHelper {

	private String query_get_last_vehicle_id = "select vehicle_id from tbl_vehicle order by vehicle_id desc limit 1";
	private String insert_car_query = "insert into tbl_vehicle(make,model,engin_in_cc,fuel_capacity,milage,price,roadTax,created_by,created_time) values(?,?,?,?,?,?,?,?,?)";
	private static String distint_make_query = "select distinct make from tbl_vehicle";
	private static String query_search_by_company = "select * from tbl_vehicle where make=?";
    private static String query_search_by_vehicle_id="select * from tbl_vehicle tv,tbl_car tc where tv.vehicle_id=tc.vehicle_id and tc.vehicle_id=?";
    private String edit_car_query="update tbl_vehicle set make=?,model=?,engin_in_cc=?,fuel_capacity=?,milage=?,price=?,roadTax=?,created_by=?,created_time=? where vehicle_id=?";
	
    protected void getLastVehicleId(Connection connection, Car car)
			throws MetaException {

		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement(query_get_last_vehicle_id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				car.setVehicle_id(resultSet.getInt("vehicle_id"));

			}
		} catch (SQLException e) {
			throw new MetaException("last vehical id not get " + e.getMessage());

		}
	}

	protected void create(Connection connection, Car car) throws MetaException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(insert_car_query);
			preparedStatement.setString(1, car.getMake());
			preparedStatement.setString(2, car.getModel());
			preparedStatement.setInt(3, car.getEnginInCC());
			preparedStatement.setInt(4, car.getFuelCapacity());
			preparedStatement.setInt(5, car.getMilage());
			preparedStatement.setDouble(6, car.getPrice());
			preparedStatement.setDouble(7, car.getRoadTax());
			preparedStatement.setString(8, car.getCreatedBy());
			preparedStatement.setTimestamp(9, new Timestamp(car
					.getCreatedTime().getTime()));
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new MetaException("Could not create car, [" + e.getMessage()
					+ "]");
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					System.out.println("Could not close prepared statement, ["
							+ e.getMessage() + "]");
				}
			}
		}
	}
	
	protected void edit(Connection connection, Car car) throws MetaException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(insert_car_query);
			preparedStatement.setString(1, car.getMake());
			preparedStatement.setString(2, car.getModel());
			preparedStatement.setInt(3, car.getEnginInCC());
			preparedStatement.setInt(4, car.getFuelCapacity());
			preparedStatement.setInt(5, car.getMilage());
			preparedStatement.setDouble(6, car.getPrice());
			preparedStatement.setDouble(7, car.getRoadTax());
			preparedStatement.setString(8, car.getCreatedBy());
			preparedStatement.setTimestamp(9, new Timestamp(car
					.getCreatedTime().getTime()));
			preparedStatement.setInt(10, car.getVehicle_id());
			preparedStatement.execute();
		} catch (SQLException e) {
			throw new MetaException("Could not create car, [" + e.getMessage()
					+ "]");
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					System.out.println("Could not close prepared statement, ["
							+ e.getMessage() + "]");
				}
			}
		}
	}


	public static List<String> getDistinctMake() throws MetaException {
		String make = "";
		List<String> listOfMake = new ArrayList<String>();
		Connection connection = ConnectionFactory.getConnection();
		ResultSet resultSet = null;
		if (connection != null) {
			PreparedStatement preparedStatement = null;
			try {

				preparedStatement = connection
						.prepareStatement(distint_make_query);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					make = resultSet.getString("make");
					listOfMake.add(make);

				}

				connection.commit();

			} catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not roleback.");
				}
				throw new MetaException("distinct make error, ["
						+ e.getMessage() + "]");
			} finally {
				if (resultSet != null) {
					try {
						resultSet.close();
					} catch (SQLException e) {
						System.out.println("could not close result set");
					}
				}

				if (preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						System.out
								.println("Could not close prepared statement, ["
										+ e.getMessage() + "]");
					}
				}
				ConnectionFactory.closeConnection(connection);
			}
		}

		return listOfMake;

	}

	public static List<Vehicle> getVehicleMake(Vehicle make)
			throws MetaException {
		Vehicle vehicle;
		List<Vehicle> listOfVehicle = new ArrayList<Vehicle>();
		Connection connection = ConnectionFactory.getConnection();
		ResultSet resultSet = null;
		if (connection != null) {
			PreparedStatement preparedStatement = null;
			try {

				preparedStatement = connection
						.prepareStatement(query_search_by_company);
				preparedStatement.setString(1, make.getMake());
				System.out.println(preparedStatement);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					vehicle = new Vehicle();
					vehicle.setMake(resultSet.getString("make"));
					vehicle.setModel(resultSet.getString("model"));
					vehicle.setPrice(resultSet.getInt("price"));
					vehicle.setVehicle_id(resultSet.getInt("vehicle_id"));
					
					listOfVehicle.add(vehicle);

				}

				connection.commit();

			} catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not roleback.");
				}
				throw new MetaException("search error, [" + e.getMessage()
						+ "]");
			} finally {
				if (resultSet != null) {
					try {
						resultSet.close();
					} catch (SQLException e) {
						System.out.println("could not close result set");
					}
				}

				if (preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						System.out
								.println("Could not close prepared statement, ["
										+ e.getMessage() + "]");
					}
				}
				ConnectionFactory.closeConnection(connection);
			}
		}

		return listOfVehicle;

	}
	
	
	
	
	
	public static Car getVehicleId(Car car)
			throws MetaException {
		Car newCar= new Car();
		Connection connection = ConnectionFactory.getConnection();
		ResultSet resultSet = null;
		if (connection != null) {
			PreparedStatement preparedStatement = null;
			try {
				
								preparedStatement = connection
						.prepareStatement(query_search_by_vehicle_id);
				preparedStatement.setInt(1, car.getVehicle_id());
				System.out.println(preparedStatement);
				resultSet = preparedStatement.executeQuery();
				preparedStatement.setInt(1, car.getId());
				    resultSet.next(); 
					
				    newCar.setMake(resultSet.getString("make"));
					newCar.setModel(resultSet.getString("model"));
					newCar.setEnginInCC(resultSet.getInt("engin_in_cc"));
					newCar.setFuelCapacity(resultSet.getInt("fuel_capacity"));
					newCar.setMilage(resultSet.getInt("milage"));
					newCar.setAC(Boolean.parseBoolean(resultSet.getString("ac")));
					newCar.setPowerSteering(Boolean.parseBoolean(resultSet.getString("power_steering")));
					newCar.setAccessoryKit(Boolean.parseBoolean(resultSet.getString("accessory_kit")));
					newCar.setPrice(resultSet.getInt("price"));
					newCar.setVehicle_id(resultSet.getInt("vehicle_id"));
					
					connection.commit();

			} catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not roleback.");
				}
				throw new MetaException("search error, [" + e.getMessage()
						+ "]");
			} finally {
				if (resultSet != null) {
					try {
						resultSet.close();
					} catch (SQLException e) {
						System.out.println("could not close result set");
					}
				}

				if (preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						System.out
								.println("Could not close prepared statement, ["
										+ e.getMessage() + "]");
					}
				}
				ConnectionFactory.closeConnection(connection);
			}
		}

		return newCar;

	}


}
