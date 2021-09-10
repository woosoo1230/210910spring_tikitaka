package edu.spring.semiproject;

import java.util.List;

public interface BoardService {
	public List<BoardVO> selectAllBoard();
	public BoardVO boardDetail(int bno, boolean state);
	public void updateBoard(BoardVO vo);
	public void insertBoard(BoardVO vo);
	public List<ReplyVO> selectReplyBybno(int bno);
	public void deleteBoard(int bno);
}
