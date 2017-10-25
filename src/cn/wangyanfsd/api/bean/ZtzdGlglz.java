package cn.wangyanfsd.api.bean;

import java.io.Serializable;
import java.util.Date;

public class ZtzdGlglz implements Serializable {
	private static final long serialVersionUID = 5163510089759416284L;
	private Integer Id;
	private String Name;
	private String Content;
	private String Date;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
