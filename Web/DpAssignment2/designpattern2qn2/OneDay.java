package designpattern2qn2;

public class OneDay extends Cricket {

	
	@Override
	void timeOfGame() {
		 System.out.println("One Day International is 1 day game");

	}

	@Override
	void ticketrate() {
		 System.out.println("ticket rate=500-200000");
	}

	@Override
	void nOfOvers() {
		 System.out.println("no of overs=50 per team");		
	}
}
