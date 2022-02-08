package org.spring.my.dto;

public class Page {
	private int curpage = 0;
	private int totpage;
	private int perpage = 15;
	private int startnum;
	private int endnum;
	
	private int perblock = 10;
	private int startpage;
	private int endpage;
	
	private String b_id;
	private String findkey;
	private String findvalue;
	
	public Page() {
		super();
	}

	public int getCurpage() {
		return curpage;
	}

	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}

	public int getTotpage() {
		return totpage;
	}

	public void setTotpage(int totpage) {
		this.totpage = totpage;
	}

	public int getPerpage() {
		return perpage;
	}

	public void setPerpage(int perpage) {
		this.perpage = perpage;
	}

	public int getStartnum() {
		return startnum;
	}

	public void setStartnum(int startnum) {
		this.startnum = startnum;
	}

	public int getEndnum() {
		return endnum;
	}

	public void setEndnum(int endnum) {
		this.endnum = endnum;
	}

	public int getPerblock() {
		return perblock;
	}

	public void setPerblock(int perblock) {
		this.perblock = perblock;
	}

	public int getStartpage() {
		return startpage;
	}

	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}

	public int getEndpage() {
		return endpage;
	}

	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}

	public String getFindkey() {
		return findkey;
	}

	public void setFindkey(String findkey) {
		this.findkey = findkey;
	}

	public String getFindvalue() {
		return findvalue;
	}

	public void setFindvalue(String findvalue) {
		this.findvalue = findvalue;
	}
	
	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	@Override
	public String toString() {
		return "Page [curpage=" + curpage + ", totpage=" + totpage + ", perpage=" + perpage + ", startnum=" + startnum
				+ ", endnum=" + endnum + ", perblock=" + perblock + ", startpage=" + startpage + ", endpage=" + endpage
				+ "b_id= " + b_id + ", findkey=" + findkey + ", findvalue=" + findvalue + "]";
	}
}
