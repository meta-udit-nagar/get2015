public class PrintApplication {

	private PriorityQueue priorityQueue = new PriorityQueue(20);
	public boolean printerStatus;

	private boolean isPrinterFree() {
		return printerStatus;

	}

	public String processRequest(Task task) {
		String result = "";
		if (isPrinterFree() && priorityQueue.checkIsEmpty()) {
			result = print(task);

		} else {
			priorityQueue.insert(task);
			System.out.println("you are in queue...plz wait for some time");
			result = "you are in queue...plz wait for some time";
		}

		return result;

	}

	public String processQueue() {
		String result = "";
		while (!priorityQueue.checkIsEmpty()) {
			if (isPrinterFree()) {

				Task task = priorityQueue.remove();
				result = result + print(task) + "/";

			}

		}
		return result;

	}

	private String print(Task task) {
		String requestHolder = "";
		if (task.priority == 4)
			requestHolder = "chairman";
		else if (task.priority == 3)
			requestHolder = "proffeser";
		else if (task.priority == 2)
			requestHolder = "graduate Student";
		else
			requestHolder = "under graduate student";

		System.out.println("dear " + requestHolder
				+ " your documents are ready to print");
		return "dear " + requestHolder + " your documents are ready to print";

	}
}
