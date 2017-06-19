package com.s2jo.khx.service.hjs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s2jo.khx.model.hjs.HjsDAO;
import com.s2jo.khx.model.jsb.BoardVO;


//===== Service 선언 =====
@Service
public class HjsService implements InterHjsService {

	//	=====  의존객체 주입하기(DI : Dependency Injection) =====
	@Autowired
	private HjsDAO dao;
	
	
	// 기차역목록 보여주기
	@Override
	public List<String> getStationList() {
		
		List<String> stationList = dao.getStationList();
		
		return stationList;
	}

}
