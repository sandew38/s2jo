package com.s2jo.khx.service.kyj;

import java.util.HashMap;
import java.util.List;

import org.springframework.aop.ThrowsAdvice;

import com.s2jo.khx.model.kyj.RuninfoVO;
import com.s2jo.khx.model.kyj.TrainviewVO;

// Service 단 인터페이스 선언

public interface InterKhxService {
	
	List<String> getImgfilenameList();	// 이미지 파일명 가져오기

	List<String> departureList();	// 출발지 목록 가져오기 
	
	List<String> arrivalList();	// 도착지 목록 가져오기 
	
	List<TrainviewVO> trainList();	// 기차 운행 정보 가져오기

}
