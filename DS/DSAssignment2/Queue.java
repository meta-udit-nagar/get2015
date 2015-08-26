public class Queue {

	private int front;
	private int end;
	private int size;
	private Object queue[];

	
	
	
	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Object[] getQueue() {
		return queue;
	}

	public void setQueue(Object[] queue) {
		this.queue = queue;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public Queue(int size) {
		front = -1;
		end = -1;
		this.size = size;
		queue = new Object[size];

	}

	public void enqueue(Object item) {
		if (end >= size - 1) {

			System.out.println("Queue is full");
			return;
		} else if (front == -1 && end == -1) {
			front = 0;
		}
		end = end + 1;
		queue[end] = item;

	}

	public Object dequeue() {
		Object item = new Object();
		if (front == -1) {

			System.out.println("Queue is empty");
			return null;

		} else {
			item = queue[front];

		}
		if (front == end) {
			front = -1;
			end = -1;

		} else
			front = front + 1;
		return item;
	}

	public void makeEmpty() {
		front = -1;
		end = -1;

	}

	public Object getFront() {
		Object object = new Object();
		if (end == -1) {
			System.out.println("Queue is empty");
			return null;
		} else
			object = queue[end];

		return object;
	}

}
