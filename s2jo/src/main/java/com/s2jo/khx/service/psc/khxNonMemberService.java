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

	@Override//비회원 로그인여부 확인
	public int nonloginEnd(HashMap<String, String> map) {
		int n= knmdao.nonloginEnd(map);
		return n;
	}//end of public int nonloginEnd(HashMap<String, String> map) {

	@Override//비회원 로그인완료 요청
	public khxpscNonMemberVO getNonLoginEnd(String nhp) {
		khxpscNonMemberVO nonloginuser = knmdao.getNonLoginEnd(nhp);
		return nonloginuser;
	}

 

	
	
} // end of public class BoardService implements InterBoardService ----
