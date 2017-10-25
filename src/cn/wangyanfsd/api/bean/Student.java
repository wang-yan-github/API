package cn.wangyanfsd.api.bean;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = -600750444151382927L;
	private Integer studentId;
	private String userName;
	private String passWord;
	private Classroom classroom;
	public Student() {
	}
	public Student(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}
	public Student(Integer studentId, String userName, String passWord) {
		this(userName, passWord);
		this.studentId = studentId;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	@Override
	public String toString() {
		return "Student [passWord=" + passWord + ", studentId=" + studentId
				+ ", userName=" + userName + "]";
	}
}
