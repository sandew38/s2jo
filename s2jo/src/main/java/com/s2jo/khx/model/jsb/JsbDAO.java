package com.s2jo.khx.model.jsb;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JsbDAO implements InterJsbDAO{
//	 의존객체 주입하기(DI : Dependency Injection) =====
	@Autowired
	private SqlSessionTemplate sqlsession;
	

	//글쓰기를 해주는 int add(BoardVO boardvo) 메소드 생성하기 =====(최초)
	@Override
	public int recommendAdd(BoardVO boardvo) {
		int n = sqlsession.insert("jsb.recommendAdd", boardvo);
		return n;	
	}

	//글목록보여주기(최초)
	@Override
	public List<BoardVO> recommendBoardList() {
		List<BoardVO> recommendBoardList = sqlsession.selectList("jsb.recommendBoardList");
		return recommendBoardList;
	}
	
	//글 1개를 볼때 조회수(readCount) 1증가 시키기 =====
	@Override
	public void setRecAddReadCount(String seq) {
		sqlsession.update("jsb.setRecAddReadCount", seq);
	}

	// 글 1개 보여주는 BoardVO getRecommendView(String seq) 메소드 생성하기 =====
	@Override
	public BoardVO getRecommendView(String seq) {
		BoardVO boardvo = sqlsession.selectOne("jsb.getRecommendView", seq);
		return boardvo;
	
	}
	

}
