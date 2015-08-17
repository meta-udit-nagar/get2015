import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SurveySystem {

	static ArrayList<Participant> participantList = new ArrayList<Participant>();
	static ArrayList<Question> questionList = new ArrayList<Question>();

	static ArrayList<Question> genrateQuestions() {

		final String COMMA_DELIMITER = ",";
		final String url = "D://Question/question.csv";
		ArrayList<Question> questionList = new ArrayList<Question>();

		BufferedReader fileReader = null;
		try {

			String line = "";
			fileReader = new BufferedReader(new FileReader(url));// file reading
			fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {

				Question question = new Question();
				String[] tokens = line.split(COMMA_DELIMITER);// separator
				if (tokens.length > 0) {
					question.setOptions(tokens[2]);
					question.setQuestion(tokens[0]);
					if (tokens[1].equals("Multi Select"))
						question.type = Question.Type.Multi_Select;
					else if (tokens[1].equals("Single Select"))
						question.type = Question.Type.Single_select;
					else
						question.type = Question.Type.Text;

				}
				questionList.add(question);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		return questionList;

	}

	static ArrayList<Participant> inputProcess(ArrayList<Question> questionList) {
		Scanner scanner = new Scanner(System.in);

		Participant participant = new Participant();
		ArrayList<String> questionsAnswered = new ArrayList<String>();
		System.out.println("Enter participant name");
		String name = scanner.next();
		participant.setName(name);
		for (Question question : questionList) {

			System.out.println(question.getQuestion());
			questionsAnswered.add(scanner.next());

		}
		participant.setQuestionAnswered(questionsAnswered);
		participantList.add(participant);

		System.out.println("do u want to continue?y/n");
		if (scanner.next().equals("y")) {
			System.out.print("hello");

			return inputProcess(questionList);

		} else {

			return participantList;
		}
	}

	static void genrateReport(int flag, ArrayList<Question> questList,
			ArrayList<Participant> participantList) {

		if (flag == 0) {

			ArrayList<Integer> SQ = new ArrayList<Integer>();
			int i = 0;
			for (Question question : questList) {
				System.out.println(question.getType());
				if (question.getType().toString().equals("Single_select")) {

					SQ.add(i);

				}

				i++;

			}

			for (int j : SQ) {

				HashMap<String, Integer> hm = new HashMap<String, Integer>();

				for (Participant participant : participantList) {

					String ans = participant.getQuestionAnswered().get(j);
					System.out.println(ans);
					hm.put(ans, 0);
					for (String key : hm.keySet()) {
						int f = 0;
						System.out.println(key);
						if (key.equals(ans)) {
							f = 1;
							int x = hm.get(key);
							hm.put(key, ++x);
						}
						if (f == 0) {
							hm.put(ans, 1);

						}

					}
					int sum = 0;
					for (String key : hm.keySet()) {

						sum = sum + hm.get(key);

					}

					System.out.println("Report qn no " + j + 1);
					for (String key : hm.keySet()) {
						double per = ((double) hm.get(key) / sum) * 100;
						System.out.println(key + " " + per + "%");
					}

				}

			}
		} else {

			for (Participant participant : participantList) {
				int i = 0;

				System.out.println(participant.name);
				for (Question question : questList) {

					System.out.println(question.getQuestion());
					System.out.println(participant.questionAnswered.get(i++));

				}

			}

		}

	}

	public static void main(String args[]) {

		questionList = genrateQuestions();
		participantList = inputProcess(questionList);
		genrateReport(0, questionList, participantList);
		genrateReport(1, questionList, participantList);
	}

}

class Question {
	public enum Type {
		Single_select, Multi_Select, Text
	}

	public Type type;
	private String Question;
	private String options;

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public Question() {
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}

class Participant {
	String name;
	ArrayList<String> questionAnswered;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getQuestionAnswered() {
		return questionAnswered;
	}

	public void setQuestionAnswered(ArrayList<String> questionAnswered) {
		this.questionAnswered = questionAnswered;
	}

}
