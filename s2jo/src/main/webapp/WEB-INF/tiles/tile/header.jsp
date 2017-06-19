<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- ===== #37.  tiles 중 header 페이지 만들기  ===== --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">


</style>




<div align="right" style="text-align: right; color: white;">
   <span style="text-align: right; height: 100px;">
		<!-- ==== #1.비회원 로그인하지 않았을 때 아래 메뉴 출력하기. -->
			<c:if test="${sessionScope.nonloginuser == null && sessionScope.loginuser == null}">
			  <a href="<%=request.getContextPath()%>/nonloginform.action" style="color: white;	font-size: medium;">비회원로그인 |</a>
			  <a href="<%=request.getContextPath()%>/loginform.action" style="color: white;	font-size: medium;">로그인 |</a>
			  <a style="color: white;	font-size: medium;">회원가입 |</a>
		  	</c:if>

		<!-- ===== #2.비회원 로그인 성공 시 사용자 성명 출력하기. ===== -->
		  <c:if test="${sessionScope.nonloginuser != null}" >
			  	<span style="color: white; font-size: medium; font-weight: bold;">${sessionScope.nonloginuser.nhp} 님 |</span> 
			  	<a href="<%=request.getContextPath()%>/nonlogout.action">
			  	<span style="color: white; font-size: medium; font-weight: bold;">로그아웃 |</span> 
			  	</a>
					  
		  </c:if>
		<!-- ===== #2.정회원 로그인 성공 시 사용자 성명 출력하기. ===== -->
		  <c:if test="${sessionScope.loginuser != null }">
			  	<span style="color: white; font-size: medium; font-weight: bold;">${sessionScope.loginuser.name} 님 |</span> 
			  	<a href="<%=request.getContextPath()%>/logout.action">
			  	<span style="color: white; font-size: medium; font-weight: bold;">로그아웃 |</span> 
			  	</a>
		  </c:if>  
				
		  <!-- #3. 항상고정 출력-->
		 	  <a style="color: white;	font-size: medium;">마이페이지 |</a> 
		 	  <a style="color: white;	font-size: medium;">결제내역조회 |</a> 
		 	  <a style="color: white;	font-size: medium;">사이트맵</a>
		 	  

   </span>
</div>

