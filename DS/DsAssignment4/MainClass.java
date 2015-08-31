import java.util.Scanner;

public class MainClass {

	private void jobProcess() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Priority Queue Test\n");
		PriorityQueue pq = new PriorityQueue(20);
		do {
			System.out.println("1. insert");
			System.out.println("2. Start Processing");
			System.out.println("3. check empty");
			System.out.println("4. check full");
			System.out.println("5. clear");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out
						.println(" press 4 : Chairman \n press 3 : Professor \n press 2 : Graduate \n press 1: Under Graduate");
				int priority = scanner.nextInt();
				pq.insert(priority);
				break;
			case 2:
				System.out.println("\nJob processed \n\n" + pq.remove());
				break;
			case 3:
				System.out.println("\nEmpty Status : " + pq.checkIsEmpty());
				break;
			case 4:
				System.out.println("\nFull Status : " + pq.checkIsFull());
				break;
			case 5:
				System.out.println("\nPriority Queue Cleared");
				pq.clearQueue();
				break;
			default:
				System.exit(0);

				break;
			}
		} while (true);

	}

	public static void main(String[] args) {
		MainClass object = new MainClass();
		object.jobProcess();

	}

}