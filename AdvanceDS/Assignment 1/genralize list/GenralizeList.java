package addsAssignment;

import java.util.List;
import java.util.ArrayList;

public class GenralizeList {
	private Node start;
	private Stack expression;
	private int max = 0;
	private int sum = 0;
	private String outputList = "";
	private boolean b = false;

	public Node getStart() {
		return start;

	}

	class Stack {
		private int top;
		private int size;
		private Object stack[];

		public Stack(int size) {

			this.size = size;
			top = -1;
			stack = new Object[size];
		}

		public int getTop() {
			return top;
		}

		public void setTop(int top) {
			this.top = top;
		}

		public void push(Object item) {

			if (top >= size - 1) {
				System.out.println("Stack overflow");

			} else {
				top = top + 1;
				stack[top] = item;
			}

		}

		public Object pop() {
			Object elementToPop = null;
			if (size == -1) {
				System.out.println("Stack underflow");
			} else {

				elementToPop = stack[top];
				top--;

			}

			return elementToPop;
		}

		public boolean isEmpty() {
			if (top == -1)
				return true;
			else
				return false;

		}

		public Object peep() {
			Object t = null;
			if (top >= size) {
				System.out.println("stack overflow");
			} else if (top == -1) {

				System.out.println("Stack underflow");
			} else {
				t = stack[top];
			}
			return t;
		}

	}

	class Node {
		Node next;
		Object value;

		public Node(Object item) {
			value = item;
			next = null;
		}

		public Node() {
		}
	}

	public GenralizeList() {
		start = null;
	}

	public GenralizeList(String list) {
		expression = new Stack(list.length());
		int num = 0;

		for (int i = 0; i < list.length(); i++) {

			if (list.charAt(i) == '(') {
				expression.push("(");

			} else if (list.charAt(i) == ',') {
				if (list.charAt(i - 1) != ')') {

					Node node = new Node(num);
					expression.push(node);
					num = 0;
				}
			} else if (list.charAt(i) == ')') {

				if (list.charAt(i - 1) != ')') {
					Node node = new Node(num);
					expression.push(node);
					num = 0;
				}
				List<Object> innerList = new ArrayList<Object>();
				while (!(expression.peep().toString().equals("("))) {

					innerList.add(expression.pop());

				}
				expression.pop();
				Node node1 = new Node();

				node1.value = (Node) innerList.get(innerList.size() - 1);
				for (int j = innerList.size() - 1; j >= 1; j--) {
					((Node) innerList.get(j)).next = (Node) innerList

					.get(j - 1);

				}
				expression.push(node1);
				start = node1;

			} else {
				num = num * 10 + Integer.parseInt("" + list.charAt(i));
			}
		}
	}

	public String toString(Node start) {
		if (start == null) {
			return outputList;
		} else if (start.value instanceof Integer) {
			outputList = outputList + start.value;
			toString(start.next);

		} else {

			toString((Node) start.value);
			toString((Node) start.next);

		}
		return outputList;

	}

	public int calculateMax(Node start) {
		if (start == null) {
			return max;
		} else if (start.value instanceof Integer) {
			if ((Integer) start.value > max) {
				max = (Integer) start.value;

			}
			calculateMax(start.next);

		} else {

			calculateMax((Node) start.value);
			calculateMax((Node) start.next);

		}

		return max;
	}

	public int calculateSum(Node start) {
		if (start == null) {
			return sum;
		} else if (start.value instanceof Integer) {
			sum = sum + (Integer) start.value;
			calculateSum(start.next);

		} else {

			calculateSum((Node) start.value);
			calculateSum((Node) start.next);

		}

		return sum;
	}

	public boolean search(Node start, int x) {
		if (start == null) {
			return b;
		} else if (start.value instanceof Integer) {
			if ((Integer) start.value == x) {

				b = true;
			}

			search(start.next, x);

		} else {

			search((Node) start.value, x);
			search((Node) start.next, x);

		}

		return b;
	}

}
