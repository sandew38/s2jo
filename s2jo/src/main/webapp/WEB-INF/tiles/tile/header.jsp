<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- ===== #37.  tiles 중 header 페이지 만들기  ===== --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">



</style>



<%-- 로그인 하지않은 상태의 header --%>
<div align="right" style="text-align: right; color: white;">
   <ul class="nav nav-tabs mynav" style="text-align: right; height: 100px;">
 	  <a href="<%=request.getContextPath()%>/nonloginform.action" style="color: white;">비회원로그인</a> |
 	  <a style="color: white;">로그인</a> |
 	  <a style="color: white;">회원가입</a> |
 	  <a style="color: white;">마이페이지</a> |
 	  <a style="color: white;">결제내역조회</a> |
 	  <a style="color: white;">사이트맵</a>

<!-- ===== #52. 로그인 성공한 사용자 성명 출력하기. ===== -->
      <c:if test="${sessionScope.nonloginuser != null}">
	      <li style="margin-left: 45%; margin-top: 1%;">
	      ::: 환영합니다~ <span style="color: navy; font-weight: bold;">${sessionScope.nonloginuser.name}</span> 님  :::
	      </li>
      </c:if>
   </ul>
</div>


<%-- <div align="right">
	<ul class="nav nav-tabs mynav">
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#">Home <span class="caret"></span></a>
			<ul class="dropdown-menu">
				<li><a href="<%=request.getContextPath()%>/index.action">홈</a></li>
				<li><a href="#">Submenu 1-2</a></li>
				<li><a href="#">Submenu 1-3</a></li>
			</ul></li>
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#">게시판 <span class="caret"></span></a>
			<ul class="dropdown-menu">
				<li><a href="<%=request.getContextPath()%>/list.action">목록보기</a></li>
				<li><a href="<%=request.getContextPath()%>/add.action">글쓰기</a></li>
				<li><a href="#">Submenu 1-3</a></li>
			</ul></li>
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#">로그인 <span class="caret"></span></a>
			<ul class="dropdown-menu">
				<c:if test="${sessionScope.loginuser == null}">
				<li><a href="#">회원가입</a></li>
				<li><a href="<%=request.getContextPath()%>/login.action">로그인</a></li>
				<li><a href="<%=request.getContextPath()%>/naverlogin.action">네아로그인</a></li>
				</c:if>
				 
				<c:if test="${sessionScope.loginuser != null}">
				<li><a href="<%=request.getContextPath()%>/logout.action">로그아웃</a></li>
				</c:if>
			</ul></li>
		<li><a href="#">Menu 3</a></li>
		
		<!-- ===== #52. 로그인 성공한 사용자 성명 출력하기. ===== -->
		<c:if test="${sessionScope.loginuser != null}">
		<li style="margin-left: 45%; margin-top: 1%;">
		::: 환영합니다~ <span style="color: navy; font-weight: bold;">${sessionScope.loginuser.name}</span> 님  :::
		</li>
		</c:if>
	</ul>
</div>
 --%>