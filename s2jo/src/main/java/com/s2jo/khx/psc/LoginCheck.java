package com.s2jo.khx.psc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.s2jo.khx.model.psc.khxpscNonMemberVO;

@Aspect
/* 공통관심사 클래스 객체로 등록한다.
- 기존의 XML <aop:aspect> 역할을 한다. */
@Component
/* XML에서 빈을 만드는 대신에 클래스명 앞에 @Component 어노테이션을 적어주면 해당 클래스는 bean으로 자동 등록된다. 
그리고 bean의 이름(첫글자는 소문자)은 해당 클래스명이 된다. */
public class LoginCheck {

	@Pointcut("execution(public * com.s2jo.*.*Controller.requireLogin_*(..))")
	public void requireLogin(){
		
		
		
	}

	
	@Before("requireLogin()")
	public void before(JoinPoint joinPoint){
		HttpServletRequest request = (HttpServletRequest)joinPoint.getArgs()[0];
		HttpSession session = request.getSession();
		
		khxpscNonMemberVO nonloginuser = (khxpscNonMemberVO)session.getAttribute("nonloginuser");
		
    	HttpServletResponse response = (HttpServletResponse)joinPoint.getArgs()[1];

		
    	if(nonloginuser == null) {
    		try{
	    		String msg = "§§ !!먼저 로그인 하세요!! §§";
	    		String loc = "/nonlogin/nonlogin.action";
	    		
	    		request.setAttribute("msg", msg);
	    		request.setAttribute("loc", loc);
	    		
	    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/viewsnotiles/msg.jsp");
	    		dispatcher.forward(request, response); 
    		} catch(ServletException e) {
    			e.printStackTrace();
    		} catch(IOException e) {
    			e.printStackTrace();
    		}
    		
    		// >>>> 로그인 후 로그인 하기전 페이지로 돌아가는 작업 하기 <<<<
			// ===>>> 현재 페이지의 주소(URL) 알아내기 <<<=== //			
			String url = request.getRequestURL().toString();
			// 현재 페이지의 URL은 getRequestURL()을 이용해서 구한다.
			
			/* 
			     그런데 URL에 쿼리문자열이 섞여서 Get방식으로 값이 넘어온 페이지라면 
			   getRequestURL() 메소드는 쿼리문자열(? 부터 시작하는 것)을 잘라버리고 출력하게 된다. 
			     즉 아래의 쿼리문자열(?page=1&seq=10) 부분은 getRequestURL() 메소드로는 잡히지 않는다는 뜻이다.
			   http://localhost/board.action?page=1&seq=10
			   
			   Get방식으로 넘어온 쿼리문자열을 구하기 위한 request 객체의 메소드는 getQueryString() 이다. 
			     이 getQueryString() 메소드는 쿼리문자열이 없을때는 null을 리턴해준다.  
            */
			
			Boolean bool_addComment = url.endsWith("addComment.action");
			// 댓글쓰기를 할 경우
			
			Boolean bool_download = url.endsWith("download.action");
			// 파일받기를 할 경우
			
			if(bool_addComment) {
				url = url.replaceAll("addComment.action", "view.action");  
				// 로그인 후 글목록보기 페이지로 이동 하도록 한다.
			}
			else if(bool_download) {
				url = url.replaceAll("download.action", "view.action");  
				// 로그인 후 글목록보기 페이지로 이동 하도록 한다.
			}
			
			
			if(!bool_addComment && request.getQueryString() != null ) {
				// 댓글쓰기가 아니면서 쿼리문이 있는 경우
				url += "?" + request.getQueryString();	
			}
			else if(bool_addComment && request.getQueryString() != null ) {
				// 댓글쓰기이면서 쿼리문이 있는 경우
				String queryString = request.getQueryString();
				int index = queryString.indexOf("parentSeq=");
				String seqno = queryString.substring(index+"parentSeq=".length(), queryString.length());
				
				url += "?seq=" + seqno;	
			}
			
			
			System.out.println(" >>> 확인용 현재 페이지 URL : " + url);
			
			session.setAttribute("url", url); // 세션에 url 정보를 저장시켜둔다.	
			
    		
    	}// end of if-------------------------
    	
		
   
	
	}//end of public void before(JoinPoint joinPoint){
}//end of public class LoginCheck {
