package com.s2jo.khx.model.psc;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository//DAO 선언
public class khxpscNonMemberDAO {

	//의존객체 주입하기(DI : Dependency Injection) =====
	@Autowired
	private SqlSessionTemplate sqlsession;

	//비회원정보 가져오기
	public int nonloginEnd(HashMap<String, String> map) {
		int n = sqlsession.selectOne("pscmember.nonloginEnd", map);
									/*xml이름.xml에서 불러다 쓸 ID*/
		return n;
	}
	
	//로그인성공한 비회원 정보가져오기
	public khxpscNonMemberVO getNonLoginEnd(String nhp) {
		khxpscNonMemberVO nonloginuser = sqlsession.selectOne("pscmember.getNonLoginEnd", nhp);
		return nonloginuser;
	}


/*
	//회원정보 가져오기
	public int nonloginEnd(HashMap<String, String> map) {
		int n = sqlsession.selectOne("board.nonloginEnd", map);
		return n;
	}
		
	//로그인성공한 회원 정보가져오기
	public khxpscNonMemberVO getLoginMember(String nhp) {
		khxpscNonMemberVO loginuser = sqlsession.selectOne("board.getLoginMember", nhp);
		return loginuser;
	}
*/


}//end of public class khxpscNonMemberDAO {
