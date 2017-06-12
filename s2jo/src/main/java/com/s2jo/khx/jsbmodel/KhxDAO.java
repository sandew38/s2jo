package com.s2jo.khx.jsbmodel;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// ==== #28. DAO ?„ ?–¸ ====

@Repository
public class KhxDAO implements InterKhxDAO {

// ==== #29. ?˜ì¡´ê°ì²? ì£¼ì…?•˜ê¸? (DI : Dependency Injection) ====
	
	@Autowired
	private SqlSessionTemplate sqlsession;

// ==== #42. ë©”ì¸ ?˜?´ì§??š© ?´ë¯¸ì? ?ŒŒ?¼ ?´ë¦„ì„ ê°?? ¸?˜¤?Š” ëª¨ë¸?‹¨ public List<String> getImgfilenameList() ë©”ì†Œ?“œ ?ƒ?„±?•˜ê¸?
//		?´ë¯¸ì? ?ŒŒ?¼ëª? ê°?? ¸?˜¤ê¸?
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
