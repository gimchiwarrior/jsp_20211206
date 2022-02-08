package org.spring.my.dto;

import java.util.Date;

public class Member {
	private String userid;
	private String passwd;
	private String nickname;
	private String email;
	private String zipcode;
	private String addr;
	private String addrdetail;
	private String emailauth="0"; //0:미인증, 1:인증
	private String simplejoin="0"; //0:일반가입,1:네이버,2:카카오,3.구글
	private Date regidate;
	private String cname;
	
	public Member() {
		super();
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getAddrdetail() {
		return addrdetail;
	}

	public void setAddrdetail(String addrdetail) {
		this.addrdetail = addrdetail;
	}

	public String getEmailauth() {
		return emailauth;
	}

	public void setEmailauth(String emailauth) {
		this.emailauth = emailauth;
	}

	public String getSimplejoin() {
		return simplejoin;
	}

	public void setSimplejoin(String simplejoin) {
		this.simplejoin = simplejoin;
	}

	public Date getRegidate() {
		return regidate;
	}

	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}

	@Override
	public String toString() {
		return "Member [userid=" + userid + ", passwd=" + passwd + ", nickname=" + nickname + ", email=" + email
				+ ", cname=" + cname + ", zipcode=" + zipcode + ", addr=" + addr + ", addrdetail=" + addrdetail
				+ ", emailauth=" + emailauth + ", simplejoin=" + simplejoin + ", regidate="
				+ regidate + "]";
	}
}
