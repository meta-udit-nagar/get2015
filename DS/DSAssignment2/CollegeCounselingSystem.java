import java.util.ArrayList;
import java.util.Scanner;

class Student {
	private String name;
	private int rank;

	public Student(String name, int rank) {
		this.name = name;
		this.rank = rank;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}

class College {
	private String name;
	private int noOfSeatsAvailable;

	public College(String name, int noOfSeatsAvailable) {

		this.name = name;
		this.noOfSeatsAvailable = noOfSeatsAvailable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfSeatsAvailable() {
		return noOfSeatsAvailable;
	}

	public void setNoOfSeatsAvailable(int noOfSeatsAvailable) {
		this.noOfSeatsAvailable = noOfSeatsAvailable;
	}

}

public class CollegeCounselingSystem {

	private static ArrayList<Student> studentList = new ArrayList<Student>();
	private static ArrayList<College> collegeList = new ArrayList<College>();
	private static Queue studentQueue;

	public CollegeCounselingSystem() {
		studentList.add(new Student("udit10", 10));
		studentList.add(new Student("udit9", 9));
		studentList.add(new Student("udit8", 8));
		studentList.add(new Student("udit7", 7));
		studentList.add(new Student("udit6", 6));
		studentList.add(new Student("udit5", 5));
		studentList.add(new Student("udit4", 4));
		studentList.add(new Student("udit3", 3));
		studentList.add(new Student("udit2", 2));
		studentList.add(new Student("udit1", 1));
		studentList.add(new Student("udit11", 11));
		studentList.add(new Student("udit12", 12));

		collegeList.add(new College("college1", 5));
		collegeList.add(new College("college2", 5));
		collegeList.add(new College("college3", 5));
		collegeList.add(new College("college4", 5));
		collegeList.add(new College("college5", 5));
	}

	private void enqueueStudents() {

		studentQueue = new Queue(100);

		for (int count = 1; count <= studentList.size(); count++) {
			for (Student student : studentList) {

				if (student.getRank() == count) {
					studentQueue.enqueue(student);

				}

			}

		}

	}

	private static void printCollageList() {
		int i = 1;
		for (College college : collegeList) {
			System.out.println(i + "   " + college.getName());
			i++;
		}

	}

	private void councelingProcess() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			Student student = (Student) studentQueue.dequeue();
			if (student != null) {
				System.out.println("Hello " + student.getName() + " with rank "
						+ student.getRank());
				System.out.println("Enter your choice");
				printCollageList();
				int choice = scanner.nextInt();
				College college = collegeList.get(choice - 1);
				if (college.getNoOfSeatsAvailable() > 0) {
					college.setNoOfSeatsAvailable(college
							.getNoOfSeatsAvailable() - 1);
					System.out
							.println("congo you have alloted the asked collage");
				} else {
					System.out
							.println("not available you are transfer to next round");
					studentQueue.enqueue(student);

				}

			} else {
				break;
			}
		}
	}

	public static void main(String args[]) {
		CollegeCounselingSystem collegeCounselingSystem = new CollegeCounselingSystem();
		collegeCounselingSystem.enqueueStudents();
		collegeCounselingSystem.councelingProcess();
	}

}
