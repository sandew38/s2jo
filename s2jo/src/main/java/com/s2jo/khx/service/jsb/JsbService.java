package com.s2jo.khx.service.jsb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s2jo.khx.model.jsb.BoardVO;
import com.s2jo.khx.model.jsb.JsbDAO;


@Service
public class JsbService implements InterJsbService{

//	=====  의존객체 주입하기(DI : Dependency Injection) =====
	@Autowired
	private JsbDAO dao;
	
	//글 추가하기(최초)
	@Override
	public int recommendAdd(BoardVO boardvo) {
		
		
		int n = dao.recommendAdd(boardvo);
		return n;
	}

	//글보여주기(최초)
	@Override
	public List<BoardVO> recommendBoardList() {
		List<BoardVO> recommendBoardList = dao.recommendBoardList();
		return recommendBoardList;
	}

}
