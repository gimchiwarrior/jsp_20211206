package org.spring.my;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
	
	@GetMapping("chat")
	public String view_chat(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		return "chat";
	}
}
