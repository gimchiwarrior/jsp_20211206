package org.spring.my.service;

import java.util.List;

import org.spring.my.dao.ReplyDAO;
import org.spring.my.dto.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	private ReplyDAO replyDAO;
	
	@Transactional
	@Override
	public String insert(Reply reply) {
		// TODO Auto-generated method stub
		reply.setRestep(reply.getRestep()+1);
		reply.setRelevel(reply.getRelevel()+1);
		int cnt =replyDAO.updateRestep(reply);
		int cnt2 = replyDAO.insert(reply);
		
		if(cnt > 0 && cnt2 > 0)
			return "입력 성공";
		else
			return "입력 실패";
	}

	@Override
	public String update(Reply reply) {
		// TODO Auto-generated method stub
		int cnt = replyDAO.update(reply);
		
		if(cnt > 0)
			return "수정 성공";
		else
			return "수정 실패";
	}

	@Override
	public String delete(int rnum) {
		// TODO Auto-generated method stub
		int cnt = replyDAO.delete(rnum);
		
		if(cnt > 0)
			return "삭제 성공";
		else
			return "삭제 실패";
	}

	@Override
	public List<Reply> selectList(int anum) {
		// TODO Auto-generated method stub
		return replyDAO.selectList(anum);
	}

}
