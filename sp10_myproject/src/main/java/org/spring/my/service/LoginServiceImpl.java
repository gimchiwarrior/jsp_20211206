package org.spring.my.service;

import org.spring.my.dao.MemberDAO;
import org.spring.my.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public String loginCheck(String userid, String passwd) {
		// TODO Auto-generated method stub
		Member member = memberDAO.selectOne(userid);
		System.out.println(member);
		if(member == null)
			return "존재하지 않는 아이디입니다.";
		else if(bCryptPasswordEncoder.matches(passwd,member.getPasswd())) {
			return "로그인 성공";
		}
		else {	
			return "비밀번호가 일치하지 않습니다.";
		}
	}

}
