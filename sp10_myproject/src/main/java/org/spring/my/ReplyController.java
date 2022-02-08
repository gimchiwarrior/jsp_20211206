package org.spring.my;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.spring.my.dto.Reply;
import org.spring.my.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reply")
public class ReplyController {
	@Autowired
	ReplyService replyService;
	
	@GetMapping("{bnum}")
	public List<Reply> replyList(@PathVariable int bnum){
		return replyService.selectList(bnum);
	}
	
	@PostMapping
	public String replyAdd(@RequestBody Reply reply, HttpServletRequest request) {
		reply.setIp(request.getRemoteAddr());
		replyService.insert(reply);
		return "ok";
	}
	
	@PutMapping
	public String replyModi(@RequestBody Reply reply, HttpServletRequest request) {
		reply.setIp(request.getRemoteAddr());
		replyService.update(reply);
		return "ok";
	}
	
	@DeleteMapping("{rnum}")
	public String replyDel(@PathVariable int rnum) {
		replyService.delete(rnum);
		return "ok";
	}
}
