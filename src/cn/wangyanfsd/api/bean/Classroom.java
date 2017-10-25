package cn.wangyanfsd.api.bean;

import java.io.Serializable;

public class Classroom implements Serializable {
	private static final long serialVersionUID = 5163510089759416284L;
	private Integer classId;
	private String className;
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "Classroom [classId=" + classId + ", className=" + className + "]";
	}
}
