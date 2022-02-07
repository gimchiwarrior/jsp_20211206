package org.spring.my.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.spring.my.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(Member member) {
		// TODO Auto-generated method stub
		return sqlSession.insert("org.spring.my.MemberMapper.insert", member);
	}

	@Override
	public int update(Member member) {
		// TODO Auto-generated method stub
		return sqlSession.update("org.spring.my.MemberMapper.update", member);
	}

	@Override
	public int updateAuth(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.update("org.spring.my.MemberMapper.updateAuth", userid);
	}
	
	@Override
	public int delete(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.delete("org.spring.my.MemberMapper.delete", userid);
	}

	@Override
	public Member selectOne(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("org.spring.my.MemberMapper.selectOne", userid);
	}

	@Override
	public List<Member> selectList(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("org.spring.my.MemberMapper.selectList", userid);
	}

}
