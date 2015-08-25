package socialNetworking;

public class Connection {

	Node node1;
	Node node2;

	public Connection(Node node1, Node node2) {

		this.node1 = node1;
		this.node2 = node2;

	}

	public Node getNode1() {
		return node1;
	}

	public void setNode1(Node node1) {
		this.node1 = node1;
	}

	public Node getNode2() {
		return node2;
	}

	public void setNode2(Node node2) {
		this.node2 = node2;
	}

	@Override
	public boolean equals(Object o) {
		if (((this.node1.equals(((Connection) o).getNode1())) && (this.node2
				.equals(((Connection) o).getNode2())))
				|| ((this.node2.equals(((Connection) o).getNode1())) && (this.node1
						.equals(((Connection) o).getNode2()))))
			return true;
		else
			return false;

	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 7 * hash + this.getNode1().hashCode();
		hash = 7 * hash + this.getNode2().hashCode();

		return hash;
	}

}
