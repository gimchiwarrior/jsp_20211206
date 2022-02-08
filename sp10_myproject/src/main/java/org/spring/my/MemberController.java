package org.spring.my;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.my.dto.Member;
import org.spring.my.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "regi", method = RequestMethod.GET)
	public String regi() {
	
		return "registration";
	}
	
	@RequestMapping(value = "regi", method = RequestMethod.POST)
	public String regi(@ModelAttribute Member member, RedirectAttributes rattr) {
		String msg = memberService.insert(member);
		rattr.addFlashAttribute("msg", msg);
		return "redirect:/home/";
	}
	
	@RequestMapping(value = "juso") 
	public String juso(Model model,RedirectAttributes rattr) { 
		return "juso/jusoPopup"; 
	}
	
	@RequestMapping(value = "myInfo", method = RequestMethod.GET)
	public String myInfo(Model model, HttpSession session) {
		Member member = memberService.selectOne(session.getAttribute("userid").toString());
		model.addAttribute("member", member);
		return "myInfo";
	}
	
	@RequestMapping(value = "modi", method = RequestMethod.POST)
	public String modify(@ModelAttribute Member member, RedirectAttributes rattr) {
		String msg = memberService.update(member);
		rattr.addFlashAttribute("msg", msg);
		return "redirect:myInfo";
	}
	
	@RequestMapping("mailConfirm")
	public String mailConfirm(@RequestParam String userid, RedirectAttributes rattr) {
		String msg = memberService.updateAuth(userid);
		rattr.addFlashAttribute("msg",msg);
		return "redirect:/login";
	}
}
