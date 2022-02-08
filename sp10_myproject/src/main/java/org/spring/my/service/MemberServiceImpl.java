package org.spring.my.service;

import java.util.List;

import org.spring.my.dao.MemberDAO;
import org.spring.my.dao.MemberDAOImpl;
import org.spring.my.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private MailSendService mailSendService;
	
	@Override
	public String insert(Member member) {
		//암호화
		String cryptPasswd = bCryptPasswordEncoder.encode(member.getPasswd());
		member.setPasswd(cryptPasswd);
		
		boolean result = mailSendService.sendAuthMail(member.getEmail(),member.getUserid());
		
		if(result) {
			int cnt = memberDAO.insert(member);
			if(cnt > 0)
				return "등록 완료";
			else
				return "등록 실패";
		}
		else
			return "메일전송 실패";
	}

	@Override
	public String update(Member member) {
		// TODO Auto-generated method stub
		int cnt = memberDAO.update(member);
		
		if(cnt > 0)
			return "수정 완료";
		else
			return "수정 실패";
	}
	
	@Override
	public String updateAuth(String userid) {
		// TODO Auto-generated method stub
		int cnt = memberDAO.updateAuth(userid);
		
		if(cnt > 0)
			return "이메일 인증 완료";
		else
			return "이메일 인증 실패";
	}
	
	@Override
	public String delete(String userid) {
		// TODO Auto-generated method stub
		int cnt = memberDAO.delete(userid);
		
		if(cnt > 0)
			return "삭제 완료";
		else
			return "삭제 실패";
	}

	@Override
	public Member selectOne(String userid) {
		// TODO Auto-generated method stub
		return memberDAO.selectOne(userid);
	}

	@Override
	public List<Member> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectAuthority(String cname) {
		// TODO Auto-generated method stub
		return null;
	}

}
