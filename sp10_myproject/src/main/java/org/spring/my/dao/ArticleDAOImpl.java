package org.spring.my.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.spring.my.dto.Article;
import org.spring.my.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDAOImpl implements ArticleDAO{
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public int insert(Article article) {
		// TODO Auto-generated method stub
		return sqlsession.insert("org.spring.my.ArticleMapper.insert",article);
	}

	@Override
	public int update(Article article) {
		// TODO Auto-generated method stub
		return sqlsession.update("org.spring.my.ArticleMapper.update",article);
	}

	@Override
	public int delete(int anum) {
		// TODO Auto-generated method stub
		return sqlsession.delete("org.spring.my.ArticleMapper.delete",anum);
	}

	@Override
	public Article selectOne(int anum) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("org.spring.my.ArticleMapper.selectOne",anum);
	}

	@Override
	public List<Article> selectList(Page page) {
		// TODO Auto-generated method stub
		return sqlsession.selectList("org.spring.my.ArticleMapper.selectList",page);
	}

	@Override
	public void readCntPlus(int anum) {
		// TODO Auto-generated method stub
		sqlsession.update("org.spring.my.ArticleMapper.update_readcntplus", anum);
	}
	
	@Override
	public void likeCntPlus(int anum) {
		sqlsession.update("org.spring.my.ArticleMapper.update_likecntplus", anum);
	}
	@Override
	public void dislikeCntPlus(int anum) {
		sqlsession.update("org.spring.my.ArticleMapper.update_dislikecntplus", anum);
	}
	@Override
	public int updateRemoveyn(int anum) {
		return sqlsession.update("org.spring.my.ArticleMapper.update_removeyn", anum);
	}
	
	@Override
	public int select_totcnt(Page page) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("org.spring.my.ArticleMapper.select_totcnt", page);
	}

	@Override
	public void restepPlus(Article article) {
		// TODO Auto-generated method stub
		sqlsession.update("org.spring.my.ArticleMapper.update_restepplus", article);
	}

	@Override
	public List<Article> select_reply(int ref) {
		// TODO Auto-generated method stub
		return sqlsession.selectList("org.spring.my.ArticleMapper.select_reply", ref);
	}

}
