package edu.spring.semiproject;

public class BoardVO {

	int bno;
	String subject, content, regdate;
	int readnum, recommend, mno;
	
	public BoardVO() {}
	public BoardVO(int bno, String subject, String content, String regdate, int readnum, int recommend, int mno) {
		super();
		this.bno = bno;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
		this.readnum = readnum;
		this.recommend = recommend;
		this.mno = mno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getReadnum() {
		return readnum;
	}
	public void setReadnum(int readnum) {
		this.readnum = readnum;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	
	
}
