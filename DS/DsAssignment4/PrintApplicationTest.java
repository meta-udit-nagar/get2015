import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class PrintApplicationTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testProcessRequestIfPrinterIsBuzy() {

		PrintApplication application = new PrintApplication();
		application.printerStatus = false;// making printer busy
		String expected = "you are in queue...plz wait for some time";
		Task task = new Task(4);
		assertEquals(expected, application.processRequest(task));
	}

	@Test
	public void testProcessRequestIfPrinterIsFree() {

		PrintApplication application = new PrintApplication();
		application.printerStatus = true;// making printer free
		String expected = "dear chairman your documents are ready to print";
		Task task = new Task(4);
		assertEquals(expected, application.processRequest(task));
	}

	@Test
	public void testProcessRequestIfRequestComeWhileProcessingQueue() {

		PrintApplication application = new PrintApplication();
		application.printerStatus = false;// making printer busy to prepare
											// queue
		Task task1 = new Task(4);
		application.processRequest(task1);
		Task task2 = new Task(2);
		application.processRequest(task2);

		application.printerStatus = true;// printer become free
		Task newTask = new Task(4);
		String expected = "you are in queue...plz wait for some time";
		assertEquals(expected, application.processRequest(newTask));
	}

	@Test
	public void testProcessQueue() {
		PrintApplication application = new PrintApplication();
		application.printerStatus = false;// making printer busy to prepare
											// queue
		Task task1 = new Task(2);
		application.processRequest(task1);
		Task task2 = new Task(4);
		application.processRequest(task2);

		application.printerStatus = true;
		String expected = "dear chairman your documents are ready to print/dear graduate Student your documents are ready to print/";
		assertEquals(expected, application.processQueue());

	}

}
