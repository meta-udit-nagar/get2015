package model;

public class Car extends Vehicle {

	private int vehicle_id;
	private boolean AC;
	private boolean powerSteering;
	private boolean accessoryKit;

	public int getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public boolean isAC() {
		return AC;
	}

	public void setAC(boolean aC) {
		AC = aC;
	}

	public boolean isPowerSteering() {
		return powerSteering;
	}

	public void setPowerSteering(boolean powerSteering) {
		this.powerSteering = powerSteering;
	}

	public boolean isAccessoryKit() {
		return accessoryKit;
	}

	public void setAccessoryKit(boolean accessoryKit) {
		this.accessoryKit = accessoryKit;
	}

	@Override
	public double calculateOnRoadPrice() {
		double onRoadPrice = 0.0;
		if (this.isAC()) {
			onRoadPrice = onRoadPrice + 5000;

		}

		if (isAccessoryKit()) {
			onRoadPrice = onRoadPrice + 10000;

		}

		if (isPowerSteering()) {
			onRoadPrice = onRoadPrice + 3000;

		}

		return super.calculateOnRoadPrice() + onRoadPrice;
	}

	@Override
	public String toString() {
		return super.toString() + " AC=" + AC + ", powerSteering="
				+ powerSteering + ", accessoryKit=" + accessoryKit;
	}

	@Override
	public int hashCode() {

		return vehicle_id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (vehicle_id != other.vehicle_id)
			return false;
		if (AC != other.AC)
			return false;
		if (accessoryKit != other.accessoryKit)
			return false;
		if (powerSteering != other.powerSteering)
			return false;
		return true;
	}

}
