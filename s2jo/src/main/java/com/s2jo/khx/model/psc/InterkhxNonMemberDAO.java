package com.s2jo.khx.model.psc;

import java.util.HashMap;

public interface InterkhxNonMemberDAO {

	int nonloginEnd(HashMap<String, String> map); //비회원 로그인 여부 알아오기
	
	khxpscNonMemberVO getNonLoginEnd(String nhp); // 로그인한 비회원 정보 가져오기	
	
	int loginEnd(HashMap<String, String> map);	  // 정회원 로그인 여부 알아오기
	
	khxpscMemberVO getLoginEnd(String userid); // 로그인한 비회원 정보 가져오기	

}//end of public interface InterkhxNonMemberDAO {
