package pOJOClasses;

import java.sql.Date;

public class Book_return {

	private Date return_date;
	private int accession_no;
	private int member_id;
	private Date issure_date;

	public Date getReturn_date() {
		return return_date;
	}

	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
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

	public Date getIssure_date() {
		return issure_date;
	}

	public void setIssure_date(Date issure_date) {
		this.issure_date = issure_date;
	}

}
