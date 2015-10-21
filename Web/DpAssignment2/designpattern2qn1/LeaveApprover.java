package designpattern2qn1;

abstract class Approver {
	protected Approver successor;

	public void SetSuccessor(Approver successor) {
		this.successor = successor;
	}

	public abstract String ProcessRequest(int purchase);
}

class Mentor extends Approver {
	@Override
	public String ProcessRequest(int leave) {
		if (leave <= 1) {
			return "leave approved by mentor";
		} else if (successor != null) {
			return successor.ProcessRequest(leave);
		} else {
			return "";

		}
	}
}

class SeniorMentor extends Approver {
	@Override
	public String ProcessRequest(int leave) {
		if (leave <= 2) {
			return "leave approved by senior mentor";
		} else if (successor != null) {
			return successor.ProcessRequest(leave);
		} else {
			return "";

		}
	}
}

class HrManager extends Approver {
	@Override
	public String ProcessRequest(int leave) {
		if (leave <= 5) {
			return "leave approve by hr manager";
		} else if (successor == null) {
			return "can't grant leave more than 5 days";
		} else
			return "";
	}
}

public class LeaveApprover {

	public static void main(String arg[]) {
		Approver larry = new Mentor();
		Approver sam = new SeniorMentor();
		Approver tammy = new HrManager();

		larry.SetSuccessor(sam);
		sam.SetSuccessor(tammy);

		System.out.println(larry.ProcessRequest(6));
	}
}