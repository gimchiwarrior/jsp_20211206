package org.spring.my.dto;

public class ArticleFile {
	private int fnum;
	private int anum;
	private String filename;
	
	public ArticleFile() {
		super();
	}

	public int getFnum() {
		return fnum;
	}

	public void setFnum(int fnum) {
		this.fnum = fnum;
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
		return "BoardFile [fnum=" + fnum + ", anum=" + anum + ", filename=" + filename + "]";
	}
}
