package com.s2jo.khx.model.jsb;

import java.util.List;

public interface InterJsbDAO {



	int recommendAdd(BoardVO boardvo); //글쓰기 (최초)

	List<BoardVO> recommendBoardList();//글목록보여주기(최초)

}
