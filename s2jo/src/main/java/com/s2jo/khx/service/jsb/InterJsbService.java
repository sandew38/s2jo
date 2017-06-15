package com.s2jo.khx.service.jsb;

import java.util.HashMap;
import java.util.List;

import com.s2jo.khx.model.jsb.BoardVO;

public interface InterJsbService {

	int recommendAdd(BoardVO boardvo); //추천게시판에 글 추가(최초)

	List<BoardVO> recommendBoardList();//글보여주기(최초)

	BoardVO getRecommendView(String seq); //글 1개 보여주기(최초)

	BoardVO getRecViewWithNoAddCount(String seq); //조회수증가없이 글1개 보여주기

	int recommendEdit(HashMap<String, String> map); //글 수정하기

}
