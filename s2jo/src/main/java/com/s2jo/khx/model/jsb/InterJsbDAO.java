package com.s2jo.khx.model.jsb;

import java.util.List;

public interface InterJsbDAO {



	int recommendAdd(BoardVO boardvo); //글쓰기 (최초)

	List<BoardVO> recommendBoardList();//글목록보여주기(최초)

	void setRecAddReadCount(String seq);// 글 1개를 볼때 조회수(readCount) 1증가 시키기 =====

	BoardVO getRecommendView(String seq);//글 1개 보여주는 BoardVO getView(String seq) 메소드 생성하기
	

}
