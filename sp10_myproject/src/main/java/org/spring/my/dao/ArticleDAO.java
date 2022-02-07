package org.spring.my.dao;

import java.util.List;
import java.util.Map;

import org.spring.my.dto.Article;
import org.spring.my.dto.Page;

public interface ArticleDAO {
	public int insert(Article article);
	public int update(Article article);
	public int delete(int anum);
	public Article selectOne(int anum);
	public List<Article> selectList(Page page);
	
	public void readCntPlus(int anum);
	public void likeCntPlus(int anum);
	public void dislikeCntPlus(int anum);
	public int updateRemoveyn(int anum);
	public int select_totcnt(Page page);
	public void restepPlus(Article article);
	public List<Article> select_reply(int ref);
}
