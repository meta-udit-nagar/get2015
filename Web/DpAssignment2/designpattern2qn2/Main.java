package designpattern2qn2;

public class Main {

	public static void main(String arg[]) {

		Cricket cricket = new T20();
		cricket.play();
		System.out.println();
		cricket = new Test();
		cricket.play();
		System.out.println();
		cricket = new OneDay();
		cricket.play();
	}

}
