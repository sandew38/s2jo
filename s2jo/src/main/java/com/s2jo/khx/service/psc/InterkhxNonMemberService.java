package com.s2jo.khx.service.psc;

import java.util.HashMap;
import java.util.List;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s2jo.khx.model.psc.khxpscNonMemberDAO;
import com.s2jo.khx.model.psc.khxpscNonMemberVO;

// Service 단 인터페이스 선언
public interface InterkhxNonMemberService {

	
	int nonloginEnd(HashMap<String, String> map); // 비회원 로그인 여부 알아오기 

	khxpscNonMemberVO getNonLoginEnd(String nhp); //비회원 로그인완료 요청


	
//  khxpscNonMemberVO nonLoginMember(String nhp); // 로그인 성공한 비회원 정보 가져오기
	
//	int loginEnd(HashMap<String, String> map); // 로그인 여부 알아오기

//	khxpscMemberVO getLoginMember(String userid); // 로그인 성공한 사용자 정보 가져오기

	}//end of public interface InterkhxNonMemberService {
