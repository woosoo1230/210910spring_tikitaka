package edu.spring.semiproject;

public class ReplyVO {

	int rno, mno;
	String replycontent, replydate;
	
	public ReplyVO() {}
	public ReplyVO(int rno, int mno, String replycontent, String replydate) {
		super();
		this.rno = rno;
		this.mno = mno;
		this.replycontent = replycontent;
		this.replydate = replydate;
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
	public String getReplycontent() {
		return replycontent;
	}
	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}
	public String getReplydate() {
		return replydate;
	}
	public void setReplydate(String replydate) {
		this.replydate = replydate;
	}
	
	
	
}
