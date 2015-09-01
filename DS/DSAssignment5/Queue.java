import java.util.LinkedList;

public class Queue<T> {

	public LinkedList<T> queue = new LinkedList<T>();

	public boolean enqueue(T element) {
		queue.addLast(element);
		return true;
	}

	public T dequeue() {
		if (queue.size() > 0) {
			T element = queue.removeFirst();
			return element;
		} else {
			System.out.println("Queue is empty");
			return null;
		}
	}
}
