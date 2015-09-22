package helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import model.Bike;
import model.Car;
import model.Vehicle;

public class VehicleDBHelper {

	private static Connection con = null;
	private static ResultSet rs = null;
	private static PreparedStatement ps = null;
	private static PreparedStatement pNext = null;

	static public boolean isVehicleInsert(Vehicle vehicle) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		connection.ConnectionUtil conUtil = new connection.ConnectionUtil();
		con = conUtil.getConnection();
		int result = 0;

		String query = "INSERT INTO tbl_vehicle VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {
			System.out.println("hello");

			ps = con.prepareStatement(query);
			System.out.println("hello con");
			ps.setInt(1, vehicle.getId());
			ps.setString(2, vehicle.getMake());
			ps.setString(3, vehicle.getModel());
			ps.setInt(4, vehicle.getEnginInCC());
			ps.setInt(5, vehicle.getFuelCapacity());
			ps.setInt(6, vehicle.getMilage());
			ps.setDouble(7, vehicle.getPrice());
			ps.setDouble(8, vehicle.getRoadTax());
			ps.setString(9, System.getProperty("user.name"));
			ps.setString(10, dateFormat.format(calendar.getTime()));

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (vehicle instanceof Car) {
			String queryCar = "INSERT INTO tbl_car VALUES(?,?,?,?)";
			try {

				pNext = con.prepareStatement(queryCar);
				pNext.setInt(1, vehicle.getId());
				pNext.setString(2, Boolean.toString(((Car) vehicle).isAC()));
				pNext.setString(3,
						Boolean.toString(((Car) vehicle).isPowerSteering()));
				pNext.setString(4,
						Boolean.toString(((Car) vehicle).isAccessoryKit()));
				System.out.println(pNext);
				pNext.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {

			String queryBike = "INSERT INTO tbl_bike VALUES(?,?,?)";
			try {

				pNext = con.prepareStatement(queryBike);
				pNext.setInt(1, vehicle.getId());
				pNext.setBoolean(2, ((Bike) vehicle).isSelfStart());
				pNext.setDouble(3, ((Bike) vehicle).getHelmetPrize());

				pNext.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		if (result > 0) {
			return true;

		} else
			return false;

	}

	static public void updateVehicle(Vehicle vehicle) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		connection.ConnectionUtil conUtil = new connection.ConnectionUtil();
		con = conUtil.getConnection();
		String query = "UPDATE tbl_vehical SET make=?,model=?,engin_in_cc=?,fuel_capacity=?,milage=?,price=?,roadTax=?,created_by=?,created_time=? where id=?";

		try {
			ps = con.prepareStatement(query);
			ps.setString(1, vehicle.getMake());
			ps.setString(2, vehicle.getModel());
			ps.setInt(3, vehicle.getEnginInCC());
			ps.setInt(4, vehicle.getFuelCapacity());
			ps.setInt(5, vehicle.getMilage());
			ps.setDouble(6, vehicle.getPrice());
			ps.setDouble(7, vehicle.getRoadTax());
			ps.setString(8, System.getProperty("user.name"));
			ps.setString(9, dateFormat.format(calendar.getTime()));
			ps.setInt(10, vehicle.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (vehicle instanceof Car) {
			String queryCar = "UPDATE tbl_car SET ac=?,power_steering=?,accessory_kit=? WHERE vehical_id=? ";
			try {

				pNext = con.prepareStatement(queryCar);

				pNext.setString(1, Boolean.toString(((Car) vehicle).isAC()));
				pNext.setString(2,
						Boolean.toString(((Car) vehicle).isPowerSteering()));
				pNext.setString(3,
						Boolean.toString(((Car) vehicle).isAccessoryKit()));
				pNext.setInt(4, ((Car) vehicle).getVehicle_id());

				pNext.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {

			String queryBike = "UODATE tbl_bike set self_start=?,helmet_price=? where vehicle_id=?";
			try {

				pNext = con.prepareStatement(queryBike);
				pNext.setString(1,
						Boolean.toString(((Bike) vehicle).isSelfStart()));
				pNext.setDouble(2, ((Bike) vehicle).getHelmetPrize());
				pNext.setInt(3, vehicle.getId());

				pNext.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
