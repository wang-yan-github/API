package cn.wangyanfsd.api.bean;

import java.io.Serializable;

public class BslcZzlc implements Serializable {

	private static final long serialVersionUID = -3288154435869124773L;
	
	private Integer id;
	private String title;
	private String Content;
	private String date;
	private String person;
	
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
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
}
