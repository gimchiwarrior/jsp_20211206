package org.spring.my.dao;

import org.apache.ibatis.session.SqlSession;
import org.spring.my.dto.Class2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClassDAOImpl implements ClassDAO{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public Class2 selectOne(String cname) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("org.spring.my.ClassMapper.selectOne",cname);
	}

}
