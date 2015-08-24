public class Person extends Entity implements Record {

	long phoneNumber;
	String interest;

	// Iterator<String> personFriend;
	public Person(long phoneNumber, String email, String name) {
		super(email, name);
		this.phoneNumber = phoneNumber;
	}

	@Override
	public void setInterest(String interest) {
		this.interest = interest;

	}

	@Override
	public String getInterest() {

		return interest;
	}

	@Override
	public void setPlacementRecord(String placementRecord) {
	}

	@Override
	public String getPlacementRecord() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void showFriends() {

		if (friends.isEmpty()) {
			System.out
					.println("Sorry !! You Don't have any friend in your Friend \n");
		} else {
			System.out.println("\nYour Friend List ---");
			int p = 0;
			for (String friendName : friends) {

				System.out.println(++p + " " + friendName);

			}
		}
	}
}
