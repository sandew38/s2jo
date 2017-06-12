package com.s2jo.khx.service.kyj;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.s2jo.khx.model.kyj.KhxDAO;
import com.s2jo.khx.model.kyj.RuninfoVO;
import com.s2jo.khx.model.kyj.TrainviewVO;

//	==== #30. Service 선언 ====

@Service
public class KhxService implements InterKhxService {

//	==== #31. 의존객체 주입하기 (DI : Dependency Injection) ====
	
	@Autowired
	private KhxDAO kdao;

	
//	==== #41. 메인 페이지용 이미지 파일 이름을 가져오는 서비스단 public List<String> getImgfilenameList() 메소드 생성하기
// 			이미지 파일명 가져오기
	@Override
	public List<String> getImgfilenameList() {
		
		 List<String> list = kdao.getImgfilenameList();
		 
		 return list;
	
		 
	}

// ==== 열차 운행 정보 알아오는 메소드

	@Override
	public List<TrainviewVO> trainList() {

		List<TrainviewVO> trainList = kdao.trainList();
		
		return trainList;
	}	
	
} // end of public class BoardService implements InterBoardService ----
