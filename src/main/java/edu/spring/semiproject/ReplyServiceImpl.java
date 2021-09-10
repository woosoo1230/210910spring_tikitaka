package edu.spring.semiproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	ReplyDAO replyDAO;

	@Override
	public void insertReply(ReplyVO reply) {
		replyDAO.insertReply(reply);
	}
}
