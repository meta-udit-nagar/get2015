public class Node<T> {
	
	T nodeValue;
	Node<T> start;
	Node<T> next;

	public Node() {
		nodeValue = null;
		next = null;
	}

	public Node(T item) {
		nodeValue = item;
		next = null;
	}

	boolean add(T ele) {

		Node<T> p = new Node<T>(ele);
		Node<T> current = new Node<T>();
		if (start == null) {
			start = p;
			return true;
		} else {
			current = start;
			while (current.next != null) {
				current = current.next;
			}
			current.next = p;
		}
		return true;
	}

	boolean display() {
		Node<T> current = new Node<T>();
		current = start;
		while (current != null) {
			System.out.print(current.nodeValue + " ");
			current = current.next;
		}
		return true;
	}

	@Override
	public String toString() {

		return "Node [nodeValue=" + nodeValue + "]";
	}

	boolean addAtPostion(int position, T value) {
		Node<T> current = new Node<T>();
		Node<T> newNode = new Node<T>(value);
		current = start;
		int count = 1;
		while (current != null) {
			if (count == position - 1) {
				newNode.next = current.next;
				current.next = newNode;

			}
			count++;
			current = current.next;
		}
		if (count < position) {
			return false;
		}
		return true;

	}

	boolean deleteByValue(T value) {
		int flag = 0;
		Node<T> current = start;
		if (current == null)
			return false;
		while (current != null) {
			if (current.nodeValue == value) {
				start = current.next;
				return true;
			}
			if (current.next.nodeValue == value) {
				current.next = current.next.next;
				flag = 1;
				return true;
			}
			current = current.next;
		}
		if ((flag == 0) && (current == null)) {
			return false;
		}

		return false;

	}

	boolean deleteByIndex(int position) {
		Node<T> current = new Node<T>();
		current = start;
		int count = 1;
		while (current != null) {
			if (count == position - 1) {
				current.next = current.next.next;

			}
			count++;
			current = current.next;
		}
		if (count < position) {
			return false;
		}
		return false;

	}

	T getitem(int position) {
		Node<T> current = new Node<T>();
		current = start;
		int count = 1;
		while (current != null) {
			if (count == position) {
				return current.nodeValue;

			}
			count++;
			current = current.next;
		}
		return null;
	}

	public void reverseLinkedList() {
		if (start == null || start.next == null)
			return;
		Node<T> Second = start.next;
		Node<T> Third = Second.next;
		Second.next = start; 
		start.next = null; 
		if (Third == null)
			return;
		Node<T> CurrentNode = Third;
		Node<T> PreviousNode = Second;
		while (CurrentNode != null) {
			Node<T> NextNode = CurrentNode.next;
			CurrentNode.next = PreviousNode;
			PreviousNode = CurrentNode;
			CurrentNode = NextNode;
		}
		start = PreviousNode; 
		Node<T> current = start;

	}

	public boolean sortList() {
		if (start == null || start.next == null)
			return true;

		Node<T> newHead = new Node<T>(start.nodeValue);
		Node<T> pointer = start.next;

		while (pointer != null) {


			Node<T> innerPointer = newHead;
			Node<T> next = pointer.next;

			if ((int) pointer.nodeValue <= (int) newHead.nodeValue) {
				Node<T> oldHead = newHead;
				newHead = pointer;
				newHead.next = oldHead;
			} else {
				while (innerPointer.next != null) {

					if ((int) pointer.nodeValue > (int) innerPointer.nodeValue
							&& (int) pointer.nodeValue <= (int) innerPointer.next.nodeValue) {
						Node<T> oldNext = innerPointer.next;
						innerPointer.next = pointer;
						pointer.next = oldNext;
					}

					innerPointer = innerPointer.next;
				}

				if (innerPointer.next == null
						&& (int) pointer.nodeValue > (int) innerPointer.nodeValue) {
					innerPointer.next = pointer;
					pointer.next = null;
				}
			}

			pointer = next;
		}
		start = newHead;
		return true;
	}
}
