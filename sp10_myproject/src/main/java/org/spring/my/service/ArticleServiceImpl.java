package org.spring.my.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.spring.my.dao.ArticleDAO;
import org.spring.my.dao.ArticleFileDAO;
import org.spring.my.dao.ThumbnailDAO;
import org.spring.my.dto.Article;
import org.spring.my.dto.ArticleFile;
import org.spring.my.dto.Page;
import org.spring.my.dto.Thumbnail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	private ArticleDAO articleDAO;
	@Autowired
	private ArticleFileDAO articleFileDAO;
	@Autowired
	private FileService fileService;
	@Autowired
	private ThumbnailDAO thumbnailDAO;
	@Autowired
	private ThumbnailService thumbnailService;
	
	@Transactional
	@Override
	public Map<String,Object> insert(Article article) {
		// TODO Auto-generated method stub
		int cnt = articleDAO.insert(article);
		Map<String,Object> result = new HashMap<>();
		String thumbnailFileName = "";
		if(cnt > 0) {
			List<MultipartFile> files = article.getFiles();
			if(files != null) {
				ArticleFile articleFile = new ArticleFile();
				articleFile.setAnum(article.getAnum());
				for(int i = 0; i < files.size(); i++) {
					String filename = fileService.upload(files.get(i));
					if(!filename.equals("")) {
						articleFile.setFilename(filename);
						if(articleFileDAO.insert(articleFile) <= 0) {
							result.put("code",2);
							result.put("msg", "첨부파일 등록 실패");
							break;
						}
					}
					//썸네일
					if(i == 0 && article.getB_id().equals("gallery")) {
						thumbnailFileName = filename;
					}
				}
				if(!thumbnailFileName.equals("")) {
					Thumbnail thumb = new Thumbnail();
					thumbnailFileName = thumbnailService.makeThumb(thumbnailFileName);
					thumb.setAnum(article.getAnum());
					thumb.setFilename(thumbnailFileName);
					thumbnailDAO.insert(thumb);
				}
			}
			if(result.isEmpty()) {
				result.put("code", 0);
				result.put("msg", "게시글 등록 성공");
			}
		}else {
			result.put("code",1);
			result.put("msg", "게시글 등록 실패");
		}
		return result;
	}
	
	@Transactional
	@Override
	public Map<String,Object> update(Article article, List<Integer> removeFile) {
		// TODO Auto-generated method stub
		int cnt = articleDAO.update(article);
		Map<String,Object> result = new HashMap<>();
		
		if(cnt > 0) {
			if(removeFile != null) {
				for(int fnum: removeFile) {
					articleFileDAO.delete(fnum);
				}
			}
			List<MultipartFile> files = article.getFiles();
			if(files != null) {
				ArticleFile articleFile = new ArticleFile();
				articleFile.setAnum(article.getAnum());
				for(MultipartFile file : files) {
					String filename = fileService.upload(file);
					if(!filename.equals("")) {
						articleFile.setFilename(filename);
						if(articleFileDAO.insert(articleFile) <= 0) {
							result.put("code",2);
							result.put("msg", "첨부파일 등록 실패");
							break;
						}
					}
				}
			}
			if(result.isEmpty()) {
				result.put("code", 0);
				result.put("msg", "게시글 수정 성공");
			}
		}else {
			result.put("code",1);
			result.put("msg", "게시글 수정 실패");
		}
		return result;
	}

	@Override
	public String delete(int anum) {
		// TODO Auto-generated method stub
		int cnt = articleDAO.delete(anum);

		if(cnt > 0) {
			return "게시글 삭제 완료";
		}else {
			return "게시글 삭제 실패";
		}
	}

	@Override
	public Map<String,Object> selectOne(int anum) {
		// TODO Auto-generated method stub
		Map<String,Object> result = new HashMap<>();
		Article article = articleDAO.selectOne(anum);
		result.put("article", article);
		List<ArticleFile> files = articleFileDAO.selectList(anum);
		result.put("files", files);
		
		return result;
	}

	@Override
	public List<Article> selectList(Page page) {
		// TODO Auto-generated method stub
		int curpage = page.getCurpage();
		int perpage = page.getPerpage();
		int startnum = (curpage - 1) * perpage;
		int endnum = startnum + perpage - 1;
		page.setStartnum(startnum);
		page.setEndnum(endnum);
		
		int totcnt = articleDAO.select_totcnt(page);
		int totpage = totcnt/perpage;
		if (totcnt%perpage>0) totpage ++;
		page.setTotpage(totpage);
		
		int perblock = page.getPerblock();
		int startpage = curpage - ((curpage - 1) % perblock);
		int endpage = startpage + perblock - 1;
		
		if (totpage<endpage) endpage = totpage;
		page.setStartpage(startpage);
		page.setEndpage(endpage);
		
		System.out.println("페이지:" + page);
		return articleDAO.selectList(page);
	}

	@Override
	public void readCntPlus(int anum) {
		// TODO Auto-generated method stub
		articleDAO.readCntPlus(anum);
	}

	@Override
	public void likeCntPlus(int anum) {
		// TODO Auto-generated method stub
		articleDAO.likeCntPlus(anum);
	}

	@Override
	public void dislikeCntPlus(int anum) {
		// TODO Auto-generated method stub
		articleDAO.dislikeCntPlus(anum);
	}

	@Override
	public String updateRemoveyn(int anum) {
		// TODO Auto-generated method stub
		int cnt = articleDAO.updateRemoveyn(anum);
		if(cnt > 0)
			return "삭제 성공";
		else
			return "삭제 실패";
	}

}
