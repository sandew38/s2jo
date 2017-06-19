package com.s2jo.khx.model.hjs;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


//===== DAO 선언 =====
@Repository
public class HjsDAO implements InterHjsDAO {

//	===== 의존객체 주입하기(DI : Dependency Injection) =====
	@Autowired
	private SqlSessionTemplate sqlsession;

	
	// 기차역목록 보여주기
	@Override
	public List<String> getStationList() {
		List<String> stationList = sqlsession.selectList("hjs.getStationList");
		return stationList;
	}


}
