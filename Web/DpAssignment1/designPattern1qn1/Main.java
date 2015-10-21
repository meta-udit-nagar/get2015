package designPattern1qn1;

public class Main {

	public static void main(String args[]) {
		try {
			int x = 5 / 0;
			System.out.println("x= " + x);
		} catch (ArithmeticException e) {

			Logger.getInsrtance().logError("Divide by zero exception");
			System.out.println("Divide by zero exception");
		}
		try {
			int x = Integer.parseInt("hello");
			System.out.println("x= " + x);
		} catch (NumberFormatException e) {
			Logger.getInsrtance().logError("Number Format Exception");
		}
	}
}
