package com.s2jo.khx.service.jsb;

import java.util.List;

import com.s2jo.khx.model.jsb.BoardVO;

public interface InterJsbService {

	int recommendAdd(BoardVO boardvo); //추천게시판에 글 추가(최초)

	List<BoardVO> recommendBoardList();//글보여주기(최초)

}
