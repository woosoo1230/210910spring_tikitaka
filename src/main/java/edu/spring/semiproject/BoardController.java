package edu.spring.semiproject;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
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
	public String insertBoard(BoardVO board ,HttpServletRequest request, MultipartFile filename) throws IOException {
		HttpSession session = request.getSession();
		session= request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("vo");
		board.setMno(vo.getMno());
		boardService.insertBoard(board);
		//System.out.println(file);
		//System.out.println(file.getSize());
		//업로드
		if(filename.getSize() != 0) {
		//전송파일 객체 생성
		MultipartFile multi = filename;
		//파일명 추출
		String name = multi.getOriginalFilename();
		//저장폴더
		String savePath = "C:/kdigital2/workspace_spring/semiproject/src/main/webapp/resources/save";
		//확장자 찾기
		String ext = name.substring(name.lastIndexOf("."));
		
		name = getUuid()+ext;
	
		File file1 = new File(savePath, name);
		
		multi.transferTo(file1);
		System.out.println(savePath+"="+name);
		UploadVO upload = new UploadVO();
		//System.out.println(board.getBno());
		upload.setBno(board.getBno());
		upload.setFilename(name);
		//boardService.upload(upload);
		}
		
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
	
	
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10) ;
	}
}
