class PriorityQueue {

	private Task[] heap;

	private int heapSize, capacity;

	public PriorityQueue(int capacity) {

		this.capacity = capacity + 1;
		heap = new Task[this.capacity];
		heapSize = 0;
	}

	public void clearQueue() {
		heap = new Task[capacity];
		heapSize = 0;
	}

	public boolean checkIsEmpty() {
		return heapSize == 0;
	}

	public boolean checkIsFull() {
		return heapSize == capacity - 1;
	}

	public int size() {
		return heapSize;
	}

	public void insert(Task newJob) {
		
		heap[++heapSize] = newJob;

		int pos = heapSize;

		while (pos != 1 && newJob.priority > heap[pos / 2].priority) {
			heap[pos] = heap[pos / 2];
			pos /= 2;
		}
		heap[pos] = newJob;
	}

	public Task remove() {
		int parent, child;
		Task item, temp;
		if (checkIsEmpty()) {
			System.out.println("Heap is empty");
			return null;
		}

		item = heap[1];
		temp = heap[heapSize--];

		parent = 1;
		child = 2;

		while (child <= heapSize) {
			if (child < heapSize
					&& heap[child].priority < heap[child + 1].priority)
				child++;
			if (temp.priority >= heap[child].priority)
				break;

			heap[parent] = heap[child];
			parent = child;
			child *= 2;
		}
		heap[parent] = temp;

		return item;
	}
}
