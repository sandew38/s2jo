
package com.s2jo.khx.psc;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.s2jo.khx.common.FileManager;
import com.s2jo.khx.model.psc.khxpscNonMemberVO;
import com.s2jo.khx.service.psc.khxNonMemberService;

import oracle.net.aso.b;

// ==== #31. 컨트롤러 선언 ====

@Controller
@Component
// XML에서 bean을 만드는 대신에
// 클래스명 앞에 @Component 어노테이션을 쓰면
// 해당 클래스는 bean으로 자동 등록된다.
// 그리고 bean의 id는 해당 클래스명이 된다. (첫 글자는 소문자)

public class KhxpscController {

// ====  의존객체 주입하기 (DI : Dependency Injection) ====
	
		@Autowired
		private khxNonMemberService service; 

		
		   
// =====  비회원 로그인 폼 페이지 요청 =====
	    @RequestMapping(value="/nonloginform.action", method={RequestMethod.GET})
	    public String nonlogin(HttpServletRequest req) {
	    	
	    	// System.out.println("여기오나?");
	    	
	    	return "nonlogin/nonloginform.tiles";
	    	// /Board/src/main/webapp/WEB-INF/views/nonlogin/nonloginform.jsp 파일을 생성한다.
	    }
/*	    
	    
	    // =====  로그인 완료 요청 =====
	    @RequestMapping(value="/nonloginEnd.action", method={RequestMethod.POST})
	    public String nonloginEnd(HttpServletRequest req, khxpscNonMemberVO nonloginuser, HttpSession session) {
	    	
	    	String nhp = req.getParameter("nhp");
	    	String npwd = req.getParameter("npwd");
	    	
	    	HashMap<String, String> map = new HashMap<String, String>();
	    	map.put("nhp", nhp);
	    	map.put("npwd", npwd);
	    	
	    	
	    	  로그인을 하려면 아이디와 암호가 암호화 되어 DB에 저장되어진 것과 일치할때만 로그인이 되어지도록 해야 한다.
	    	  서비스단에서 로그인 여부 결과를 int 타입(1 or 0 or -1)으로 받아오겠다.
	    	 
	    	
	    	 int n =service.nonloginEnd(map);
	    	 // 넘겨받은 n 값이 1 이면 아이디와 암호가 일치하는 경우
	    	 // 넘겨받은 n 값이 0 이면 암호가 틀리는 경우
	    	 // 넘겨받은 n 값이 -1 이면 아이디가 없는 경우
	    	 
	    	 // 로그인 결과(1 or 0 or -1)를 request 영역에 저장시켜서 view 단 페이지로 넘긴다.
	    	 req.setAttribute("n", n);
	    	 
	    	 if(n==1) {
	    		 nonloginuser = service.getnonLoginMember(nonloginuser);
	    		 session.setAttribute("nonloginuser", nonloginuser);
	    		 
	    		 
	    		 // 로그인을 하지 않은 상태에서 글쓰기, 글수정, 글삭제를 했을때
	    		 // 현재 페이지의 주소를 세션에 "url" 이라는 키값으로
	    		 // 저장해둔 현재 페이지의 주소를 읽어온다.
	    		 String url = (String)session.getAttribute("url");
	    		 req.setAttribute("url", url);
	    	 }
	    	
	    	return "nonlogin/nonloginEnd.tiles";
	    	// /Board/src/main/webapp/WEB-INF/views/login/loginEnd.jsp 파일을 생성한다.
	    }
		
	    
	    // ===== #53. 로그아웃 완료 요청 =====
	    @RequestMapping(value="/nonlogout.action", method={RequestMethod.GET})
	    public String nonlogout(HttpServletRequest req, HttpSession session) { 
	    	
	    	session.invalidate();
	    	
	    	return "nonlogin/nonlogout.tiles";
	    	// /Board/src/main/webapp/WEB-INF/views/login/logout.jsp 파일을 생성한다.
	    }
	    */
	    ////////////////////////////////////////////////////////////////////////////////////////////

	  /*  // =====  로그인 완료 요청 =====
	    @RequestMapping(value="/loginEnd.action", method={RequestMethod.POST})
	    public String loginEnd(HttpServletRequest req, khxpscNonMemberVO loginuser, HttpSession session) {
	    	
	    	String userid = req.getParameter("userid");
	    	String pwd = req.getParameter("pwd");
	    	
	    	HashMap<String, String> map = new HashMap<String, String>();
	    	map.put("userid", userid);
	    	map.put("pwd", pwd);
	    	
	    	
	    	  로그인을 하려면 아이디와 암호가 암호화 되어 DB에 저장되어진 것과 일치할때만 로그인이 되어지도록 해야 한다.
	    	  서비스단에서 로그인 여부 결과를 int 타입(1 or 0 or -1)으로 받아오겠다.
	    	 
	    	
	    	 int n =service.loginEnd(map);
	    	 // 넘겨받은 n 값이 1 이면 아이디와 암호가 일치하는 경우
	    	 // 넘겨받은 n 값이 0 이면 암호가 틀리는 경우
	    	 // 넘겨받은 n 값이 -1 이면 아이디가 없는 경우
	    	 
	    	 // 로그인 결과(1 or 0 or -1)를 request 영역에 저장시켜서 view 단 페이지로 넘긴다.
	    	 req.setAttribute("n", n);
	    	 
	    	 if(n==1) {
	    		 loginuser = service.getLoginMember(userid);
	    		 session.setAttribute("loginuser", loginuser);
	    		 
	    		 
	    		 // 로그인을 하지 않은 상태에서 글쓰기, 글수정, 글삭제를 했을때
	    		 // 현재 페이지의 주소를 세션에 "url" 이라는 키값으로
	    		 // 저장해둔 현재 페이지의 주소를 읽어온다.
	    		 String url = (String)session.getAttribute("url");
	    		 req.setAttribute("url", url);
	    	 }
	    	
	    	return "login/loginEnd.tiles";
	    	// /Board/src/main/webapp/WEB-INF/views/login/loginEnd.jsp 파일을 생성한다.
	    }
		
	    
	    // ===== #53. 로그아웃 완료 요청 =====
	    @RequestMapping(value="/logout.action", method={RequestMethod.GET})
	    public String logout(HttpServletRequest req, HttpSession session) { 
	    	
	    	session.invalidate();
	    	
	    	return "login/logout.tiles";
	    	// /Board/src/main/webapp/WEB-INF/views/login/logout.jsp 파일을 생성한다.
	    }
*/
}
