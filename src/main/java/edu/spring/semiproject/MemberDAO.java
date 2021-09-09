package edu.spring.semiproject;

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
	
	
	public void insertMember(MemberVO vo) {
		session.insert("member.insertmember", vo);
	}
}
