package edu.spring.semiproject;

import java.util.List;

public interface MemberService {
	public MemberVO logincheck(MemberVO vo);
	public int idCheck(String mid);
	public int nicknameCheck(String nickname);
	public void insertMember(MemberVO vo);
	public MemberVO selectMember(String mid);
	public void updateInfo(MemberVO vo);
	public List<MemberVO> selectAll();
	public MemberVO selectOne(int mno);
	public void updateState(MemberVO vo);
}
