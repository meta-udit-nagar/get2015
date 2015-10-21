package designpattern2qn2;

public abstract class Cricket {
	abstract void nOfOvers();

	abstract void timeOfGame();

	abstract void ticketrate();

	// template method
	public final void play() {

		nOfOvers();
		timeOfGame();
		ticketrate();
	}
}