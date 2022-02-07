package org.spring.my;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.my.dao.ArticleDAO;
import org.spring.my.dao.MemberDAO;
import org.spring.my.dto.Article;
import org.spring.my.dto.Member;
import org.spring.my.service.ThumbnailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/**/servlet-context.xml"})
public class JunitDAOTest {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private ArticleDAO boardDAO;
	@Autowired
	private ThumbnailService thumbnailService;
	
	@Test
	public void testInsert() {
		Member member = new Member();
		member.setEmail("asd@asd.com");
		member.setNickname("아1");
		member.setPasswd("123123");
		member.setUserid("aaa");
		int cnt = memberDAO.insert(member);
		System.out.println(cnt + "건 입력");
		
	}
	
	@Test
	public void testUpdate() {
		Member member = new Member();
		member.setEmail("asd@asd.com");
		member.setNickname("아2");
		member.setPasswd("123");
		member.setUserid("aaa");
		int cnt = memberDAO.update(member);
		System.out.println(cnt + "건 수정");
		
	}
	@Test
	public void testDelete() {
		int cnt = memberDAO.delete("aaa");
		System.out.println(cnt + "건 삭제");
		
	}
	@Test
	public void testSelectOne() {
		
		Member m = memberDAO.selectOne("ccc");
		System.out.println(m);
		
	}
	@Test
	public void testSelectList() {
		List<Member> member;
		member= memberDAO.selectList("asd");
		for(Member m : member) {
			System.out.println(m);
		}
	}
	
	@Test
	public void testBoardInsert() {
		Article board = new Article();
		board.setAnum(1);
	}
	
	@Test
	public void testMakeThumbnail() {
		thumbnailService.makeThumb("1643646211622_the-cat-g0087b6898_640.jpg");
	}

}
