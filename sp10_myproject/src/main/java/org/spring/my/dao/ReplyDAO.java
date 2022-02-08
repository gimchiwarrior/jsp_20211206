package org.spring.my.dao;

import java.util.List;

import org.spring.my.dto.Reply;

public interface ReplyDAO {
	public int insert(Reply reply);
	public int update(Reply reply);
	public int updateRestep(Reply reply);
	public int delete(int rnum);
	public List<Reply> selectList(int anum);
}
