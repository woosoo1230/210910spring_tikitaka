package edu.spring.semiproject;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
	SqlSession session;
	
	public List<BoardVO> selectAllBoard(){
		return session.selectList("member.selectAllBoard");
	}
	
	public BoardVO boardDetail(int bno) {
		return session.selectOne("member.boardDetail", bno);
	}
	
	public void updateReadnum(int bno) {
		session.update("member.updateReadnum", bno);
	}
	
	public void updateBoard(BoardVO vo) {
		session.update("member.updateBoard", vo);
	}
	
	public void insertBoard(BoardVO vo) {
		session.insert("member.insertBoard", vo);
	}
	
	public List<ReplyVO> selectReplyBybno(int bno){
		return session.selectList("member.selectReplyBybno", bno);
	}
	
	public void deleteBoard(int bno) {
		session.delete("member.deleteBoard", bno);
	}
	
	public List<RecommendVO> selectRecommendBybno(RecommendVO vo) {
		return session.selectList("member.selectRecommendBybno", vo);
	}
	
	public void recommendUp(int bno) {
		session.update("member.recommendUp", bno);
	}
	
	public void recommendDown(int bno) {
		session.update("member.recommendDown", bno);
	}
	
	public void upload(UploadVO vo) {
		session.insert("member.upload", vo);
	}
}
