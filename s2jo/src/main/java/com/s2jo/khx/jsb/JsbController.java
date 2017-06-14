package com.s2jo.khx.jsb;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.s2jo.khx.common.FileManager;
import com.s2jo.khx.model.jsb.BoardVO;
import com.s2jo.khx.service.jsb.JsbService;



@Controller
@Component
// XML에서 bean을 만드는 대신에
// 클래스명 앞에 @Component 어노테이션을 쓰면
// 해당 클래스는 bean으로 자동 등록된다.
// 그리고 bean의 id는 해당 클래스명이 된다. (첫 글자는 소문자)
public class JsbController {

	
	//의존객체 주입하기 (DI : Dependency Injection) ====
			
	@Autowired
	private JsbService service; 
	
//  파일업로드 및 파일다운로드를 해주는 FileManager 클래스 의존객체 주입하기(DI : Dependency Injection) =====
    @Autowired
    private FileManager fileManager;
	
	//글목록
	@RequestMapping(value="/jsb/recommendList.action", method={RequestMethod.GET})
	public String recommendList(HttpServletRequest req, HttpSession session)
	{
		
		List<BoardVO> recommendBoardList = service.recommendBoardList();
		
		req.setAttribute("boardList", recommendBoardList);
		
		session.setAttribute("readCountPermission", "yes");
		
		return "jsb/board/recommend/recommendList.tiles";
//		└> /Board/src/main/webapp/WEB-INF/views/recommendList/recommendList.jsp 파일을 생성한다.
		
	} // end of public String recommendList(HttpServletRequest req) ----
	
	//글쓰기
	 @RequestMapping(value="/jsb/recommendAdd.action", method={RequestMethod.GET})
	 public String recommendAdd(HttpServletRequest req, HttpServletResponse res) { 
	    	
	    	
	    	
	    	return "jsb/board/recommend/recommendAdd.tiles";
	    	// /Board/src/main/webapp/WEB-INF/views/board/recommendList/recommendAdd.jsp 파일을 생성한다.
	    }// end of String add(HttpServletRequest req, HttpServletResponse res)..
	    
	 
	 //글쓰기저장(addEnd) 
	 @RequestMapping(value="/jsb/recommendAddEnd.action", method={RequestMethod.POST})
	 public String recommendAddEnd(BoardVO boardvo, HttpServletRequest req) {
		   
		    	int n = service.recommendAdd(boardvo);

		    	
		    	req.setAttribute("n", n);
		    	
		    	return "jsb/board/recommend/recommendAddEnd.tiles";
		    	// /Board/src/main/webapp/WEB-INF/views2/board/addEnd.jsp 파일을 생성한다.
		    }
	 
	 
	 //  글 1개를 보여주는 페이지 요청하기 =====
	 @RequestMapping(value="jsb/recommendView.action", method={RequestMethod.GET})
	 public String recommendView(HttpServletRequest req, HttpSession session) { 
	    	
	    	String seq = req.getParameter("seq");
	    	
	    	BoardVO boardvo = null;
	    	
	    	/* ===== #67. 글조회수(readCount)증가(DML문 update)는 
	    	                반드시 해당 글제목을 클릭했을 경우에만 증가되고 
	    	                웹브라우저에서 새로고침(F5)을 했을 경우에는
	    	                증가가 안되도록 한다. =====
	    	*/  
	    	if(session.getAttribute("readCountPermission") != null && 
	    	   "yes".equals(session.getAttribute("readCountPermission")) ) {
	    		
	    		boardvo = service.getRecommendView(seq);
	    		// 조회수(readCount) 1증가 후 글 1개를 가져오는 것
	    		
	    		session.setAttribute("readCountPermission", "no");
	    		// session "readCountPermission" 값을 "yes"에서 "no"로 변경함.
	    	}
	    	else {
	    		// 새로고침(F5)을 했을 경우
	    		boardvo = service.getRecViewWithNoAddCount(seq);
	    		// 조회수(readCount) 1증가 없이 그냥 글 1개를 가져오는 것
	    	}
	    	
	    	
	    	/*
	    	  글내용에 엔터("\r\n")가 들어가 있으면  
	    	  엔터("\r\n")를 <br>로 대체시켜서
	    	  request 영역으로 넘긴다.
	    	 */
	    	String content = boardvo.getContent();
	    	content = content.replaceAll("\r\n", "<br>");
	    	boardvo.setContent(content);
	    	
	    	req.setAttribute("boardvo", boardvo);
	    	
	    	/*// ===== #89. 댓글 내용 가져오기 ======
	    	List<CommentVO> commentList = service.listComment(seq);
	    	req.setAttribute("commentList", commentList); */
	    	
	    	return "jsb/board/recommend/recommendView.tiles";
	    	// /Board/src/main/webapp/WEB-INF/views2/board/view.jsp 파일을 생성한다.
	    }    
	 
	 
	
}
