package edu.spring.semiproject;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@Autowired
	MemberService service;
	
	@RequestMapping("board/list")
	public ModelAndView selectAllBoard() {
		List<BoardVO> boardlist = boardService.selectAllBoard();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", boardlist);
		mv.setViewName("/board/list");
		return mv;
	}
	
	@RequestMapping("board/detail")
	public ModelAndView boardDetail(int bno, String flag) {
		boolean state = flag == null? true : false;//조회수
		BoardVO board = boardService.boardDetail(bno, state);
		MemberVO member = service.selectOne(board.getMno());
		List<ReplyVO> replylist = boardService.selectReplyBybno(bno);
		ModelAndView mv= new ModelAndView();
		mv.addObject("board", board);
		mv.addObject("member", member);
		mv.addObject("replylist", replylist);
		mv.setViewName("/board/detail");
		return mv;
	}
	
	@RequestMapping("board/updateBoard")
	public ModelAndView boardUpdateForm(int bno) {
		BoardVO board = boardService.boardDetail(bno, false);
		MemberVO member = service.selectOne(board.getMno());
		ModelAndView mv= new ModelAndView();
		mv.addObject("board", board);
		mv.addObject("member", member);
		mv.setViewName("/board/updateform");
		return mv;
	}
	
	@RequestMapping("board/update")
	public String boardUpdate(BoardVO board) {
		System.out.println(board.getBno() + board.getContent() +board.getSubject());
		boardService.updateBoard(board);
		return "redirect:/board/list";
	}
	
	@RequestMapping("board/write")
	public String boardWriteForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session= request.getSession();
		if(session.getAttribute("vo") != null) {
			return "/board/writeform";
		}else {
			return "/member/loginform";
		}
		
	}
	
	@RequestMapping("board/insert")
	public String insertBoard(BoardVO board ,HttpServletRequest request) {
		HttpSession session = request.getSession();
		session= request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("vo");
		board.setMno(vo.getMno());
		boardService.insertBoard(board);
		return "redirect:/board/list";
	}
}
