
public class PrintOutput {

	
	
	
	public static void showChart(Train.Type type, String fromto) {
		for (Train train : RailwayReservationSystem.trainList) {
			if (train.type.equals(type) && train.getFromto().equals(fromto)) {

				System.out.println(train.getName() + "    "
						+ train.getDuration() + " hrs" + "    "
						+ train.getAvail());

			}

		}

	}

	public static void showChart(Train.Type type) {

		for (Train train : RailwayReservationSystem.trainList) {
			if (train.type.equals(type)) {

				System.out.println(train.getName() + "    "
						+ train.getDuration() + " hrs" + "    "
						+ train.getAvail() + "    " + train.getFromto());

			}

		}

	}

	public static void printTicket(String name, String trainName,
			int noOfSeat, int amount) {

		System.out.println("Name  : " + name);
		System.out.println("train name  : " + trainName);
		System.out.println("no of seat  : " + noOfSeat);
		System.out.println("Amount  : " + amount);
	}

	public static int getAvailable(String trainName) {
		for (Train train : RailwayReservationSystem.trainList) {
			if (train.getName().equals(trainName))
				return train.getAvail();

		}

		return -1;

	}
}
