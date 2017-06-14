<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<script type="text/javascript">



	function stationInfo(SIDO) {
		
		form_data = {SIDO : SIDO};
		
		alert(form_data);
		
		$.ajax({ 
			url : "sidoInfo.action", 	
			type : "POST",
			data : form_data,  
			dataType : "JSON",  // 응답은 JSON 타입으로 받아라.
			success: function(data) { // 데이터 전송이 성공적으로 이루어진 후 처리해줄 callback 함수
					// data 는 ajax 요청에 의해 url 페이지 sidoInfo.action 으로 부터 리턴받은 데이터
			   			   
				   $("#sidoInfo").empty();
				   // <div id="sidoInfo"> 엘리먼트를 모두 비워서 새로운 데이터를 받을수 있게 해라
				   
				   var html = "";
				   html += "<img src=\"/board/resources/files/"+data.IMGFILENAME+"\" "+"width='460' height='345' />";    
			   
		   	   	   $("#sidoInfo").html(html);   // html을  <div id="sidoInfo"> 에 넣어라
			
			}, // end of success: function(data) ---------------------
			
			error: function(request, status, error){
		        alert("에러 발생 code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
		    } // end of error: function(request,status,error)
			
		}); // end of $.ajax --------------------
	}



</script>
<%-- 
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/mdl/material.min.css">
<script src="<%= request.getContextPath() %>/resources/mdl/material.min.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">


<!-- <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script> -->

<style>
.demo-card-wide.mdl-card {
  width: 512px;
}
.demo-card-wide > .mdl-card__title {
  color: #fff;
  height: 176px;
  background: url('<%= request.getContextPath() %>/resources/images/choochoo.jpg') center / cover;
}
.demo-card-wide > .mdl-card__menu {
  color: #fff;
}
</style>
 
<div class="container">
<div style="position: relative; margin-bottom:10%">
<iframe width="800" height="500" src="https://www.youtube.com/embed/3n8106brsg4?&amp;autoplay=1&amp;loop=1 frameborder="" frameborder="0" allowfullscreen></iframe>
</div>

기차역정보

<!-- Wide card with share menu button -->


<div class="demo-card-wide mdl-card mdl-shadow--2dp">
  <div class="mdl-card__title">
    <h2 class="mdl-card__title-text">choo-choo</h2>
  </div>
  <div class="mdl-card__supporting-text">
    
	ajsklajflskjfkaj;flkasj
	aslkfjalksfjalksjflka
	alskdfjaslkfjkalsjdfkl
	asldfjaslkdfjls
  </div>
  <div class="mdl-card__actions mdl-card--border">
    <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
     	버튼 
    </a>
  </div>
  <div class="mdl-card__menu">
    <button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
      <i class="material-icons">share</i>
    </button>
  </div>
</div>


</div> 
--%>


<%--
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/mdl/material.min.css">
<script src="<%= request.getContextPath() %>/resources/mdl/material.min.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">


<div align="center" style="dispaly:block; border: solid red 1px;">
KTX 경부선

<p>
	<img style="width: 70%; height: 70%;" src="<%= request.getContextPath() %>/resources/images/map3.png">
</p>	


<ul>
<li>
	<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored">
	 		<i class="material-icons">mood</i>
		</button>
</li>
<li>
	<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored">
	 		<i class="material-icons">mood</i>
		</button>
</li>
<li>
	<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored">
	 		<i class="material-icons">mood</i>
		</button>
</li>
<li>
	<button class="mdl-button mdl-js-button mdl-button--icon mdl-button--colored">
	 		<i class="material-icons">mood</i>
		</button>
</li>

</ul>


</div>



<img src="<%= request.getContextPath() %>/resources/images/map3.png" width="403" height="400" alt="지도" usemap="#menuMap" /> 

<map name="menuMap" id="menuMap"> 
     <area  shape="rect"  coords="11,13,56,24"  alt="첫화면"  title="Home"  target="_blank"  href="http://tonks.tistory.com/" /> 
     <area  shape="rect"  coords="85,11,114,29"   alt="태그 목록"     title="Tag"            target="_blank"  href="../tag" /> 
     <area  shape="rect"  coords="148,11,204,24"  alt="미디어 로그"  title="Media"        target="_blank"  href="../media" /> 
     <area  shape="rect"  coords="236,12,307,24"  alt="위치 로그"     title="Location"     target="_blank"  href="../location" /> 
     <area  shape="rect"  coords="338,12,390,30"  alt="방명록"         title="Guestbook"  target="_blank"  href="../guestbook" /> 
</map> 

--%>

<div align="center" style=" border: solid red 1px; ">
ㅁㄴㅇㄻㄴㄹㄴㅁ

	<div id="sidoInfo" align="center" style="border: green solid 0px; width: 45%; padding: 2%; margin: 2% auto;">
		DFDFDFDFDFDFD
	</div>  
	
	<div style="width:90%; margin: 0 auto; /* border: solid red 1px; */">

	버튼에 주소 집어넣기
  
   <div style="border: solid orange 1px" class="col-sm-3">
  <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo1" style="margin-bottom:20px;">KTX 경부선</button>
  <div id="demo1" class="collapse">

	<button type="button" class="btn" style="margin-bottom: 10px;" onClick="stationInfo('서울특별시');" >서울</button> <br/>
	<button type="button" class="btn" style="margin-bottom: 10px;" >광명</button> <br/>
	<button type="button" class="btn" style="margin-bottom: 10px;" >대전</button> <br/>
	<button type="button" class="btn" style="margin-bottom: 10px;" >동대구</button>

  </div>
  </div>
  
  <div style="border: solid black 1px" class="col-sm-3">
    <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo2" style="margin-bottom:20px;">KTX 호남선</button>
  <div id="demo2" class="collapse">

	<button type="button" class="btn" style="margin-bottom: 10px;">행신</button> <br/>
	<button type="button" class="btn" style="margin-bottom: 10px;" >용산</button> <br/>
	<button type="button" class="btn" style="margin-bottom: 10px;" >광명</button> <br/>
	<button type="button" class="btn" style="margin-bottom: 10px;" >서대전</button>

  </div>

	</div>
	
</div>
  </div>  
