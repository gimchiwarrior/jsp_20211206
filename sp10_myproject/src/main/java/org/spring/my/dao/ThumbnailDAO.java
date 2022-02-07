package org.spring.my.dao;

import java.util.List;

import org.spring.my.dto.ArticleFile;
import org.spring.my.dto.Page;
import org.spring.my.dto.Thumbnail;

public interface ThumbnailDAO {
	public int insert(Thumbnail thumbnail);
	public int update(Thumbnail thumbnail);
	public int delete(int tnum);
	public int delete_anum(int anum); //anum를 기준으로 삭제
	public Thumbnail selectOne(int anum);
	public List<Thumbnail> selectList(Page page);
}
