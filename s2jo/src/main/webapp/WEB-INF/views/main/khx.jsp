<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">

#oneway, #roundway
{
	border : 1px solid red;
	font-size: large;
	text-align: center;
	height: 100px;
	vertical-align: middle;
}

.left, .right
{
	width : 100%;
	border: 1px solid pink;
	height: 100px;
	vertical-align: middle;
}

#leftside, #rightside
{
	border : 1px solid red;
	float: left;
	width : 50%;
	text-align: center;
	height: 100%;
	/* padding: 5%; */
}

.floatleft
{
	float: left;
	text-align: center;
}

</style>

<script type="text/javascript">

function goBooking() 
{
	location.href="booking.action";
}

</script>

<!-- content 전체 div -->
<div align="center" style="border: solid gold 3px; min-height: 800px; ">
	<div align="center" style="width:90%; margin: 0 auto; margin-top: 5%; margin-bottom: 40px; /* border: solid red 1px; */">
		<h2>즐거운 여행의 시작과 끝, KHX와 함께!</h2>

	</div>
	
	<div style="width:80%; margin: 0 auto; border: solid blue 2px; min-height: 400px; " align="center">
		<div id="leftside" align="center" >
			<div id = "oneway" align="center">
				[편도 아이콘] 편도 [체크아이콘]
			</div>
			<div style="clear: both;">
				<div class="floatleft left" style="width:50%;">출발지<br/>선택</div>
				<div class="floatleft left" style="width:50%;">도착지<br/>선택</div>
			</div>
			<div style="clear: both;" class = "left">기차선택</div>
			<div style="clear: both;" class = "left">등급선택</div>
		</div>
		
		<div id="rightside" >
			<div id = "roundway">
				[왕복 아이콘] 왕복 [체크아이콘]
			</div>
			<div style="clear: both;" class = "right">
				출발하는날 
			</div>
			
			<div id="browse" class="browse" style="height: 200px;">
				<button type="button" 
					style="height: 95%; width: 95%;" 
					class="btn btn-warning"
					onclick="goBooking();"> 조회하기 </button>
	  		</div>
		</div>
		

		
		
		
	</div>
    
</div>