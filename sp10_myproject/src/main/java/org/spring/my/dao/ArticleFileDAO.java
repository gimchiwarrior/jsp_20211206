package org.spring.my.dao;

import java.util.List;

import org.spring.my.dto.ArticleFile;

public interface ArticleFileDAO {
	public int insert(ArticleFile articleFile);
	public int update(ArticleFile articleFile);
	public int delete(int fnum);
	public int delete_anum(int anum); //anum를 기준으로 삭제
	public ArticleFile selectOne(int fnum);
	public List<ArticleFile> selectList(int anum);
}
