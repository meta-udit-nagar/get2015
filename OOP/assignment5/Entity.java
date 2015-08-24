
import java.util.ArrayList;

public class Entity {
	String email;
	String name;
	ArrayList<String> friends = new ArrayList<String>();

	public Entity(String email, String name) {
		this.email = email;
		this.name = name;
	}

}
