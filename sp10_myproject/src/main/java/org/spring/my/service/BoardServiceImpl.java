package org.spring.my.service;

import org.spring.my.dao.BoardDAO;
import org.spring.my.dto.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardDAO boardDAO;
	@Override
	public Board selectOne(String b_id) {
		// TODO Auto-generated method stub
		return boardDAO.selectOne(b_id);
	}

}
