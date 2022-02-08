package org.spring.my.dto;

public class Thumbnail {
	private int tnum;
	private int anum;
	private String filename;
	
	public Thumbnail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTnum() {
		return tnum;
	}
	public void setTnum(int tnum) {
		this.tnum = tnum;
	}
	public int getAnum() {
		return anum;
	}
	public void setAnum(int anum) {
		this.anum = anum;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	@Override
	public String toString() {
		return "Thumbnail [tnum=" + tnum + ", anum=" + anum + ", filename=" + filename + "]";
	}
}
