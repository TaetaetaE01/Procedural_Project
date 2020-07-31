package valueObject;

import java.util.ArrayList;
import java.util.Vector;

public class VLecture {
	private String id;
	private String name;
	private String professor;
	private String credit;
	private String time;
	//public ArrayList lecture = new ArrayList<>();
	//public Vector<String> vLectures = new Vector<String>();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
}
