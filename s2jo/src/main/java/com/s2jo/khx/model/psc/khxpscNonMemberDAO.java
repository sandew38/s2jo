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

	//정회원 정보 가져오기!
	public int loginEnd(HashMap<String, String> map) {
		int n = sqlsession.selectOne("pscmember.loginEnd", map);
									//xml이름.xml에서 불러다 쓸 ID
		return n;
	}

	//정회원 로그인 완료요청 !
	public khxpscMemberVO getLoginEnd(String userid) {
		khxpscMemberVO loginuser = sqlsession.selectOne("pscmember.getLoginEnd", userid);
		return loginuser;
	}


}//end of public class khxpscNonMemberDAO {














