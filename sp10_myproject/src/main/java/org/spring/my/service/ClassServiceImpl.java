package org.spring.my.service;

import org.spring.my.dao.ClassDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService{
	@Autowired
	ClassDAO classDAO;
	
	@Override
	public String selectAuthority(String cname) {
		// TODO Auto-generated method stub
		return classDAO.selectOne(cname).getAuthority();
	}
}
