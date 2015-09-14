package vehicalDekhoTest;

import helper.VehicleHelper;

import model.Bike;
import model.Car;
import model.Vehicle;

import org.junit.Test;

public class VehicalHelperTest {

	@Test
	public void testVehicleHelperForBike() {

		Vehicle vehicle = VehicleHelper.createVehicle("bike", "ApacheRTR",
				"TVS");
		assert (vehicle instanceof Bike);

	}

	@Test
	public void testVehicleHelperForCar() {

		Vehicle vehicle = VehicleHelper.createVehicle("car", "EchoSports",
				"Ford");
		assert (vehicle instanceof Car);

	}

}
