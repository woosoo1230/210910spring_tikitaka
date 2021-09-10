package edu.spring.semiproject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReplyController {

	@Autowired
	ReplyService replyService;
	
	@RequestMapping("/reply/insert")
	public String insertReply(ReplyVO reply ,int bno, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session= request.getSession();
		if(session.getAttribute("vo") != null) {
			MemberVO vo = (MemberVO)session.getAttribute("vo");
			reply.setMno(vo.getMno());
			reply.setBno(bno);
			replyService.insertReply(reply);
			return "redirect:/board/detail/?bno="+bno+"&flag=1";
		}else {
			return "/member/loginform";
		}
		
	}
}
