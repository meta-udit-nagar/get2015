import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.BeforeClass;
import org.junit.Test;

public class QueueTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testEnqueueInteger() {
		Queue<Integer> queueObject = new Queue<Integer>();
		queueObject.enqueue(2);
		queueObject.enqueue(5);
		LinkedList<Integer> expectedList = new LinkedList<Integer>();
		expectedList.add(2);
		expectedList.add(5);
		assertEquals(expectedList, queueObject.queue);

	}

	@Test
	public void testEnqueueString() {
		Queue<String> queueObject = new Queue<String>();
		queueObject.enqueue("hello");
		queueObject.enqueue("world");
		LinkedList<String> expectedList = new LinkedList<String>();
		expectedList.add("hello");
		expectedList.add("world");
		assertEquals(expectedList, queueObject.queue);

	}

	@Test
	public void testDequeue() {

		Queue<Integer> queueObject = new Queue<Integer>();
		queueObject.enqueue(1);
		queueObject.enqueue(3);
		int expected = 1;
		int x = queueObject.dequeue();
		assertEquals(expected, x);

		expected = 3;
		x = queueObject.dequeue();
		assertEquals(expected, x);
	}

}
