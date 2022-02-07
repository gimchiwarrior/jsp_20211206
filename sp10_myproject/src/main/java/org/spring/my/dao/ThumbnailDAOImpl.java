package org.spring.my.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.spring.my.dto.Page;
import org.spring.my.dto.Thumbnail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ThumbnailDAOImpl implements ThumbnailDAO{
	@Autowired
	private SqlSession sqlSession;
	@Override
	public int insert(Thumbnail thumbnail) {
		// TODO Auto-generated method stub
		return sqlSession.insert("org.spring.my.ThumbnailMapper.insert", thumbnail);
	}

	@Override
	public int update(Thumbnail thumbnail) {
		// TODO Auto-generated method stub
		return sqlSession.update("org.spring.my.ThumbnailMapper.update", thumbnail);
	}

	@Override
	public int delete(int tnum) {
		// TODO Auto-generated method stub
		return sqlSession.delete("org.spring.my.ThumbnailMapper.delete", tnum);
	}

	@Override
	public int delete_anum(int anum) {
		// TODO Auto-generated method stub
		return sqlSession.delete("org.spring.my.ThumbnailMapper.delete_anum", anum);
	}

	@Override
	public Thumbnail selectOne(int anum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("org.spring.my.ThumbnailMapper.selectOne", anum);
	}

	@Override
	public List<Thumbnail> selectList(Page page) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("org.spring.my.ThumbnailMapper.selectList", page);
	}
}
