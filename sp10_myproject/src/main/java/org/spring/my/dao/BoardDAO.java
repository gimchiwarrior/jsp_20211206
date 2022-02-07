package org.spring.my.dao;

import org.spring.my.dto.Board;

public interface BoardDAO {
	public Board selectOne(String b_id);
}
