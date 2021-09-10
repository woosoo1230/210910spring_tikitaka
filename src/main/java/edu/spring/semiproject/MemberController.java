package edu.spring.semiproject;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	@RequestMapping("/index")
	public void index() {}
	
	/**
	 * 로그인폼
	 * */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "/member/loginform";
	}
	
	/**
	 * 로그인
	 * */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView logincheck(@ModelAttribute MemberVO vo, HttpServletRequest request) {
		System.out.println(vo.getMid());
		System.out.println(vo.getMpw());
		ModelAndView mv = new ModelAndView();
		
		MemberVO dbvo = service.logincheck(vo);
		if(dbvo != null) {
			HttpSession session = request.getSession();
			session= request.getSession();
			session.setAttribute("isLogOn", true);
			session.setAttribute("vo", dbvo);
			mv.setViewName("/index");
		}else {
			mv.addObject("message", "아이디나 비밀번호가 틀립니다. 다시 로그인해주세요.");
			mv.setViewName("/member/loginform");
		}
		
		return mv;
	}
	
	/**
	 * 로그아웃
	 * */
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session= request.getSession();
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index");
		return mv;
	}
	
	/**
	 * 회원가입 폼
	 * */
	@RequestMapping(value = "/joinmember", method = RequestMethod.GET )
	public String joinForm() {
		return "/member/joinform";
	}
	
	/**
	 * 아이디 중복 체크
	 * */
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	@ResponseBody
	public int idCheck(@RequestParam("mid") String mid) {
		System.out.println("idcheck");
		System.out.println("mid = "+mid);
		int cnt = service.idCheck(mid);
		System.out.println("결과 = "+cnt);
		return cnt;
	}
	
	/**
	 * 닉네임 중복 체크
	 * */
	@RequestMapping(value = "/nicknameCheck", method = RequestMethod.POST)
	@ResponseBody
	public int nicknameCheck(@RequestParam("nickname") String nickname) {
		System.out.println("nickname = "+nickname);
		int cnt = service.nicknameCheck(nickname);
		System.out.println(cnt);
		return cnt;
	}
	
	/**
	 * 회원가입
	 * */
	@RequestMapping(value = "/joinmember", method = RequestMethod.POST )
	public String insertMember(MemberVO vo) {
		System.out.println(vo.getMid());
		System.out.println(vo.getMpw());
		System.out.println(vo.getMname());
		System.out.println(vo.getNickname());
		service.insertMember(vo);
		return "/index";
	}
	
	/**
	 * 내 정보조회
	 * */
	@RequestMapping(value = "/myinfo")
	public ModelAndView selectMember(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session= request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("vo");
		System.out.println(vo.getMid());
		MemberVO dbvo = service.selectMember(vo.getMid());
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", dbvo);
		mv.setViewName("/member/myinfo");
		return mv;
	}
	
	/**
	 * 내 정보수정 - 닉네임 수정
	 * */
	@RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
	public String updateInfo(MemberVO vo) {
		System.out.println("updateinfo");
		System.out.println(vo.getMid());
		System.out.println(vo.getNickname());
		service.updateInfo(vo);
		return "/index";
	}
	
	/**
	 * 관리자 - 멤버 전체 조회
	 * */
	@RequestMapping(value = "/memberlist")
	public ModelAndView selectAll() {
		List<MemberVO> memberlist = service.selectAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist", memberlist);
		mv.setViewName("/admin/memberlist");
		return mv;
	}
	
	/**
	 * 관리자 - 멤버 상세 조회
	 * */
	@RequestMapping(value = "/memberdetail")
	public ModelAndView selectOne(int mno) {
		System.out.println(mno);
		MemberVO vo = service.selectOne(mno);
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);
		mv.setViewName("/admin/memberdetail");
		return mv;
	}
	
	/**
	 * 관리자 - 멤버 상태 변경
	 * 0 - 정상회원
	 * 1 - 관리자
	 * 2 - 정지회원
	 * */
	@RequestMapping(value = "/updateState")
	public String updateState(MemberVO vo) {
		System.out.println(vo.getMno());
		System.out.println(vo.getMstate());
		service.updateState(vo);
		return "redirect:/memberdetail?mno="+vo.getMno();
		
	}
	
}
