package com.s2jo.khx.model.lsk;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// ==== #28. DAO ?��?�� ====

@Repository
public class KhxDAO implements InterKhxDAO {

// ==== #29. ?��존객�? 주입?���? (DI : Dependency Injection) ====
	
	@Autowired
	private SqlSessionTemplate sqlsession;

// ==== #42. 메인 ?��?���??�� ?��미�? ?��?�� ?��름을 �??��?��?�� 모델?�� public List<String> getImgfilenameList() 메소?�� ?��?��?���?
//		?��미�? ?��?���? �??��?���?
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
