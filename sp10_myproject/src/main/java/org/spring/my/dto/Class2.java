package org.spring.my.dto;

public class Class2 {
	private String cname;
	private String authority;
	
	public Class2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Class [cname=" + cname + ", authority=" + authority + "]";
	}
}
