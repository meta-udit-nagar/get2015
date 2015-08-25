package socialNetworking;

public class Node {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object node) {
		if (this.name.equals(((Node) node).getName()))
			return true;
		else
			return false;

	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 7 * hash + this.getName().hashCode();
		return hash;
	}

}
