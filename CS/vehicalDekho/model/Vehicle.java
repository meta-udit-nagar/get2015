package model;

public class Vehicle {

	private int id;
	private String make;
	private String model;
	private int enginInCC;
	private int fuelCapacity;
	private int milage;
	private double price;
	private double roadTax;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getEnginInCC() {
		return enginInCC;
	}

	public void setEnginInCC(int enginInCC) {
		this.enginInCC = enginInCC;
	}

	public int getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(int fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public int getMilage() {
		return milage;
	}

	public void setMilage(int milage) {
		this.milage = milage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRoadTax() {
		return roadTax;
	}

	public void setRoadTax(double roadTax) {
		this.roadTax = roadTax;
	}

	public double calculateOnRoadPrice() {
		return price + roadTax;
	}

	@Override
	public String toString() {
		return "id=" + id + "make=" + make + ", model=" + model
				+ ", enginInCC=" + enginInCC + ", fuelCapacity=" + fuelCapacity
				+ ", milage=" + milage + ", price=" + price + ", roadTax="
				+ roadTax;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (id != other.id)
			return false;
		if (enginInCC != other.enginInCC)
			return false;
		if (fuelCapacity != other.fuelCapacity)
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (milage != other.milage)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (Double.doubleToLongBits(roadTax) != Double
				.doubleToLongBits(other.roadTax))
			return false;
		return true;
	}

}
