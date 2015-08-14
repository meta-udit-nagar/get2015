import java.util.ArrayList;
import java.util.Scanner;

public class SurveyApplication {
	private static ArrayList<Question> questionList = new ArrayList<Question>();
	private static ArrayList<Particpant> participantList = new ArrayList<Particpant>();

	public static void main(String args[]) {
		questionList.add(new Question("Text", "Give your brief feedback"));
		questionList.add(new Question("Multiple Choice",
				"how do you rate our company?\n1-excillent 2-good 3-bad"));
		questionList
				.add(new Question(
						"Multiple Selected",
						"what are the qualities of our company\nfreedom/healthy environment/low work load/good boses"));
		int good = 0;
		int excillent = 0;
		int bad = 0;
		String personName = "";
		Scanner scanner = new Scanner(System.in);
		while (true) {

			System.out.println("******Starting the Survry**********");
			System.out.println("Enter the name of person ?");
			personName = scanner.nextLine();
			System.out.println("Starting of questions");
			Question question[] = new Question[3];
			int i = 0;

			for (Question question1 : questionList) {

				String answer = "";
				System.out.println(question1.getQuestion());
				if (question1.getType().equals("Text")) {
					answer = scanner.next();
				} else if (question1.getType().equals("Multiple Choice")) {
					int type = scanner.nextInt();
					if (type == 1) {
						answer = "excillent";
						excillent++;

					} else if (type == 2) {

						answer = "good";
						good++;

					} else if (type == 3) {
						answer = "bad";
						bad++;

					} else {

						System.out.println("wrong input restart the survey");
						break;
					}

				} else {

					while (true) {

						String ans = scanner.next();
						answer = answer + ans + " ";

						System.out
								.println("Do you want to add more qualities ?y/n");
						String choice = scanner.next();
						if (choice.equals("n")) {

							break;

						} else {
							System.out.println(question1.getQuestion());

						}

					}

				}

				question1.setAnswer(answer);
				answer = null;
				question[i++] = question1;

			}

			participantList.add(new Particpant(personName, 101, question));

			System.out
					.println("Do you want to continue the survey for another person?...y/n");
			String result = scanner.next();
			if (result.equals("n")) {

				break;

			}

		}

		System.out.println("overall rating : single select 1/2/3\n");

		int per = (excillent / participantList.size()) * 100;
		System.out.println("1.excillent " + per + "\n");

		per = (good / participantList.size()) * 100;
		System.out.println("2.Good " + per + "\n");

		per = (bad / participantList.size()) * 100;
		System.out.println("2.Bad " + per + "\n");

		for (Particpant particpant : participantList) {

			System.out.println("Name of participant :" + particpant.getName());

			System.out.println("******Answers**********");

			for (int i = 0; i < particpant.getQuestion().length; i++) {
				System.out.println("Qn " + i + 1
						+ particpant.getQuestion()[i].getQuestion());
				System.out.println("Answer :"
						+ particpant.getQuestion()[i].getAnswer());

			}
		}

	}

}

class Question {

	private String type;
	private String question;
	private String answer;

	public Question(String type, String question) {

		this.type = type;
		this.question = question;

	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}

class Particpant {

	private String name;
	private int participantId = 0;
	private Question question[];

	public Particpant(String name, int participantId, Question[] question) {
		this.name = name;
		this.participantId = participantId;
		this.question = question;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	public Question[] getQuestion() {
		return question;
	}

	public void setQuestion(Question[] question) {
		this.question = question;
	}

}