package com.s2jo.khx.hjs;

import java.util.ArrayList;
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

import com.s2jo.khx.service.hjs.HjsService;

//==== 컨트롤러 선언 ====

@Controller
@Component
//XML에서 bean을 만드는 대신에
//클래스명 앞에 @Component 어노테이션을 쓰면
//해당 클래스는 bean으로 자동 등록된다.
//그리고 bean의 id는 해당 클래스명이 된다. (첫 글자는 소문자)

public class HjsController {

// ==== 의존객체 주입하기 (DI : Dependency Injection) ====	
	
	@Autowired
	private HjsService service;
	
	
	// ==== #js1. 기차역정보 메인 페이지 요청 ====
	@RequestMapping(value="/hjs/stationInfo.action", method={RequestMethod.GET})
	
	public String main(HttpServletRequest req){
		
		return "hjs/stationInfo.tiles";
		// /s2jo/src/main/webapp/WEB-INF/views/hjs/stationInfo.jsp 파일을 생성한다
		
	}// end of public String main(HttpServletRequest req) ----------------
	
	
	
}
