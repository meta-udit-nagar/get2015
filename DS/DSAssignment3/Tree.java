
public class Tree<T> {

	private Node root;
	private String preOrder;
	private String postOrder;

	public Tree() {

		root = null;
		preOrder = "";
		postOrder = "";
	}

	public Node getRoot() {
		return root;

	}

	public String getpreOrder() {
		return preOrder;
	}

	public String getpostOrder() {
		return postOrder;
	}

	public class Node {
		private Node left;
		private Node right;
		private T value;

		public Node(T value) {
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

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

	}

	public void addNode(T key) {
		Node temp = new Node(key);
		if (root == null) {
			root = temp;
			System.out.println("added successfully");

		} else
			addNode(root, temp);
	}

	public void addMirrorNode(T key) {
		Node temp = new Node(key);
		if (root == null) {
			root = temp;
			System.out.println("added successfully");

		} else
			addMirrorNode(root, temp);
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

	private void addMirrorNode(Node latestRoot, Node node) {

		if ((int) latestRoot.getValue() > (int) node.getValue()) {

			if (latestRoot.getRight() == null) {
				latestRoot.setRight(node);
				return;
			} else {
				addNode(latestRoot.getRight(), node);
			}
		} else {
			if (latestRoot.getLeft() == null) {
				latestRoot.setLeft(node);
				return;
			} else {
				addNode(latestRoot.getLeft(), node);
			}
		}
	}

	public void preOrder(Node root) {

		if (root == null)
			return;
		System.out.println(root.getValue());
		preOrder = preOrder + root.getValue();
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}

	public void postOrder(Node root) {

		if (root == null)
			return;
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.println(root.getValue());
		postOrder = postOrder + root.value;

	}

	public boolean checkMirror(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if ((root1 == null && root2 != null)
				|| (root1 != null && root2 == null)) {
			return false;

		}

		if (root1.value != root2.value) {
			return false;
		}
		checkMirror(root1.left, root2.right);
		checkMirror(root1.right, root2.left);
		return true;
	}

}
