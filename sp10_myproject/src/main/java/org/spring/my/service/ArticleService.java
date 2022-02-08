package org.spring.my.service;

import java.util.List;
import java.util.Map;

import org.spring.my.dto.Article;
import org.spring.my.dto.Page;

public interface ArticleService {
	public Map<String,Object> insert(Article article);
	public Map<String,Object> update(Article article, List<Integer> removeFile);
	public String delete(int anum);
	public Map<String,Object> selectOne(int anum);
	public List<Article> selectList(Page page);
	
	public void readCntPlus(int anum);
	public void likeCntPlus(int anum);
	public void dislikeCntPlus(int anum);
	public String updateRemoveyn(int anum);
}
