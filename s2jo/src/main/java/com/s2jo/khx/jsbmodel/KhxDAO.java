package com.s2jo.khx.jsbmodel;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// ==== #28. DAO ? ?Έ ====

@Repository
public class KhxDAO implements InterKhxDAO {

// ==== #29. ?μ‘΄κ°μ²? μ£Όμ?κΈ? (DI : Dependency Injection) ====
	
	@Autowired
	private SqlSessionTemplate sqlsession;

// ==== #42. λ©μΈ ??΄μ§??© ?΄λ―Έμ? ??Ό ?΄λ¦μ κ°?? Έ?€? λͺ¨λΈ?¨ public List<String> getImgfilenameList() λ©μ? ??±?κΈ?
//		?΄λ―Έμ? ??Όλͺ? κ°?? Έ?€κΈ?
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
