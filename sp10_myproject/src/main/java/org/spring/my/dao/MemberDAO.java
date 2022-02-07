package org.spring.my.dao;

import java.util.List;
import java.util.Map;

import org.spring.my.dto.Member;

public interface MemberDAO {
	public int insert(Member member);
	public int update(Member member);
	public int updateAuth(String userid);
	public int delete(String userid);
	public Member selectOne(String userid);
	public List<Member> selectList(String userid);
}
