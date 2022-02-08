package org.spring.my.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.spring.my.dto.ArticleFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleFileDAOImpl implements ArticleFileDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(ArticleFile articleFile) {
		// TODO Auto-generated method stub
		return sqlSession.insert("org.spring.my.ArticleFileMapper.insert", articleFile);
	}

	@Override
	public int update(ArticleFile articleFile) {
		// TODO Auto-generated method stub
		return sqlSession.update("org.spring.my.ArticleFileMapper.update", articleFile);
	}

	@Override
	public int delete(int fnum) {
		// TODO Auto-generated method stub
		return sqlSession.delete("org.spring.my.ArticleFileMapper.delete", fnum);
	}

	@Override
	public int delete_anum(int anum) {
		// TODO Auto-generated method stub
		return sqlSession.delete("org.spring.my.ArticleFileMapper.delete_anum", anum);
	}

	@Override
	public ArticleFile selectOne(int fnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("org.spring.my.ArticleFileMapper.selectOne", fnum);
	}

	@Override
	public List<ArticleFile> selectList(int anum) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("org.spring.my.ArticleFileMapper.selectList", anum);
	}

}
