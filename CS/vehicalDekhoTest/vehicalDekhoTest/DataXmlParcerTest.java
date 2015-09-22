package vehicalDekhoTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Bike;
import model.Car;
import model.Vehicle;

import org.junit.BeforeClass;
import org.junit.Test;

import xmlParser.DataXmlParcer;

public class DataXmlParcerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testReadData() {

		List<Vehicle> expected = new ArrayList<Vehicle>();
		Vehicle vehicle = new Car();
		vehicle.setId(1);
		vehicle.setMake("Ford");
		vehicle.setModel("EcoSports");
		vehicle.setEnginInCC(500);
		vehicle.setFuelCapacity(12);
		vehicle.setMilage(15);
		vehicle.setPrice(10000);
		vehicle.setRoadTax(45000);
		((Car) vehicle).setAC(false);
		((Car) vehicle).setPowerSteering(true);
		((Car) vehicle).setAccessoryKit(true);
		expected.add(vehicle);
		Vehicle vehicleNew = new Bike();
		vehicleNew.setId(1);
		vehicleNew.setMake("Ford");
		vehicleNew.setModel("EcoSports");
		vehicleNew.setEnginInCC(500);
		vehicleNew.setFuelCapacity(12);
		vehicleNew.setMilage(15);
		vehicleNew.setPrice(10000);
		vehicleNew.setRoadTax(45000);
		((Bike) vehicleNew).setHelmetPrize(200);
		((Bike) vehicleNew).setSelfStart(true);
		expected.add(vehicleNew);

		assertEquals(expected,
				DataXmlParcer.readData("../vehicalDekho/xmlFiles/dataXml.xml"));

	}

}
