package designpattern2qn2;

public class T20 extends Cricket {

	
	@Override
	void timeOfGame() {
		 System.out.println("T20 International is 3 hrs game");

	}

	@Override
	void ticketrate() {
		 System.out.println("ticket rate=200-20000");
	}

	@Override
	void nOfOvers() {
		 System.out.println("no of overs=20 per team");		
	}
}
