package edu.spring.semiproject;

import org.springframework.web.multipart.MultipartFile;

public class UploadVO {

	int uploadno, bno;
	//MultipartFile filename;
	String filename;
	public UploadVO() {}
	public UploadVO(int uploadno, int bno, String filename) {
		super();
		this.uploadno = uploadno;
		this.bno = bno;
		this.filename = filename;
	}
	public int getUploadno() {
		return uploadno;
	}
	public void setUploadno(int uploadno) {
		this.uploadno = uploadno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
