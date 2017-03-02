package io.github.cho3en1.model;

public class StuInfo {
	private int id;
	private String name;
	private byte sex;
	private String birthday;
	private String major;
	private String[] course = {""};
	private String courses = "";
	private String[] hobby = {""};
	private String hobbys = "";
	public StuInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StuInfo(int id, String name, byte sex, String birthday, String major, String[] course, String courses,
			String[] hobby, String hobbys) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.major = major;
		this.course = course;
		this.courses = courses;
		this.hobby = hobby;
		this.hobbys = hobbys;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte getSex() {
		return sex;
	}
	public void setSex(byte sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String[] getCourse() {
		return course;
	}
	public void setCourse(String[] course) {
		this.course = course;
	}
	public String getCourses() {
		if(course!=null) {
			for (int i=0; i<course.length; i++) {
				courses += course[i] + "&";
			}
			courses = courses.substring(0, courses.length()-1);
		}
		return courses;
	}
	public void setCourses(String courses) {
		this.courses = courses;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getHobbys() {
		if(hobby!=null) {
			for (int i=0; i<hobby.length; i++) {
				hobbys += hobby[i] + "&";
			}
			hobbys = hobbys.substring(0, hobbys.length()-1);
		}
		return hobbys;
	}
	public void setHobbys(String hobbys) {
		this.hobbys = hobbys;
	}
	
	
}
