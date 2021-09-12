package edu.spring.semiproject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecommendDAO {

	@Autowired
	SqlSession session;
	
	public void insertRecommend(RecommendVO vo) {
		session.insert("member.insertRecommend", vo);
	}
	
	public void deleteRecommend(RecommendVO vo) {
		session.delete("member.deleteRecommend", vo);
	}
}
