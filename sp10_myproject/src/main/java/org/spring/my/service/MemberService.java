package org.spring.my.service;

import java.util.List;

import org.spring.my.dto.Member;

public interface MemberService {
	public String insert(Member member);
	public String update(Member member);
	public String updateAuth(String userid);
	public String delete(String userid);
	public Member selectOne(String userid);
	public List<Member> selectList();
	public String selectAuthority(String cname);
}
