package org.spring.my.service;

import java.util.List;

import org.spring.my.dto.Reply;

public interface ReplyService {
	public String insert(Reply reply);
	public String update(Reply reply);
	public String delete(int rnum);
	public List<Reply> selectList(int anum);
}
