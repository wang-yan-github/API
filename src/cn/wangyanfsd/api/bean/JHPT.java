package cn.wangyanfsd.api.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class JHPT {
	@Id
	private  int id; // ID
	private String YXT; // Դϵͳ
	private String MBXT; // Ŀ��ϵͳ
	private String YB; // Դ��
	private String MBB; // Ŀ���
	private String SCJL; // �����¼
	private String XZHS; // ��������
	private String GXHS;// ��������
	private String CWHS; // ��������
	private String ZT; // ״̬
	private Date KSSJ; // ��ʼʱ��
	private Date JSSJ; // ����ʱ��
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYXT() {
		return YXT;
	}
	public void setYXT(String yXT) {
		YXT = yXT;
	}
	public String getMBXT() {
		return MBXT;
	}
	public void setMBXT(String mBXT) {
		MBXT = mBXT;
	}
	public String getYB() {
		return YB;
	}
	public void setYB(String yB) {
		YB = yB;
	}
	public String getMBB() {
		return MBB;
	}
	public void setMBB(String mBB) {
		MBB = mBB;
	}
	public String getSCJL() {
		return SCJL;
	}
	public void setSCJL(String sCJL) {
		SCJL = sCJL;
	}
	public String getXZHS() {
		return XZHS;
	}
	public void setXZHS(String xZHS) {
		XZHS = xZHS;
	}
	public String getGXHS() {
		return GXHS;
	}
	public void setGXHS(String gXHS) {
		GXHS = gXHS;
	}
	public String getCWHS() {
		return CWHS;
	}
	public void setCWHS(String cWHS) {
		CWHS = cWHS;
	}
	public String getZT() {
		return ZT;
	}
	public void setZT(String zT) {
		ZT = zT;
	}
	public Date getKSSJ() {
		return KSSJ;
	}
	public void setKSSJ(Date kSSJ) {
		KSSJ = kSSJ;
	}
	public Date getJSSJ() {
		return JSSJ;
	}
	public void setJSSJ(Date jSSJ) {
		JSSJ = jSSJ;
	}
	@Override
	public String toString() {
		return "JHPT [id=" + id + ", YXT=" + YXT + ", MBXT=" + MBXT + ", YB=" + YB + ", MBB=" + MBB + ", SCJL=" + SCJL
				+ ", XZHS=" + XZHS + ", GXHS=" + GXHS + ", CWHS=" + CWHS + ", ZT=" + ZT + ", KSSJ=" + KSSJ + ", JSSJ="
				+ JSSJ + "]";
	}
	
}
