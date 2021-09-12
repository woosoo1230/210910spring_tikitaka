package edu.spring.semiproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("recommendService")
public class RecommendServiceImpl implements RecommendService {

	@Autowired
	RecommendDAO recommendDAO;

	@Override
	public void insertRecommend(RecommendVO vo) {
		recommendDAO.insertRecommend(vo);
	}

	@Override
	public void deleteRecommend(RecommendVO vo) {
		recommendDAO.deleteRecommend(vo);
	}
	
	

}
