package edu.spring.semiproject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAO {

	@Autowired
	SqlSession session;
	
	public void insertReply(ReplyVO reply) {
		session.insert("member.insertReply", reply);
	}
}
