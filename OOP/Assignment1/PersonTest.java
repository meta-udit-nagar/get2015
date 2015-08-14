import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetUid1() {
		Person person = new Person(101, "udit");
		assertEquals(101, person.getUid());
	}

	public void testGetUid2() {
		Person person = new Person(100, "udit");
		assertEquals(100, person.getUid());
	}

	public void testGetUid3() {
		Person person = new Person(45, "udit");
		assertEquals(45, person.getUid());
	}

	@Test
	public void testSsetUid1() {
		Person person = new Person(100, "udit");
		person.setUid(101);
		assertEquals(101, person.getUid());
	}

	public void testSsetUid2() {
		Person person = new Person(11, "udit");
		person.setUid(121);
		assertEquals(121, person.getUid());
	}

	public void testSsetUid3() {
		Person person = new Person(100, "udit");
		person.setUid(101);
		assertEquals(101, person.getUid());
	}

	@Test
	public void testGetName() {
		Person person = new Person(100, "udit");
		assertEquals(100, person.getUid());
	}

	@Test
	public void testSetName() {
		Person person = new Person(100, "udit");
		assertEquals("udit", person.getName());
	}

	@Test
	public void testToString() {
		Person person = new Person(100, "udit");
		assertEquals("Name:udit, uid:" + 100, person.toString());
	}

	@Test
	public void testToStringStudent1() {
		Student student = new Student(100, "udit", 1001);
		assertEquals("Name:udit, uid:100, StudentId:1001", student.toString());
	}

	public void testToStringStudent2() {
		Student student = new Student(101, "john", 1002);
		assertEquals("Name:john, uid:101, StudentId:1002", student.toString());
	}

	@Test
	public void testSetCource() {
		Student student = new Student(100, "john", 1001);
		String expected[] = { "c", "c++", "java" };
		String course[] = { "c", "c++", "java" };
		student.setCources(course);
		assertArrayEquals(expected, student.getCourses());
	}

	@Test
	public void testGetCource() {
		Student student = new Student(100, "udit", 1234);
		String course[] = { "c", "c++", "java" };
		String expected[] = { "c", "c++", "java" };
		student.setCources(course);
		assertArrayEquals(expected, student.getCourses());
	}

}
