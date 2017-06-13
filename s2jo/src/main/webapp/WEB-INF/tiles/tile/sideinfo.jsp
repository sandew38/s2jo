<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- ===== #38.  tiles 중 sideinfo 페이지 만들기 ===== --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
	${demo.css}
	
	li 
	{
		padding-bottom: 8%;
		font-size: large;
	}
</style>

<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/highcharts.js"></script>        <!-- 차트그리기 --> 
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/modules/data.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/modules/drilldown.js"></script>

<script type="text/javascript">

	$(document).ready(function() {
		loopshowNowTime();
//		showRank();
	}); // end of ready(); ---------------------------------

	function showNowTime() {
		
		var now = new Date();
	
		var strNow = now.getFullYear() + "-" + (now.getMonth() + 1) + "-" + now.getDate();
		
		var hour = "";
		if(now.getHours() > 12) {
			hour = " 오후 " + (now.getHours() - 12);
		} else if(now.getHours() < 12) {
			hour = " 오전 " + now.getHours();
		} else {
			hour = " 정오 " + now.getHours();
		}
		
		var minute = "";
		if(now.getMinutes() < 10) {
			minute = "0"+now.getMinutes();
		} else {
			minute = ""+now.getMinutes();
		}
		
		var second = "";
		if(now.getSeconds() < 10) {
			second = "0"+now.getSeconds();
		} else {
			second = ""+now.getSeconds();
		}
		
		strNow += hour + ":" + minute + ":" + second;
		
		$("#clock").html("<span style='color:green; font-weight:bold;'>"+strNow+"</span>");
	
	}// end of function showNowTime() -----------------------------


	function loopshowNowTime() {
		showNowTime();
		
		var timejugi = 1000;   // 시간을 1초 마다 자동 갱신하려고.
		
		setTimeout(function() {
						loopshowNowTime();	
					}, timejugi);
		
	}// end of loopshowNowTime() --------------------------
	
</script>

<div id = "outer" style=" margin-top: 56px;">
	<div id = "logo" align="center" style="margin-top: 10%; margin-bottom: 10%;">
		<img alt="khxlogo"
			 src="<%=request.getContextPath()%>/resources/images/khxlogo.png"
			 style="width: 35%;">
			 <h4 style="font-weight: bold;">KHX 통합 예매</h4>
	</div>
	<div align="center" >
		<ul style="list-style: none; margin-top: 30%; padding-bottom: 30%;" >
			<li>기차예매</li>
			<li><a href="<%=request.getContextPath()%>/lsk/bookingcheck.action">예매확인</a></li>
			<li>운행정보</li>
			<li>이용안내</li>
			<li><a href="<%=request.getContextPath()%>/hjs/stationInfo.action">기차역정보</a></li>
			<li>고객센터</li>
		</ul>
	</div>
	<div style="margin: 0 auto;" align="center">
		현재시각 :&nbsp; 
		<div id="clock" style="display:inline;"></div>
	</div>
	<%-- <div id="displayRank" style="min-width: 90%; margin: 0 auto;  margin-top: 20px; margin-bottom: 70px; padding-left: 10px; padding-right: 10px;"></div>
	<div id="chart-container" style="min-width: 90%; min-height: 400px; margin: 0 auto; border: solid #F0FFFF 5px;"></div>
	 --%>	
	
</div>
	
	