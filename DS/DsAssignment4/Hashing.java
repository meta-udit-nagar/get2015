import java.util.Hashtable;
import java.util.Scanner;

public class Hashing {

	public static void allotment() {
		try {
			Scanner scanner = new Scanner(System.in);

			String name;

			int age, i, count = 1;

			boolean flag = true;

			int hashCode;

			int numberOfRooms;
			int choice;

			Hashtable<Integer, String> rooms = new Hashtable<Integer, String>();

			System.out.println("Enter Number of rooms: (must be prime number)");

			numberOfRooms = scanner.nextInt();

			while (!isPrimeNumber(numberOfRooms)) {
				System.out.println("Enter prime number");
				numberOfRooms = scanner.nextInt();
			}

			for (i = 0; i < numberOfRooms; i++) {
				rooms.put(i, "");
			}

			do {
				flag = true;
				System.out.println("1. Show  Booked Status of rooms");
				System.out.println("2. Allot room to a guest based on age");
				System.out.println("3. Exit");
				System.out.println("Enter your choice: ");

				choice = scanner.nextInt();
				switch (choice) {

				case 1:
					System.out.println("Status of  Alloted rooms is: ");

					for (int roomNumber : rooms.keySet()) {

						System.out.println("Room " + (roomNumber) + " : "
								+ rooms.get(roomNumber));
					}
					break;

				case 2:
					System.out.println("Enter name of guest: ");
					name = scanner.next();
					System.out.println("Enter age of the guest: ");
					do {
						System.out
								.println("(Please Enter Positive integer Number greater than 18)");

						age = scanner.nextInt();
					} while (age <= 18);

					hashCode = age % numberOfRooms;

					for (i = hashCode; i <= (numberOfRooms - 1);) {
						if (rooms.get(i).equals("")) {
							rooms.put(i, name);
							System.out.println("Room number " + i
									+ " is alloted to " + name);
							flag = false;
							break;
						} else {
							i += 3;
						}
					}
					i = 0;

					while (flag) {
						for (int j = i; j <= (numberOfRooms - 1); j++) {
							if (rooms.get(j).equals("")) {
								rooms.put(j, name);
								System.out.println("Room number " + j
										+ " is alloted to " + name);
								flag = false;
								break;
							} else {
								j += 3;
							}
						}
						i++;
					}
					count++;
					break;

				case 3:
					System.out.println("System will Exit");
					System.exit(0);
					break;

				default:
					System.out.println("Enter correct Choice");
				}
			} while (count < numberOfRooms);

			System.out.println("All Rooms are full now");
			System.out.println("Status of rooms is: ");

			for (int roomNumber : rooms.keySet()) {

				System.out.println("Room " + (roomNumber) + " : "
						+ rooms.get(roomNumber));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static boolean isPrimeNumber(int number) {

		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
