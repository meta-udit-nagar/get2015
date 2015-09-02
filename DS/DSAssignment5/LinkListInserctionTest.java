import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class LinkListInserctionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testInsertAtMid() {
		LinkListInserction inserction = new LinkListInserction();
		inserction.list.add(1);
		inserction.list.add(6);
		inserction.list.add(3);
		inserction.list.sort(null);
		inserction.insert(2);
		List<Integer> expectedList = new LinkedList<Integer>();
		expectedList.add(1);
		expectedList.add(2);
		expectedList.add(3);
		expectedList.add(6);
		assertEquals(expectedList, inserction.list);

	}

	@Test
	public void testInsertAtFirst() {
		LinkListInserction inserction = new LinkListInserction();
		inserction.list.add(1);
		inserction.list.add(6);
		inserction.list.add(3);
		inserction.list.sort(null);
		inserction.insert(0);
		List<Integer> expectedList = new LinkedList<Integer>();
		expectedList.add(0);
		expectedList.add(1);
		expectedList.add(3);
		expectedList.add(6);
		assertEquals(expectedList, inserction.list);

	}

	@Test
	public void testInsertAtLast() {
		LinkListInserction inserction = new LinkListInserction();
		inserction.list.add(1);
		inserction.list.add(6);
		inserction.list.add(3);
		inserction.list.sort(null);
		inserction.insert(9);
		List<Integer> expectedList = new LinkedList<Integer>();
		expectedList.add(1);
		expectedList.add(3);
		expectedList.add(6);
		expectedList.add(9);
		assertEquals(expectedList, inserction.list);

	}

}
