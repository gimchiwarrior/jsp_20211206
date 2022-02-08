package org.spring.my.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.spring.my.dto.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insert(Reply reply) {
		// TODO Auto-generated method stub
		return sqlSession.insert("org.spring.my.ReplyMapper.insert", reply);
	}

	@Override
	public int update(Reply reply) {
		// TODO Auto-generated method stub
		return sqlSession.update("org.spring.my.ReplyMapper.update", reply);
	}

	@Override
	public int updateRestep(Reply reply) {
		// TODO Auto-generated method stub
		return sqlSession.update("org.spring.my.ReplyMapper.updateRestep", reply);
	}

	@Override
	public int delete(int rnum) {
		// TODO Auto-generated method stub
		return sqlSession.delete("org.spring.my.ReplyMapper.delete", rnum);
	}

	@Override
	public List<Reply> selectList(int anum) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("org.spring.my.ReplyMapper.selectList", anum);
	}

}
