package socialNetworking;

import java.util.ArrayList;

public class Entity extends Node implements Record {

	private String email;
	private String describtion;
	private String phoneNo;
	private ArrayList<Entity> friends = new ArrayList<Entity>();

	public ArrayList<Entity> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<Entity> friends) {
		this.friends = friends;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Record getRecord() {
		Record record = new Entity();
		((Entity) record).setEmail(getEmail());
		((Entity) record).setName(getName());
		((Entity) record).setDescribtion(getDescribtion());
		((Entity) record).setPhoneNo(getPhoneNo());
		return record;

	}

	@Override
	public boolean equals(Object o) {
		if (this.getName().equals(((Entity) o).getName())) {
			return true;

		} else
			return false;

	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 7 * hash + this.getEmail().hashCode();
		hash = 7 * hash + this.getDescribtion().hashCode();
		hash = 7 * hash + this.getPhoneNo().hashCode();
		return hash;

	}
}
