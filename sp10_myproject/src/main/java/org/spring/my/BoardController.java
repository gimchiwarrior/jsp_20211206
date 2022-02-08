package org.spring.my;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.my.dao.ThumbnailDAO;
import org.spring.my.dto.Article;
import org.spring.my.dto.Board;
import org.spring.my.dto.Page;
import org.spring.my.dto.Thumbnail;
import org.spring.my.service.ArticleService;
import org.spring.my.service.BoardService;
import org.spring.my.service.ThumbnailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private BoardService boardService;
	@Autowired
	private ThumbnailService thumbnailService;
	
	@GetMapping("add/{category}")
	public String articleAdd(@PathVariable String category, Model model) {
		model.addAttribute("category", category);
		return "board/add";
	}
	
	@GetMapping("{category}/{anum}")
	public String articleDetail(@PathVariable String anum, @RequestParam int cntplus, Model model) {
		if(cntplus != 0)
			articleService.readCntPlus(Integer.parseInt(anum));
		Map<String,Object> result = articleService.selectOne(Integer.parseInt(anum));
		model.addAttribute("article", result.get("article"));
		model.addAttribute("files", result.get("files"));
		return "board/detail";
	}
	
	@GetMapping("modiform/{anum}")
	public String articleModiform(@PathVariable int anum, Model model) {
		Map<String,Object> result = articleService.selectOne(anum);
		model.addAttribute("result",result);
		return "board/modify";
	}
	
	@GetMapping("{category}")
	public String articleList(@ModelAttribute Page page, @PathVariable String category, Model model) {
		if(page.getCurpage() == 0)
			page.setCurpage(1);
		page.setB_id(category);
		List<Article> alist = articleService.selectList(page);
		Board board = boardService.selectOne(category);
		//System.out.println(alist);
		model.addAttribute("alist", alist);
		model.addAttribute("page",page);
		model.addAttribute("category",category);
		model.addAttribute("board", board);
		if(!category.equals("gallery")) {
			return "board/list";
		}
		else {
			List<Thumbnail> tlist = thumbnailService.selectList(page);
			model.addAttribute("tlist", tlist);
			return "board/gallery/list";
		}
	}
	
	@PostMapping
	public String articleAdd(@ModelAttribute Article article, RedirectAttributes rattr, HttpServletRequest request) {
		article.setIp(request.getRemoteAddr());
		Map<String,Object> result = articleService.insert(article);
		rattr.addFlashAttribute("code",result.get("code"));
		rattr.addFlashAttribute("msg", result.get("msg"));
		return "redirect:/board/" + article.getB_id();
	}
	
	@PostMapping("modify")
	public String articleModi(@ModelAttribute Article article,@RequestParam(required = false) List<Integer> removeFile, RedirectAttributes rattr) {
		Map<String,Object> result = articleService.update(article, removeFile);
		rattr.addFlashAttribute("code",result.get("code"));
		rattr.addFlashAttribute("msg", result.get("msg"));
		return "redirect:/board/" + article.getB_id() + "/" + article.getAnum() +"?cntplus=0";
	}
	
	@PostMapping("{category}/{anum}")
	public String articleDelete(@PathVariable String anum, @PathVariable String category, RedirectAttributes rattr) {
		System.out.println(category);
		String msg = articleService.updateRemoveyn(Integer.parseInt(anum));
		rattr.addFlashAttribute("msg",msg);
		return "redirect:/board/" + category;
	}
}
