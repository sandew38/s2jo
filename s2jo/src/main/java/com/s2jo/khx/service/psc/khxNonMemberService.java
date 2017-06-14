package com.s2jo.khx.service.psc;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.s2jo.khx.model.psc.khxpscNonMemberDAO;
import com.s2jo.khx.model.psc.khxpscNonMemberVO;

//	==== #30. Service 선언 ====

@Service
public class khxNonMemberService implements InterkhxNonMemberService {

//	==== #31. 의존객체 주입하기 (DI : Dependency Injection) ====
	
	@Autowired
	private khxpscNonMemberDAO knmdao;
	
	@Override//비회원 로그인 여부 알아오기
	public int nonloginEnd(HashMap<String, String> map) {
		int n = knmdao.nonloginEnd(map);
		return n;
	}
	
	
	@Override//로그인 성공한 비회원 정보 가져오기
	public khxpscNonMemberVO getnonLoginMember(String nhp) {
		khxpscNonMemberVO nonloginuser = knmdao.getnonLoginMember(nhp);
		return nonloginuser;
	}


	public khxpscNonMemberVO getnonLoginMember(khxpscNonMemberVO nonloginuser) {
		// TODO Auto-generated method stub
		return null;
	}



/*
	public khxpscNonMemberVO getnonLoginMember(khxpscNonMemberVO nonloginuser) {
		// TODO Auto-generated method stub
		return null;
	}
*/


	
	
} // end of public class BoardService implements InterBoardService ----
