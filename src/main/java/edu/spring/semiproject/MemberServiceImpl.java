package edu.spring.semiproject;

import java.util.List;

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
	public int idCheck(String mid) {
		return dao.idCheck(mid);
	}
	
	@Override
	public int nicknameCheck(String nickname) {
		return dao.nicknameCheck(nickname);
	}

	@Override
	public void insertMember(MemberVO vo) {
		dao.insertMember(vo);
	}

	@Override
	public MemberVO selectMember(String mid) {
		return dao.selectMember(mid);
	}

	@Override
	public void updateInfo(MemberVO vo) {
		dao.updateInfo(vo);
	}

	@Override
	public List<MemberVO> selectAll() {
		return dao.selectAll();
	}

	@Override
	public MemberVO selectOne(int mno) {
		return dao.selectOne(mno);
	}

	@Override
	public void updateState(MemberVO vo) {
		dao.updateState(vo);
	}


	

}
