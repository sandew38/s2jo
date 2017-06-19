package com.s2jo.khx.hjs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
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
	
	
	// ===== 관광지 Api 다루는 클래스 의존객체 주입하기(DI: Dependency Injection) =====
	@Autowired
	private ApiExplorer apiExplorer;
	
	
	
	// ==== #js1. 기차역정보 메인 페이지 요청 ====
	@RequestMapping(value="/hjs/stationInfo.action", method={RequestMethod.GET})
	
	public String main(HttpServletRequest req){
		
		List<String> stationList = service.getStationList();
    	
    	req.setAttribute("stationList", stationList);
		
		return "hjs/stationInfo.tiles";
		// /s2jo/src/main/webapp/WEB-INF/views/hjs/stationInfo.jsp 파일을 생성한다
		
	}// end of public String main(HttpServletRequest req) ----------------
	
	
	
	// >>> Ajax
	// ==== #js2. 기차역(시/도)별 관광정보 리스트 요청 ====
	@RequestMapping(value="/hjs/tourList.action", method={RequestMethod.POST})
	@ResponseBody
	
	public ArrayList<HashMap<String, String>> tourList(HttpServletRequest req) throws Exception{
		
		String SIDO = req.getParameter("SIDO");   // form_data 
		String GUGUN = req.getParameter("GUGUN"); 
		
		ArrayList<HashMap<String, String>> list = apiExplorer.tourList(SIDO, GUGUN); // 시/도, 군/구 별 관광지 목록 정보 담은 list
		
		return list;		
	}// end of public String main(HttpServletRequest req) ----------------

	
	
	// >>> Ajax
	// ==== #js3. 관광지별 상세 관광정보 요청 ====
	@RequestMapping(value="/hjs/tourDetail.action", method={RequestMethod.POST})
	@ResponseBody
	
	public HashMap<String, String> tourDetail(HttpServletRequest req) throws Exception{
		
		String SIDO = req.getParameter("SIDO");   // form_data 
		String GUGUN = req.getParameter("GUGUN"); 
		String RES_NM = req.getParameter("RES_NM"); 

		HashMap<String, String> map = apiExplorer.tourDetail(SIDO, GUGUN, RES_NM); // 관광지상세 정보 담은 list
		
		return map;		
	}// end of public String main(HttpServletRequest req) ----------------
	
	
}
