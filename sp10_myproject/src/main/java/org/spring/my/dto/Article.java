package org.spring.my.dto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Article {
	private String b_id;
	private int anum;
	private String nickname;
	private String subject;
	private String content;
	private int readcnt;
	private int likecnt;
	private int dislikecnt;
	private String ip;
	private String removeyn;
	private Date regidate;
	private Date modidate;
	private List<MultipartFile> files;
	
	public Article() {
		super();
	}

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public int getAnum() {
		return anum;
	}

	public void setAnum(int anum) {
		this.anum = anum;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public int getLikecnt() {
		return likecnt;
	}

	public void setLikecnt(int likecnt) {
		this.likecnt = likecnt;
	}

	public int getDislikecnt() {
		return dislikecnt;
	}

	public void setDislikecnt(int dislikecnt) {
		this.dislikecnt = dislikecnt;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getRemoveyn() {
		return removeyn;
	}

	public void setRemoveyn(String removeyn) {
		this.removeyn = removeyn;
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

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "Article [b_id=" + b_id + ", anum=" + anum + ", nickname=" + nickname + ", subject=" + subject
				+ ", content=" + content + ", readcnt=" + readcnt + ", likecnt=" + likecnt + ", dislikecnt="
				+ dislikecnt + ", ip=" + ip + ", removeyn=" + removeyn + ", regidate=" + regidate + ", modidate="
				+ modidate + ", files=" + files + "]";
	}
}
