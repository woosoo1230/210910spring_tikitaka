package edu.spring.semiproject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/joinmember", method = RequestMethod.GET )
	public String joinForm() {
		return "/member/joinform";
	}
	
	@RequestMapping(value = "/joinmember", method = RequestMethod.POST )
	public String insertMember(MemberVO vo) {
		System.out.println(vo.getMid());
		System.out.println(vo.getMpw());
		System.out.println(vo.getMname());
		System.out.println(vo.getNickname());
		service.insertMember(vo);
		return "/index";
	}
}
