import java.util.Scanner;

public class InputAction extends Menu {
	private static Train.Type type;

	public InputAction() {

		addMenuItem(new ActionableMenuItem("1-passenger", new PassengerAction()));
		addMenuItem(new ActionableMenuItem("1-Goods", new GoodsAction()));
	}

	class PassengerAction implements Action {
		@Override
		public void perform() {
			// TODO Auto-generated method stub

			type = Train.Type.PASSENGER;

		}
	}

	class GoodsAction implements Action {
		@Override
		public void perform() {
			// TODO Auto-generated method stub
			type = Train.Type.GOODS;
		}
	}

	public static void InputProcess() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out
					.println("welcome to Railways ticket booking center Enter your name");
			String name = scanner.next();
			Menu trainMenu = new InputAction();
			trainMenu.display();

			PrintOutput.showChart(type);
			System.out.println("Enter from to stations");
			String fromto = scanner.next();
			System.out.println(fromto);
			PrintOutput.showChart(type, fromto);
			System.out.println("Enter Train Name");
			String trainName = scanner.next();
			int noOfSeat = 0;
			if (type.equals(Train.Type.PASSENGER)) {
				System.out.println("Enter no of seats ");
			} else {

				System.out.println("Enter waight to be transport");

			}
			noOfSeat = scanner.nextInt();
			if (noOfSeat <= PrintOutput.getAvailable(trainName)) {

				Menu paymentMenu = new PaymentMenu();
				paymentMenu.display();

				int amount = getFare(100, 50, type, noOfSeat);

				for (Train train : RailwayReservationSystem.trainList) {

					if (train.getName().equals(trainName)) {
						train.setAvail(train.getAvail() - noOfSeat);
						break;
					}
				}

				PrintOutput.printTicket(name, trainName, noOfSeat, amount);

			} else {

				System.out.println("Seats/load unavailable");

			}
			System.out.println("Do you want to book another ticket ?y/n");
			String in = scanner.next();
			if (in.equals("n")) {

				break;
			} else {

				PrintOutput.showChart(type, fromto);
			}

		}

	}

	static int getFare(int passengerRate, int goodsRate, Train.Type type,
			int noOfSeat) {
		int amount = 0;
		if (type.equals(Train.Type.PASSENGER)) {
			amount = 100 * noOfSeat;
		} else {

			amount = 50 * noOfSeat;

		}

		return amount;
	}

}
