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
	public String recommendList(HttpServletRequest req)
	{
		
		List<BoardVO> recommendBoardList = service.recommendBoardList();
		
		req.setAttribute("boardList", recommendBoardList);
		
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
	
}
