import java.util.ArrayList;

public class Tree {
	private Node root;
	private ArrayList<Integer> inOrder = new ArrayList<Integer>();

	class Node {
		private Node left;
		private Node right;
		private int value;

		public Node(int value) {
			this.value = value;

		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}

	public Node getRoot() {
		return root;
	}

	public ArrayList<Integer> getinOrder() {
		return inOrder;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void addNode(int key) {
		Node temp = new Node(key);
		if (root == null) {
			root = temp;
			System.out.println("added successfully");

		} else
			addNode(root, temp);
	}

	private void addNode(Node latestRoot, Node node) {

		if ((int) latestRoot.getValue() > (int) node.getValue()) {

			if (latestRoot.getLeft() == null) {
				latestRoot.setLeft(node);
				return;
			} else {
				addNode(latestRoot.getLeft(), node);
			}
		} else {
			if (latestRoot.getRight() == null) {
				latestRoot.setRight(node);
				return;
			} else {
				addNode(latestRoot.getRight(), node);
			}
		}
	}

	private void innerInOrder(Node root) {

		if (root == null)
			return;
		System.out.println(root.getValue());
		innerInOrder(root.getLeft());
		inOrder.add(root.getValue());
		innerInOrder(root.getRight());
	}

	public int[] inOrder(Node root) {

		innerInOrder(root);

		System.out.println("length" + inOrder.size());
		int inOrderInt[] = new int[inOrder.size()];
		for (int i = 0; i < inOrder.size(); i++) {
			inOrderInt[i] = inOrder.get(i);
		}
		return inOrderInt;

	}
}
