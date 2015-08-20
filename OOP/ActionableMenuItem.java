import java.io.IOException;



public class ActionableMenuItem implements MenuItem{
Action action = new InputAction();
	String displayText; 
	
	ActionableMenuItem(String displayText) {
		this.displayText = displayText;
	}
	@Override
	public void display() {
		System.out.println(displayText);
		
	}

	@Override
	public void takeAction(int input) {	
		action.perform(input);
		}
		
	}


