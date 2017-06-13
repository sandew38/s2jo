package com.s2jo.khx.jsb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value="/jsb/recommendList.action", method={RequestMethod.GET})
	public String recommendList(HttpServletRequest req)
	{
		
		return "jsb/board/recommend/recommendList.tiles";
//		└> /Board/src/main/webapp/WEB-INF/views/recommendList/khx.jsp 파일을 생성한다.
		
	} // end of public String recommendList(HttpServletRequest req) ----
	
	 @RequestMapping(value="/jsb/recommendAdd.action", method={RequestMethod.GET})
	    public String add(HttpServletRequest req, HttpServletResponse res) { 
	    	
	    	// ===== # 119. 답변글쓰기 추가되었으므로 아래와 같이 한다. ===== 
	    	String fk_seq = req.getParameter("fk_seq");
	    	String groupno = req.getParameter("groupno"); 
	    	String depthno = req.getParameter("depthno");
	    	
	    	req.setAttribute("fk_seq", fk_seq);
	    	req.setAttribute("groupno", groupno);
	    	req.setAttribute("depthno", depthno);
	    	
	    	return "jsb/board/recommend/recommendAdd.tiles";
	    	// /Board/src/main/webapp/WEB-INF/views2/board/add.jsp 파일을 생성한다.
	    }
	    
	
}
