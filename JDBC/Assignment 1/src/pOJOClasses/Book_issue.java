package pOJOClasses;

import java.sql.Date;


public class Book_issue {

	
	private Date issue_date;
	private int accession_no;
	private int member_id;
	private Date due_date;
	public Date getIssue_date() {
		return issue_date;
	}
	public void setIssue_date(Date issue_date) {
		this.issue_date = issue_date;
	}
	public int getAccession_no() {
		return accession_no;
	}
	public void setAccession_no(int accession_no) {
		this.accession_no = accession_no;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	
}
