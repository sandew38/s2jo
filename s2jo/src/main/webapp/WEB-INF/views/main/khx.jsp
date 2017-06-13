<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">

#oneway, #roundway
{
	border : 2px solid #639EB0;
	font-size: large;
	text-align: center;
	height: 100px;
	padding-top : 20px;
	border-radius: 20px;
	font-weight: bold;
	font-size: 25pt;
	margin: 1%; 
	width : 96%;
}


.left, .right
{
	width : 96%;
	border: 2px solid #639EB0;
	height: 100px;
	vertical-align: middle;
	padding-top : 20px;
	border-radius: 20px;
	margin: 1%; 
}

#leftside, #rightside
{
	border : 0px solid #639EB0;
	float: left;
	width : 50%;
	text-align: center;
	height: 100%;
	vertical-align: middle;
}

.floatleft
{
	float: left;
	text-align: center;
}

.deselected {

	color: #cccccc;
    background: gray; /* For browsers that do not support gradients */    
    background: -webkit-linear-gradient(left, white , #cccccc); /* For Safari 5.1 to 6.0 */
    background: -o-linear-gradient(right, white, #cccccc); /* For Opera 11.1 to 12.0 */
    background: -moz-linear-gradient(right, white, #cccccc); /* For Firefox 3.6 to 15 */
    background: linear-gradient(to right, white , #cccccc); /* Standard syntax (must be last) */
   
}

.departure, .singledeparture, .doubledeparture, .arrival, .departuredate, .traintype, .trainclass
{
	cursor: pointer;
}

</style>


<script type="text/javascript">

$(document).ready(function(){

// 페이지 로드 시 
	$(".oneway").hide();	//
	$(".roundway_selected").hide();
	$("#roundway").addClass("deselected");
	$("#waytype").val("oneway");

	$(".doubledeparture").hide();
	$(".singledeparture").show();
	
}); // end of $(document).ready(function() ----

		
function goBooking() 
{
	location.href="booking.action";
}

// 편도 선택시
function oneway(event)
{
	onewayOn();
	roundwayOff();
	$("#waytype").val("oneway");
	
	$(".doubledeparture").hide();
	$(".singledeparture").show();

}

//왕복 선택시
function roundway(event)
{
	roundwayOn();
	onewayOff();	
	$("#waytype").val("roundway");
	
	$(".singledeparture").hide();
	$(".doubledeparture").show();
}


// 편도 on
function onewayOn()
{
	$(".oneway").hide();
	$(".oneway_selected").show();	
	$("#oneway").removeClass("deselected");

}
// 편도 off
function onewayOff()
{
	$(".oneway_selected").hide();	
	$("#oneway").addClass("deselected");
	$(".oneway").show();
}
// 왕복 on
function roundwayOn()
{
	$(".roundway").hide();
	$(".roundway_selected").show();	
	$("#roundway").removeClass("deselected");
}
// 편도 off
function roundwayOff()
{
	$(".roundway_selected").hide();	
	$("#roundway").addClass("deselected");
	$(".roundway").show();
}



</script>

<!-- content 전체 div -->
<div align="center" style="border: solid gold 3px; min-height: 800px; ">
	<div align="center" style="width:90%; margin: 0 auto; margin-top: 5%; margin-bottom: 40px;">
		<h2>즐거운 여행의 시작과 끝, KHX와 함께!</h2>

	</div>
	
	<div style="width:60%; margin: 0 auto; border: solid #639EB0 0px; min-height: 400px; " align="center">
		<div id="leftside" align="center"  >
			<div id = "oneway" align="center" style="cursor: pointer; " onclick="oneway();">
					 
				
					 
				 <span class = "oneway" >
				 
					 <img src = "<%=request.getContextPath()%>/resources/images/oneway.png"
						alt="편도" style="width: 20%; ">
						
					 <span style="color : #cccccc;"> &#xB;&#xB;&#xB; 편도  </span>		
					 
				 </span>
										
				 <span class = "oneway_selected">

					<img src = "<%=request.getContextPath()%>/resources/images/oneway_selected.png"
						alt="편도선택" style="width: 20%; cursor: pointer;">
						
					<span style="color : #639EB0;">  &#xB;&#xB;&#xB; 편도 </span>
					
				 </span>
					
			</div>
			<div style="clear: both; margin-bottom : 3%; width : 96%;">
				<div class="floatleft left departure" style="width:48%;" id = "choosedeparture">
				출발지 선택
				
					
				</div>
				<div class="floatleft left arrival" style="width:48%; margin-left: 2%; margin-right: 0%;">도착지 선택</div>
			</div>
			<div style="clear: both; " class = "left traintype">기차선택</div>
			<div style="clear: both; margin-top: 2%;" class = "left trainclass">등급선택</div>
		</div>
		
		<div id="rightside" >
			<div id = "roundway" align="center" style="cursor: pointer;" onclick="roundway();">
			
				 <span class = "roundway" >
				 
				 	<img src = "<%=request.getContextPath()%>/resources/images/roundway.png"
						alt="왕복" style="width: 20%; ">
						
					<span style="color : #cccccc;">  &#xB;&#xB;&#xB; 왕복 </span>
					
				 </span>
										
				 <span class = "roundway_selected">
				 
				 	<img src = "<%=request.getContextPath()%>/resources/images/roundway_selected.png"
						alt="왕복선택" style="width: 20%; cursor: pointer;">
				
					<span style="color : #639EB0;"> &#xB;&#xB;&#xB; 왕복 </span>		
					
				 </span>
					
			</div>
			
			
		<div style="clear: both; width:96%; margin: 2%; margin-bottom: 1%; " class = "right singledeparture" >
			<div style="float: left; width: 100%"  class = "departuredate singledeparture">
				가는 날 
			</div>
		</div>
		
		<div style="clear: both; height: 100px; margin: 1%;  margin-bottom: 3%;" class = "doubledeparture" >
			<div style="float: left; width:48%;" class = "right departuredate doubledeparture">
				가는 날 
			</div>
		
			<div style="float: left; width:48%;" class = "right departuredate doubledeparture">
				오는 날 
			</div>
		</div>
			
			<div id="browse" class="browse right" style="height: 200px; margin-top : 2%; padding-top: 70px; cursor: pointer; background-color: #639EB0;" onclick="goBooking();">
				<span style="height: 90%; width: 90%; margin: 1%; color: white; font-weight: bold; font-size: xx-large;"> 조회하기 </span>
	  		</div>
		</div>
		
	</div>

<form id = "browseForm">
	userid : <input type ="text" id = "userid" name = "userid">
	<br/><br/> 
	waytype : <input type="text" id ="waytype" name = "waytype">
</form>
    
</div>










