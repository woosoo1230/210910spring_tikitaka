package edu.spring.semiproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDAO dao;
	
	@Override
	public MemberVO logincheck(MemberVO vo) {
		return dao.logincheck(vo);
	}

	@Override
	public void insertMember(MemberVO vo) {
		dao.insertMember(vo);
	}


}
