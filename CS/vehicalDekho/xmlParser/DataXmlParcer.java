package xmlParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import model.Bike;
import model.Car;
import model.Vehicle;

public class DataXmlParcer {
	static private String ID = "id";
	static private String MAKE = "make";
	static private String MODEL = "model";
	static private String ENGININCC = "enginInCC";
	static private String FUELCAPACITY = "fuelCapacity";
	static private String MILAGE = "milage";
	static private String PRICE = "price";
	static private String ROADTAX = "roadTax";
	static private String SELFSTART = "selfStart";
	static private String HELMATPRIZE = "helmetPrize";
	static private String AC = "AC";
	static private String POWERSTEERING = "powerSteering";
	static private String ACCESSORYkIT = "accessoryKit";

	@SuppressWarnings({ "unchecked", "null" })
	public static List<Vehicle> readData(String configFile) {
		List<Vehicle> listOfVehicles = new ArrayList<Vehicle>();
		try {

			XMLInputFactory inputFactory = XMLInputFactory.newInstance();

			InputStream in = new FileInputStream(configFile);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

			Vehicle vehicle = null;

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();

					if (startElement.getName().getLocalPart() == ("vehicle")) {

						Iterator<Attribute> attributes = startElement
								.getAttributes();
						while (attributes.hasNext()) {
							Attribute attribute = attributes.next();
							if (attribute.getName().toString().equals("type")) {
								if (attribute.getValue().equals("car")) {
									vehicle = new Car();

								} else {

									vehicle = new Bike();
								}

							}

						}
					}

					if (event.isStartElement()) {
						if (event.asStartElement().getName().getLocalPart()
								.equals(ID)) {
							event = eventReader.nextEvent();
							vehicle.setId(Integer.parseInt(event.asCharacters()
									.getData()));
							continue;
						}
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals(MAKE)) {
						event = eventReader.nextEvent();
						vehicle.setMake(event.asCharacters().getData());
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(MODEL)) {
						event = eventReader.nextEvent();
						vehicle.setModel(event.asCharacters().getData());
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(ENGININCC)) {
						event = eventReader.nextEvent();
						vehicle.setEnginInCC(Integer.parseInt(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(FUELCAPACITY)) {
						event = eventReader.nextEvent();
						vehicle.setFuelCapacity(Integer.parseInt(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(MILAGE)) {
						event = eventReader.nextEvent();
						vehicle.setMilage(Integer.parseInt(event.asCharacters()
								.getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(PRICE)) {
						event = eventReader.nextEvent();
						vehicle.setPrice(Double.parseDouble(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(ROADTAX)) {
						event = eventReader.nextEvent();
						vehicle.setRoadTax(Double.parseDouble(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(HELMATPRIZE)) {
						event = eventReader.nextEvent();
						((Bike) vehicle).setHelmetPrize(Double
								.parseDouble(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(AC)) {
						event = eventReader.nextEvent();
						((Car) vehicle).setAC(Boolean.parseBoolean(event
								.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(ACCESSORYkIT)) {
						event = eventReader.nextEvent();
						((Car) vehicle).setAccessoryKit(Boolean
								.parseBoolean(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(POWERSTEERING)) {
						event = eventReader.nextEvent();
						((Car) vehicle).setPowerSteering(Boolean
								.parseBoolean(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals(SELFSTART)) {
						event = eventReader.nextEvent();
						((Bike) vehicle).setSelfStart(Boolean
								.parseBoolean(event.asCharacters().getData()));
						continue;
					}

				}

				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart() == ("vehicle")) {
						listOfVehicles.add(vehicle);
					}
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return listOfVehicles;
	}

}
