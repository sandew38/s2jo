package com.s2jo.khx.model;

import java.util.HashMap;
import java.util.List;


// model 단 (DAO)의 인터페이스 생성

public interface InterKhxDAO {

	List<String> getImgfilenameList();	// 이미지 파일명 가져오기
		
	List<TrainviewVO> trainList();	// 기차 운행 정보 가져오기

} // end of public interface InterBoardDAO ----