import java.util.Scanner;

public class SortingApplication {

	public String process(int choice, int a[]) {
		String output = "System has used ";
		Sorting sorting = new Sorting();
		if (choice == 1)// for comparison sorting
		{
			if (a.length > 10) {
				a = sorting.quicksort(a);
				output = output
						+ "quickSort sorting technique and sorted list as :";

			} else {
				a = sorting.bubbleSort(a);
				output = output
						+ "bubbleSort sorting technique and sorted list as :";
			}
		} else {
			boolean ch = true;
			for (int i = 0; i < a.length; i++) {
				if (a[i] > 99) {
					ch = false;
					break;
				}
			}
			if (ch) {

				a = sorting.countingSort(a);
				output = output
						+ "countingSort sorting technique and sorted list as :";
			} else {
				a = sorting.radixSort(a);
				output = output
						+ "radixSort sorting technique and sorted list as :";
			}
		}

		for (int i = 0; i < a.length; i++) {
			output = output + " " + a[i];
		}

		return output;
	}

	public void userInterface() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter choice :\n1-Comparision Sort\n2-Linear Sort");

		int choice = scanner.nextInt();
		System.out.println("Enter no of elements you want to sort");

		int n = scanner.nextInt();
		int a[] = new int[n];
		System.out.println("Enter elements");
		for (int i = 0; i < n; i++) {

			a[i] = scanner.nextInt();

		}
		System.out.println(process(choice, a));

	}

	public static void main(String arg[]) {
		SortingApplication application = new SortingApplication();
		application.userInterface();

	}

}
