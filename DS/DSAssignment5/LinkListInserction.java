import java.util.LinkedList;
import java.util.List;

public class LinkListInserction {
	private int index;
	public List<Integer> list = new LinkedList<Integer>();

	public void insert(int item) {

		if (index == list.size()) {

			list.add(item);
		} else

		if ((int) list.get(index) < item) {
			index++;
			insert(item);

		} else {
			list.add(index, item);
		}

	}

}
