package socialNetworking;

import java.util.HashSet;
import java.util.Set;

public class Graph {
	public static Set<Node> setOfNodes = new HashSet<Node>();
	public static Set<Connection> setOfConnection = new HashSet<Connection>();

	public void addNode(Node node) {
		setOfNodes.add(node);

	}

	public void removeNode(Node node) {
		setOfNodes.remove(node);

	}

	public Node searchByName(String name) {
		Node node = new Node();
		for (Node extractedNode : setOfNodes) {
			if (extractedNode.getName().equals(name)) {
				node = extractedNode;
				break;
			}

		}

		return node;

	}

	public void addEdge(Node node1, Node node2) {
		Connection connection = new Connection(node1, node2);
		setOfConnection.add(connection);
	}

	public void removeEdge(Node node1, Node node2) {
		for (Connection connection : setOfConnection) {
			if (connection.getNode1().equals(node1)
					&& connection.getNode2().equals(node2)
					|| connection.getNode1().equals(node2)
					&& connection.getNode2().equals(node1)) {
				setOfConnection.remove(connection);
				break;

			}
		}

	}

}
