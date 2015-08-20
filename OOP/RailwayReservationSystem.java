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

	public static void main(String args[]) {

		prepareTrain();
		InputAction.InputProcess();

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

			return duration1 - duration2;

		}
	};
}

abstract class Payment {

	public void process(int amount) {
	}
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
