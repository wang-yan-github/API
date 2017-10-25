package cn.wangyanfsd.api.bean;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/*@Entity(name="tb_gxzdcwgk")
@Table(name="tb_gxzdcwgk")*/
public class GxzdCwgk implements Serializable {
	private static final long serialVersionUID = 5163510089759416284L;
	/*@Id
	@Column(length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")*/
	private Integer Id;
	private String Name;
	/*@Lob 
	@Basic(fetch = FetchType.LAZY) 
	@Column(name="DtaContent", columnDefinition="CLOB", nullable=true) */
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
