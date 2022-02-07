package org.spring.my.dto;

import java.util.Date;

public class Board {
	private String b_id;
	private String b_name;
	private String read_level;
	private String write_level;
	private String remove_level;
	private String nickname;
	private Date regidate;
	private Date modidate;
	
	public Board() {
		super();
	}

	public String getB_id() {
		return b_id;
	}



	public void setB_id(String b_id) {
		this.b_id = b_id;
	}



	public String getB_name() {
		return b_name;
	}



	public void setB_name(String b_name) {
		this.b_name = b_name;
	}



	public String getRead_level() {
		return read_level;
	}



	public void setRead_level(String read_level) {
		this.read_level = read_level;
	}



	public String getWrite_level() {
		return write_level;
	}



	public void setWrite_level(String write_level) {
		this.write_level = write_level;
	}



	public String getRemove_level() {
		return remove_level;
	}



	public void setRemove_level(String remove_level) {
		this.remove_level = remove_level;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
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
		return "Board [b_id=" + b_id + ", b_name=" + b_name + ", read_level=" + read_level + ", write_level="
				+ write_level + ", remove_level=" + remove_level + ", nickname=" + nickname + ", regidate=" + regidate
				+ ", modidate=" + modidate + "]";
	}
}
