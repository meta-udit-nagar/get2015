package socialNetworking;

public class Person extends Entity {

	String age;
	String interest;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public Entity getPersonRecord() {
		Entity record = (Entity) getRecord();
		Entity entity = new Entity();
		entity.setEmail(record.getEmail());
		entity.setDescribtion(record.getDescribtion());
		entity.setName(record.getName());
		entity.setPhoneNo(record.getPhoneNo());
		((Person) entity).setAge(getAge());
		((Person) entity).setInterest(getInterest());
		return entity;

	}

}
