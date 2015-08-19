import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class RailwayReservationSystem {
	public static ArrayList<Train> trainList = new ArrayList<Train>();

	private static void prepareTrain() {

		final String COMMA_DELIMITER = ",";
		final String url = "D://Train/TrainDetails.csv";

		BufferedReader fileReader = null;
		try {

			String line = "";
			fileReader = new BufferedReader(new FileReader(url));// file reading
			fileReader.readLine();

			while ((line = fileReader.readLine()) != null) {

				Train train = new Train();
				String[] tokens = line.split(COMMA_DELIMITER);// separator

				if (tokens.length > 0) {
					train.setName(tokens[0]);
					train.setFromto(tokens[1]);
					train.setDuration(Integer.parseInt(tokens[2]));
					train.setAvail(Integer.parseInt(tokens[3]));

					if (tokens[4].equals("PASSENGER"))
						train.type = Train.Type.PASSENGER;
					else
						train.type = Train.Type.GOODS;
				}
				trainList.add(train);

			}
		} catch (FileNotFoundException e) {
			System.out.println("error in input");
		} catch (IOException e) {
			System.out.println("error in input");
		} finally {

			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("error in file input");

			}

		}

		Collections.sort(trainList, Train.trainDuration);
	}

	private static void showChart(Train.Type type, String fromto) {
		for (Train train : trainList) {
			if (train.type.equals(type) && train.getFromto().equals(fromto)) {

				System.out.println(train.getName() + "    "
						+ train.getDuration() + " hrs" + "    "
						+ train.getAvail());

			}

		}

	}

	private static void showChart(Train.Type type) {

		for (Train train : trainList) {
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
		for (Train train : trainList) {
			if (train.getName().equals(trainName))
				return train.getAvail();

		}

		return -1;

	}

	private static void InputProcess() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out
					.println("welcome to Railways ticket booking center Enter your name");
			String name = scanner.next();
			System.out.println("enter train type\n1-Passenger\n2-goods");
			int input = scanner.nextInt();
			Train.Type type;
			if (input == 1)
				type = Train.Type.PASSENGER;
			else
				type = Train.Type.GOODS;
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
				if (in == 1) {
					CcPayment ccPayment = new CcPayment();
					ccPayment.process(amount);

				} else if (in == 2) {
					WalletPayment walletPayment = new WalletPayment();
					walletPayment.process(amount);

				} else {
					NetBankingPayment bankingPayment = new NetBankingPayment();
					bankingPayment.process(amount);

				}

				for (Train train : trainList) {

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

	public static void main(String args[]) {

		prepareTrain();
		InputProcess();

	}

}

class Train {

	private String name;
	private String fromto;
	private int duration;
	private int avail;

	public enum Type {
		PASSENGER, GOODS
	}

	public Type type;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFromto() {
		return fromto;
	}

	public void setFromto(String fromto) {
		this.fromto = fromto;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getAvail() {
		return avail;
	}

	public void setAvail(int avail) {
		this.avail = avail;
	}

	public static Comparator<Train> trainDuration = new Comparator<Train>() {

		public int compare(Train t1, Train t2) {

			int duration1 = t1.getDuration();
			int duration2 = t2.getDuration();

			/*
			 * For ascending order
			 */
			return duration1 - duration2;

		}
	};
}

abstract class Payment {

	

	public void process(int amount){} 
}
 class CcPayment extends Payment {

	public void process(int amount) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Cradit Card number");
		int ccno = scanner.nextInt();
		System.out.println("Enter Cvv");
		int cvv = scanner.nextInt();
		
		System.out.println("Your ticket is being successfully boocked");
	}

}

class WalletPayment extends Payment {

	public void process(int amount) {
	
		System.out.println("Your ticket is being successfully boocked");
	}

}

class NetBankingPayment extends Payment {

	public void process(int amount) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Bank Name");
		String bank = scanner.next();
		System.out.println("Enter username");
		String username = scanner.next();
		System.out.println("Enter password");
		String password = scanner.next();

		System.out.println("Your ticket is being successfully boocked");
	}

}
