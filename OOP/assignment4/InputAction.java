import java.util.Scanner;


public class InputAction implements Action{
static private Train.Type type;
	public void  perform(int input)
	{
		
	if(input==1)
	{
		
		type=Train.Type.PASSENGER;
		
		
	}else
	{
		
		type=Train.Type.GOODS;
		
	}
		
	}
	
	public static void InputProcess() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out
					.println("welcome to Railways ticket booking center Enter your name");
			String name = scanner.next();
			MenuNew menuNew=new MenuNew();
			
			showChart(type);
			System.out.println("Enter from to stations");
			String fromto = scanner.next();
			System.out.println(fromto);
			showChart(type, fromto);
			System.out.println("Enter Train Name");
			String trainName = scanner.next();
			int noOfSeat = 0;
			if (type.equals(Train.Type.PASSENGER)) {
				System.out.println("Enter no of seats ");
			} else {

				System.out.println("Enter waight to be transport");

			}
			noOfSeat = scanner.nextInt();
			if (noOfSeat <= getAvailable(trainName)) {
				int amount = getFare(100, 50, type, noOfSeat);

				System.out
						.println("enter the mode of payment\n1-cc\n\2-wallet\n3-netbanking");
				int in = scanner.nextInt();
				Payment payment;
				if (in == 1) {
					 payment = new CcPayment();
					

				} else if (in == 2) {
					 payment = new WalletPayment();
					

				} else {
					 payment = new NetBankingPayment();					
					

				}
				   payment.process(amount);

				for (Train train : RailwayReservationSystem.trainList) {

					if (train.getName().equals(trainName)) {
						train.setAvail(train.getAvail() - noOfSeat);
						break;
					}
				}

				printTicket(name, trainName, noOfSeat, amount);

			} else {

				System.out.println("Seats/load unavailable");

			}
			System.out.println("Do you want to book another ticket ?y/n");
			String in = scanner.next();
			if (in.equals("n")) {

				break;
			} else {

				showChart(type, fromto);
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


	private static void showChart(Train.Type type, String fromto) {
		for (Train train : RailwayReservationSystem.trainList) {
			if (train.type.equals(type) && train.getFromto().equals(fromto)) {

				System.out.println(train.getName() + "    "
						+ train.getDuration() + " hrs" + "    "
						+ train.getAvail());

			}

		}

	}

	private static void showChart(Train.Type type) {

		for (Train train : RailwayReservationSystem.trainList) {
			if (train.type.equals(type)) {

				System.out.println(train.getName() + "    "
						+ train.getDuration() + " hrs" + "    "
						+ train.getAvail() + "    " + train.getFromto());

			}

		}

	}

	private static void printTicket(String name, String trainName,
			int noOfSeat, int amount) {

		System.out.println("Name  : " + name);
		System.out.println("train name  : " + trainName);
		System.out.println("no of seat  : " + noOfSeat);
		System.out.println("Amount  : " + amount);
	}

	private static int getAvailable(String trainName) {
		for (Train train : RailwayReservationSystem.trainList) {
			if (train.getName().equals(trainName))
				return train.getAvail();

		}

		return -1;

	}

	
	
}
