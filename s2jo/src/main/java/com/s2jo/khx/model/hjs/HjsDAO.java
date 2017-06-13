package com.s2jo.khx.model.hjs;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//===== DAO 선언 =====
@Repository
public class HjsDAO implements InterHjsDAO {

//	===== 의존객체 주입하기(DI : Dependency Injection) =====
	@Autowired
	private SqlSessionTemplate sqlsession;
	
	
}
