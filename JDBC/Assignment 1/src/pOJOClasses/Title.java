package pOJOClasses;

public class Title {

	private int title_id;
	private String title_name;
	private int subject_id;
	private int publisher_id;

	public int getTitle_id() {
		return title_id;
	}
	
	public void setTitle_id(int title_id) {
		this.title_id = title_id;
	}

	public int getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}

	public int getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}

	public String getTitle_name() {
		return title_name;
	}

	public void setTitle_name(String title_name) {
		this.title_name = title_name;
	}

	public Title(int title_id, String title_name, int subject_id,
			int publisher_id) {
		super();
		this.title_id = title_id;
		this.title_name = title_name;
		this.subject_id = subject_id;
		this.publisher_id = publisher_id;
	}
	
	
	public Title()
	{}

	@Override
	public String toString() {
		return "Title [title_id=" + title_id + ", title_name=" + title_name
				+ ", subject_id=" + subject_id + ", publisher_id="
				+ publisher_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + publisher_id;
		result = prime * result + subject_id;
		result = prime * result + title_id;
		result = prime * result
				+ ((title_name == null) ? 0 : title_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Title other = (Title) obj;
		if (publisher_id != other.publisher_id)
			return false;
		if (subject_id != other.subject_id)
			return false;
		if (title_id != other.title_id)
			return false;
		if (title_name == null) {
			if (other.title_name != null)
				return false;
		} else if (!title_name.equals(other.title_name))
			return false;
		return true;
	}



}
