package org.spring.my;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.my.dto.Class2;
import org.spring.my.dto.Member;
import org.spring.my.service.ClassService;
import org.spring.my.service.LoginService;
import org.spring.my.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private ClassService classService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
	
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam String userid,@RequestParam String passwd, HttpServletRequest request, HttpServletResponse response, RedirectAttributes rattr, HttpSession session) {
		String msg = loginService.loginCheck(userid, passwd);
		
		if(msg.equals("로그인 성공")) {
			Member user = memberService.selectOne(userid);
			String authority= classService.selectAuthority(user.getCname());
			session.setAttribute("userid", user.getUserid());
			session.setAttribute("nickname", user.getNickname());
			session.setAttribute("cname", user.getCname());
			session.setAttribute("authority", authority);
			session.setMaxInactiveInterval(60*60*3);
			
			Cookie id_cookie = new Cookie("id",userid);
			String path = request.getContextPath();
			System.out.println(path);
			id_cookie.setPath(path);
			
			if(request.getParameter("idsave") == null) {
				id_cookie.setMaxAge(0);
			}
			
			response.addCookie(id_cookie);
		}
		
		rattr.addFlashAttribute("msg",msg);
		
		return "redirect:/home/";
	}
	
	@RequestMapping(value="logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home/";
	}
}
