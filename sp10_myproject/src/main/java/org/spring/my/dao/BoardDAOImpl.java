package org.spring.my.dao;

import org.apache.ibatis.session.SqlSession;
import org.spring.my.dto.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public Board selectOne(String b_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("org.spring.my.BoardMapper.selectOne", b_id);
	}

}
