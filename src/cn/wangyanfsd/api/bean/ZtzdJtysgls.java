package cn.wangyanfsd.api.bean;

import java.io.Serializable;

public class ZtzdJtysgls implements Serializable {

	private static final long serialVersionUID = 6181377375672698966L;
	
	private Integer id;
	private String title;
	private String content;
	private String date;
	private String Person;
	private String department; // 科室
	private String quality; // 性质
	private String people; // 人数
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPerson() {
		return Person;
	}
	public void setPerson(String person) {
		Person = person;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
}
