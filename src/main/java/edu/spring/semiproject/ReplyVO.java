package edu.spring.semiproject;

public class ReplyVO {

	int rno, mno, bno;
	String replycontent, replyregdate;
	
	public ReplyVO() {}
	public ReplyVO(int rno, int mno, int bno, String replycontent, String replyregdate) {
		super();
		this.rno = rno;
		this.mno = mno;
		this.bno = bno;
		this.replycontent = replycontent;
		this.replyregdate = replyregdate;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getReplycontent() {
		return replycontent;
	}
	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}
	public String getreplyregdate() {
		return replyregdate;
	}
	public void setreplyregdate(String replyregdate) {
		this.replyregdate = replyregdate;
	}
	
	
	
}
