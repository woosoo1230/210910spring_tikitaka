package edu.spring.semiproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> selectAllBoard() {
		return boardDAO.selectAllBoard();
	}

	@Override
	public BoardVO boardDetail(int bno, boolean state) {
		if(state) {
			boardDAO.updateReadnum(bno);
		}
		return boardDAO.boardDetail(bno);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	@Override
	public List<ReplyVO> selectReplyBybno(int bno) {
		return boardDAO.selectReplyBybno(bno);
	}

	@Override
	public void deleteBoard(int bno) {
		boardDAO.deleteBoard(bno);
	}

	@Override
	public List<RecommendVO> selectRecommendBybno(RecommendVO vo) {
		return boardDAO.selectRecommendBybno(vo);
	}

	@Override
	public void recommendUp(int bno) {
		boardDAO.recommendUp(bno);
	}

	@Override
	public void recommendDown(int bno) {
		boardDAO.recommendDown(bno);
	}

	@Override
	public void upload(UploadVO vo) {
		boardDAO.upload(vo);
	}

}
