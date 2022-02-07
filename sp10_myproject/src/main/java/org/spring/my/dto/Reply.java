package org.spring.my.dto;

import java.util.Date;

public class Reply {
	private int rnum;
	private int anum;
	private String nickname;
	private int restep;
	private int relevel;
	private String content;
	private String ip;
	private Date regidate;
	private Date modidate;
	
	public Reply() {
		super();
	}

	public Reply(int rnum, int anum, String nickname, int restep, int relevel, String content, String ip, Date regidate,
			Date modidate) {
		super();
		this.rnum = rnum;
		this.anum = anum;
		this.nickname = nickname;
		this.restep = restep;
		this.relevel = relevel;
		this.content = content;
		this.ip = ip;
		this.regidate = regidate;
		this.modidate = modidate;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getanum() {
		return anum;
	}

	public void setanum(int anum) {
		this.anum = anum;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getRestep() {
		return restep;
	}

	public void setRestep(int restep) {
		this.restep = restep;
	}

	public int getRelevel() {
		return relevel;
	}

	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getRegidate() {
		return regidate;
	}

	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}

	public Date getModidate() {
		return modidate;
	}

	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}

	@Override
	public String toString() {
		return "Reply [rnum=" + rnum + ", anum=" + anum + ", nickname=" + nickname + ", restep=" + restep + ", relevel="
				+ relevel + ", content=" + content + ", ip=" + ip + ", regidate=" + regidate + ", modidate=" + modidate
				+ "]";
	}
	
	
}
