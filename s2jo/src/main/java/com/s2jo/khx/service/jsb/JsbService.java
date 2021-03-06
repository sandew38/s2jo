package com.s2jo.khx.service.jsb;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.s2jo.khx.model.jsb.BoardVO;
import com.s2jo.khx.model.jsb.CommentVO;
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

	//글1개 보여주기
	@Override
	public BoardVO getRecommendView(String seq) {
		dao.setRecAddReadCount(seq); // 글 조회수 1증가
		BoardVO boardvo = dao.getRecommendView(seq); // 글 1개를 보여주는것
		
		return boardvo;
	}

	//  글 1개를 보여주는(조회수 1증가 없이) 서비스단 BoardVO getView(String seq) 메소드 생성하기 =====
	@Override
	public BoardVO getRecViewWithNoAddCount(String seq) {
			BoardVO boardvo = dao.getRecommendView(seq); // 글 1개를 보여주는것
		
		return boardvo;
	}

	// =====  1개글 수정하기 ===== 
	@Override
	public int recommendEdit(HashMap<String, String> map) {
			
			
			int n = 0;
			
		
			n = dao.recUpdateContent(map); // 글 1개 수정하기 
	
			
			return n;
			
		}

	//  1개 글삭제하기 =====	
	@Override
	public int recommendDel(HashMap<String, String> map) {
		int n = dao.recDelContent(map); // 글 1개 삭제(수정으로 처리)하기
		
		return n;
	}

	//댓글쓰기
	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation= Isolation.READ_COMMITTED, rollbackFor={Throwable.class})
	public int recAddComment(CommentVO commentvo) 
		throws Throwable {
		
		int n = 0;
		n = dao.recAddComment(commentvo);
		
		int result = 0;
		
		if(n==1) {
		    result = dao.recUpdateCommentCount(commentvo.getParentSeq());
		}
		
		return result;
	}

	// =====  댓글내용 보여주기 =====
		@Override
		public List<CommentVO> recListComment(String seq) {
			List<CommentVO> list = dao.recListComment(seq);
			return list;
		}

}
