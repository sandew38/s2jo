package com.s2jo.khx.jsb;

import java.io.File;
import java.util.HashMap;
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
	 
	 	
	// ===== #70. 글수정 페이지 요청 =====
	    @RequestMapping(value="jsb/recommendEdit.action", method={RequestMethod.GET})
	    public String requireLogin_edit(HttpServletRequest req, HttpServletResponse res, HttpSession session) { 
	    	
	    	// 글 수정해야할 글번호 가져오기
	    	String seq = req.getParameter("seq");
	    	
	    	// 글 수정해야할 글전체 내용 가져오기
	    	BoardVO boardvo = service.getRecViewWithNoAddCount(seq);
	    	// 조회수(readCount) 1증가 없이 그냥 글 1개를 가져오는 것
	    
	    /*	MemberVO loginuser = (MemberVO)session.getAttribute("loginuser");
	    	
	    	if(loginuser != null &&
	    	  !loginuser.getUserid().equals(boardvo.getUserid())) {
	    		String msg = "다른 사용자의 글은 수정이 불가합니다.";
	    		String loc = "javascript:history.back()";
	    		
	    		req.setAttribute("msg", msg);
	    		req.setAttribute("loc", loc);
	    		
	    		return "msg.notiles";
	    		// /Board/src/main/webapp/WEB-INF/viewsnotiles/msg.jsp 파일을 생성한다.
	    	}
	    	else if(loginuser != null &&
	    	        loginuser.getUserid().equals(boardvo.getUserid())){
	    		// 가져온 1개글을 request 영역에 저장시켜서 view 단 페이지로 넘긴다.
	    		req.setAttribute("boardvo", boardvo);
	    		
	    		return "board/edit.tiles2";
	    		// /Board/src/main/webapp/WEB-INF/views2/board/edit.jsp 파일을 생성한다.
	    	}
	    	else {
	    		String msg = "먼저 로그인부터 하세요.";
	    		String loc = "/board/login.action";
	    		
	    		req.setAttribute("msg", msg);
	    		req.setAttribute("loc", loc);
	    		
	    		return "msg.notiles";
	    	}
	    */	
	    	
	    	//MemberVO loginuser = (MemberVO)session.getAttribute("loginuser");
	    	/*
	    	if(!loginuser.getUserid().equals(boardvo.getUserid()) ) { 
	    		String msg = "다른 사용자의 글은 수정이 불가합니다.";
	    		String loc = "javascript:history.back()";
	    		
	    		req.setAttribute("msg", msg);
	    		req.setAttribute("loc", loc);
	    		
	    		return "msg.notiles";
	    		// /Board/src/main/webapp/WEB-INF/viewsnotiles/msg.jsp 파일을 생성한다.	
	    	}
	    	else {*/
	    		req.setAttribute("boardvo", boardvo);
	    		
	    		return "jsb/board/recommend/recommendEdit.tiles";
	    		// /Board/src/main/webapp/WEB-INF/views2/board/edit.jsp 파일을 생성한다.
	    	//}
	    	
	    } 
	    
	 //  글수정 페이지 완료하기 =====
	    @RequestMapping(value="jsb/recommendEditEnd.action", method={RequestMethod.POST})
	    public String editEnd(BoardVO boardvo, HttpServletRequest req) { 
	    	
	    	HashMap<String, String> map = new HashMap<String, String>();
	    	map.put("seq", boardvo.getSeq());
	    	map.put("subject", boardvo.getSubject());
	    	map.put("content", boardvo.getContent());
	    	
	    	/*
	    	 글수정을 하려면 원본글의 암호와 수정시 입력해주는 암호가 일치할때만 수정이 가능하도록 한다.
	    	 서비스단에서 글수정을 처리한 결과를 int 타입으로 받아오겠다. 
	    	 */
	    	int n = service.recommendEdit(map);
	    	// 넘겨받은 값이 1이면 update 성공,
	    	// 넘겨받은 값이 0이면 update 실패(암호가 틀리므로).
	    	
	    	// n(글수정 성공 또는 실패)값을 request 영역에 저장시켜서 view 단 페이지로 넘긴다.
	    	// 그리고 변경되어진 글을 보여주기 위해서 request 영역에 변경한 글번호도 저장시키도록 한다.
	    	req.setAttribute("n", n);
	    	req.setAttribute("seq", boardvo.getSeq()); // 수정된 자신의 글을 보여주기 위해서 넘긴다.
	    	
	    	return "jsb/board/recommend/recommendEditEnd.tiles";
	    	// /Board/src/main/webapp/WEB-INF/views2/board/editEnd.jsp 파일을 생성한다.
	    } 
	 
	 
	
}
