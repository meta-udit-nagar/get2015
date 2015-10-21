package designpattern2qn2;

public class Test extends Cricket {

	
	@Override
	void timeOfGame() {
		 System.out.println("Test International is 5 days game");

	}

	@Override
	void ticketrate() {
		 System.out.println("ticket rate=200-20000 per day");
	}

	@Override
	void nOfOvers() {
		 System.out.println("no of overs=unlimited per team");		
	}
}
