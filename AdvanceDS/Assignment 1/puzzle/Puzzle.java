import java.util.*;


public class Puzzle {


	public State initialState;


	public State state;


	static final int CAPACITY = 100;


	public final PriorityQueue<State> queue = new PriorityQueue<State>(CAPACITY, new Comparator<State>() {
		@Override
		public int compare(State o1, State o2) {
			return o1.f() - o2.f();
		}
	});


	public final HashSet<State> visited = new HashSet<State>();


	public Puzzle(int[] puzzleInput) {
		this.initialState = new State(puzzleInput);
		this.state = this.initialState;
	}

	
	public boolean isSolvable() 
	{
		int inversions = 0;
		int[] p = this.state.array;
		
		for(int i = 0; i < p.length - 1; i++) 
		{
			for(int j = i + 1; j < p.length; j++)
			{
				if(p[i] > p[j])
				{
					inversions++;
				}
			}
			
			if(p[i] == 0 && i % 2 == 1)
			{
				inversions++;
			}
		}
		
		return (inversions % 2 == 0);
	}

	
	public static int getHeuristic(int[] array) 
	{
		int heuristic = 0;
		for(int i = 0; i < array.length; i++) 
		{
			if (array[i] != 0)
			{
				heuristic += getManhattanDistance(i, array[i]);
			}
		}
		
		return heuristic;
	}

		public static int getManhattanDistance(int index, int number) 
	{
		return Math.abs((index / 3) - ((number-1) / 3)) + Math.abs((index % 3) - ((number-1) % 3));
	}

	private void addToQueue(State nextState) 
	{
		if(nextState != null && !this.visited.contains(nextState)) 
		{
			this.queue.add(nextState);
		}
	}

public void solve() 
	{
		
		queue.clear();
		queue.add(this.initialState);

		while(!queue.isEmpty()) 
		{
			
			this.state = queue.poll();

			
			if (this.state.isSolved()) 
			{
				System.out.println(this.state.solutionMessage());
				return;
			}

			
			visited.add(state);

			
			this.addToQueue(Move.up(state));
			this.addToQueue(Move.down(state));
			this.addToQueue(Move.left(state));
			this.addToQueue(Move.right(state));
		}
	}
}