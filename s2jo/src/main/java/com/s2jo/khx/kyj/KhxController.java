
package com.s2jo.khx.kyj;

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
import com.s2jo.khx.model.kyj.RuninfoVO;
import com.s2jo.khx.model.kyj.TrainviewVO;
import com.s2jo.khx.service.kyj.KhxService;

import oracle.net.aso.b;

// ==== #31. 컨트롤러 선언 ====

@Controller
@Component
// XML에서 bean을 만드는 대신에
// 클래스명 앞에 @Component 어노테이션을 쓰면
// 해당 클래스는 bean으로 자동 등록된다.
// 그리고 bean의 id는 해당 클래스명이 된다. (첫 글자는 소문자)

public class KhxController {

// ==== #33. 의존객체 주입하기 (DI : Dependency Injection) ====
	
		@Autowired
		private KhxService service; 
		
// ==== #130. 파일 업로드 & 다운로드를 위한 FileManager 클래스 의존 객체 주입하기 		
		@Autowired
		private FileManager fileManager;	
				
// ==== #40. 메인 페이지 요청. ====	
		
		@RequestMapping(value="/khx.action", method={RequestMethod.GET})
		
		public String index(HttpServletRequest req)
		{
			// 출발지 목록 가져오기
			List<String> departureList = service.departureList();
			
			// 도착지 목록 가져오기
			List<String> arrivalList = service.arrivalList();
			
			req.setAttribute("departureList", departureList);
			req.setAttribute("arrivalList", arrivalList);
			
			return "main/khx.tiles";
//			└> /Board/src/main/webapp/WEB-INF/views/main/khx.jsp 파일을 생성한다.
			
		} // end of public String index(HttpServletRequest req) ----
		

// ==== #yj1. 예매 페이지 요청. ====	

	@RequestMapping(value="/booking.action", method={RequestMethod.GET})
	
	public String booking(HttpServletRequest req)
	{
		
		String waytype = req.getParameter("waytype");
		String departure = req.getParameter("departure");
		String arrival = req.getParameter("arrival");
		String traintype = req.getParameter("traintype");
		String trainclass = req.getParameter("trainclass");
		String departuredate = req.getParameter("departuredate");
		String arrivaldate = req.getParameter("arrivaldate");
		
		
		System.out.println("waytype : " + waytype);	
		System.out.println("departure : " + departure);	
		System.out.println("arrival : " + arrival);	
		System.out.println("traintype : " + traintype);	
		System.out.println("trainclass : " + trainclass);	
		System.out.println("departuredate : " + departuredate);	
		System.out.println("arrivaldate : " + arrivaldate);	
		
		
		
		
		List<TrainviewVO> trainList = service.trainList();
		
		req.setAttribute("trainList", trainList);
		
		return "khx/booking.tiles";
//					└> /s2jo/src/main/webapp/WEB-INF/views/khx/booking.jsp 파일을 생성한다.
		
	} // end of public String index(HttpServletRequest req) ----

}
