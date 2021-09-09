package edu.spring.semiproject;

public class RecommendVO {

	int recommendno, mno, bno;

	public RecommendVO() {}
	public RecommendVO(int recommendno, int mno, int bno) {
		super();
		this.recommendno = recommendno;
		this.mno = mno;
		this.bno = bno;
	}

	public int getRecommendno() {
		return recommendno;
	}

	public void setRecommendno(int recommendno) {
		this.recommendno = recommendno;
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
	
	
}
