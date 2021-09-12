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
	
	@Autowired
	RecommendService recommendService;
	
	@RequestMapping("board/list")
	public ModelAndView selectAllBoard() {
		List<BoardVO> boardlist = boardService.selectAllBoard();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", boardlist);
		mv.setViewName("/board/list");
		return mv;
	}
	
	@RequestMapping("board/detail")
	public ModelAndView boardDetail(int bno, String flag, HttpServletRequest request) {
		ModelAndView mv= new ModelAndView();
		boolean state = flag == null? true : false;//조회수
		BoardVO board = boardService.boardDetail(bno, state);
		MemberVO member = service.selectOne(board.getMno());
		List<ReplyVO> replylist = boardService.selectReplyBybno(bno);
		List<RecommendVO> recommendlist = null;
		HttpSession session = request.getSession();
		session= request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("vo");
		if(vo != null) {//로그인유저
			RecommendVO rv = new RecommendVO();
			rv.setBno(bno);
			rv.setMno(vo.getMno());
			recommendlist = boardService.selectRecommendBybno(rv);
		}
		mv.addObject("board", board);
		mv.addObject("member", member);
		mv.addObject("replylist", replylist);
		mv.addObject("recommendlist", recommendlist);
		
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
	
	@RequestMapping("board/deleteBoard")
	public String deleteBoard(int bno) {
		boardService.deleteBoard(bno);
		return "redirect:/board/list";
	}
	
	@RequestMapping("board/insertRecommend")
	public String insertRecommend(int bno, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session= request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("vo");
		RecommendVO recommendvo = new RecommendVO();
		recommendvo.setBno(bno);
		recommendvo.setMno(vo.getMno());
		recommendService.insertRecommend(recommendvo);//추천증가
		boardService.recommendUp(bno);//추천수 증가
		
		return "redirect:/board/detail/?bno="+bno+"&flag=1";
	}
	
	@RequestMapping("board/deleteRecommend")
	public String deleteRecommend(int bno, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session= request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("vo");
		RecommendVO recommendvo = new RecommendVO();
		recommendvo.setBno(bno);
		recommendvo.setMno(vo.getMno());
		recommendService.deleteRecommend(recommendvo);//추천삭제
		boardService.recommendDown(bno);//추천수 감소
		
		return "redirect:/board/detail/?bno="+bno+"&flag=1";
			
	}
}
