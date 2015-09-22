package vehicalDekhoTest;

import static org.junit.Assert.*;
import helper.VehicleDBHelper;

import java.util.List;

import model.Vehicle;

import org.junit.BeforeClass;
import org.junit.Test;

import xmlParser.DataXmlParcer;

public class VehicleDBHelperTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testIsVehicleInsertForCarObject() {

		List<Vehicle> vehicles = DataXmlParcer
				.readData("../vehicalDekho/xmlFiles/dataXml.xml");

		assertTrue(VehicleDBHelper.isVehicleInsert(vehicles.get(0)));

	}

	@Test
	public void testIsVehicleInsertForBikeObject() {

		List<Vehicle> vehicles = DataXmlParcer
				.readData("../vehicalDekho/xmlFiles/dataXml.xml");

		assertTrue(VehicleDBHelper.isVehicleInsert(vehicles.get(1)));

	}

}
