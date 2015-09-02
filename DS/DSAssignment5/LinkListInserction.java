import java.util.LinkedList;
import java.util.List;

public class LinkListInserction {
	private int index = 0;
	private List<Integer> list = new LinkedList<Integer>();

	public void insert(int item) {

		if (index == list.size()) {

			list.add(item);
			index = 0;
		} else

		if ((int) list.get(index) < item) {
			index++;
			insert(item);

		} else {
			list.add(index, item);
			index = 0;
		}

	}

	public List<Integer> display() {

		return list;

	}

}
