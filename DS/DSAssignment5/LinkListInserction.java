import java.util.LinkedList;
import java.util.List;

public class LinkListInserction {

	public List<Integer> list = new LinkedList<Integer>();

	public void insert(int item, int index) {

		if (index == list.size()) {

			list.add(item);
		} else

		if ((int) list.get(index) < item) {

			insert(item, index + 1);

		} else {
			list.add(index, item);
		}

	}

}