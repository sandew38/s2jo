package com.s2jo.khx.model;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// ==== #28. DAO 선언 ====

@Repository
public class KhxDAO implements InterKhxDAO {

// ==== #29. 의존객체 주입하기 (DI : Dependency Injection) ====
	
	@Autowired
	private SqlSessionTemplate sqlsession;

// ==== #42. 메인 페이지용 이미지 파일 이름을 가져오는 모델단 public List<String> getImgfilenameList() 메소드 생성하기
//		이미지 파일명 가져오기
	@Override
	public List<String> getImgfilenameList() {
		
		List<String> list = sqlsession.selectList("khx.getImgfilenameList");
		
		return list;
		
	}

	@Override
	public List<TrainviewVO> trainList() {
	
		List<TrainviewVO> trainList = sqlsession.selectList("khx.trainList");
		
		return trainList;
	}
	
} // end of public class BoardDAO implements InterBoardDAO ----
