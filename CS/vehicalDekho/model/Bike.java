package model;

public class Bike extends Vehicle {

	private int vehicle_id;
	private boolean selfStart;
	private double helmetPrize;

	public int getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public boolean isSelfStart() {
		return selfStart;
	}

	public void setSelfStart(boolean selfStart) {
		this.selfStart = selfStart;
	}

	public double getHelmetPrize() {
		return helmetPrize;
	}

	public void setHelmetPrize(double helmetPrize) {
		this.helmetPrize = helmetPrize;
	}

	@Override
	public double calculateOnRoadPrice() {
		double onRoadPrice = 0;
		if (isSelfStart()) {
			onRoadPrice = onRoadPrice + 1000;

		}

		onRoadPrice = onRoadPrice + getHelmetPrize();
		return super.calculateOnRoadPrice() + onRoadPrice;
	}

	@Override
	public String toString() {
		return super.toString() + " selfStart=" + selfStart + ", helmetPrize="
				+ helmetPrize;
	}

	@Override
	public int hashCode() {
		return vehicle_id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bike other = (Bike) obj;
		if (vehicle_id != other.vehicle_id)
			return false;
		if (Double.doubleToLongBits(helmetPrize) != Double
				.doubleToLongBits(other.helmetPrize))
			return false;
		if (selfStart != other.selfStart)
			return false;
		return true;
	}

}
