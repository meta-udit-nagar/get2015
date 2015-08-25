package socialNetworking;

public class Organisation extends Entity {

	String dateOfEstablishment;
	int turnOver;

	public String getDateOfEstablishment() {
		return dateOfEstablishment;
	}

	public void setDateOfEstablishment(String dateOfEstablishment) {
		this.dateOfEstablishment = dateOfEstablishment;
	}

	public int getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(int turnOver) {
		this.turnOver = turnOver;
	}

	public Entity getOrganisationRecord() {
		Entity record = (Entity) getRecord();
		Entity entity = new Entity();
		entity.setEmail(record.getEmail());
		entity.setDescribtion(record.getDescribtion());
		entity.setName(record.getName());
		entity.setPhoneNo(record.getPhoneNo());
		((Organisation) entity)
				.setDateOfEstablishment(getDateOfEstablishment());
		((Organisation) entity).setTurnOver(getTurnOver());
		return entity;

	}
}
