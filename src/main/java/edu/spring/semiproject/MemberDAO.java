package edu.spring.semiproject;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	SqlSession session;
	
	public MemberVO logincheck(MemberVO vo) {
		return session.selectOne("member.logincheck", vo);
	}
	
	public int idCheck(String mid) {
		return session.selectOne("member.idCheck", mid);
	}
	
	public int nicknameCheck(String nickname) {
		return session.selectOne("member.nicknameCheck", nickname);
	}
	
	public void insertMember(MemberVO vo) {
		session.insert("member.insertmember", vo);
	}
	
	public MemberVO selectMember(String mid) {
		return session.selectOne("member.selectMember", mid);
	}
	
	public void updateInfo(MemberVO vo) {
		session.update("member.updateInfo", vo);
	}
	
	public List<MemberVO> selectAll(){
		return session.selectList("member.selectAll");
	}
	
	public MemberVO selectOne(int mno) {
		return session.selectOne("member.selectOne", mno);
	}
	
	public void updateState(MemberVO vo) {
		session.update("member.updateState", vo);
	}
}
