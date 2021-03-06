package com.s2jo.khx.model.jsb;

import java.util.HashMap;
import java.util.List;

public interface InterJsbDAO {



	int recommendAdd(BoardVO boardvo); //글쓰기 (최초)

	List<BoardVO> recommendBoardList();//글목록보여주기(최초)

	void setRecAddReadCount(String seq);// 글 1개를 볼때 조회수(readCount) 1증가 시키기 =====

	BoardVO getRecommendView(String seq);//글 1개 보여주는 BoardVO getView(String seq) 메소드 생성하기

	int recUpdateContent(HashMap<String, String> map); //글 수정하기

	int recDelContent(HashMap<String, String> map);//글 삭제하기

	int recAddComment(CommentVO commentvo); //댓글쓰기

	int recUpdateCommentCount(String parentSeq);//댓글카운트 추가하기

	List<CommentVO> recListComment(String parentSeq);//댓글보여주기
	

}
