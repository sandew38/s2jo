<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 구글맵 api 사용하기  --%>
<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyArfqZtHfB6pqo03pUFV2_5EvSuVTrg-fk"></script>


<script type="text/javascript"> 

	// 관광지 목록 보여주는 함수
	function goStationInfo(SIDO, GUGUN) {
	
		form_data = {SIDO : SIDO,
					GUGUN : GUGUN};
		
		$.ajax({ 
			url : "tourList.action", 	
			type : "POST",
			data : form_data,  
			dataType : "JSON",  // 응답은 JSON 타입으로 받아라.
			success: function(data) { // 데이터 전송이 성공적으로 이루어진 후 처리해줄 callback 함수
				// data 는 ajax 요청에 의해 url 페이지 tourList.action 으로 부터 리턴받은 데이터
		   		
			   $("#tourList").empty();
			   // <div id="tourList"> 엘리먼트를 모두 비워서 새로운 데이터를 받을수 있게 해라
			   
				
				var html = "";
				$.each(data, function(entryIndex, entry) {
					
					html += "<span style='font-size:12pt; font-weight: bold;'>";
					html += entry.SctnNm+"</span></br>"; 
					html += "<span style='font-size:18pt; font-weight: bold;'>";  
					html += "<a onClick='goTourInfo(&quot;"+entry.SIDO+"&quot;, &quot;"+entry.GUNGU+"&quot;, &quot;"+entry.RES_NM+"&quot;); return false'>";
					html += entry.RES_NM+"</a></span></br></br>"; 
		
				});
		
	   	   	   $("#tourList").html(html);   // html을  <div id="sidoInfo"> 에 넣어라
		
		}, // end of success: function(data) ---------------------
		
		error: function(request, status, error){
	        alert("에러 발생 code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
	    } // end of error: function(request,status,error)
			
		}); // end of $.ajax --------------------

	}
	
	
	
	// 관광지 상세정보 보여주는 함수
	function goTourInfo(SIDO, GUNGU, RES_NM) {
		
		form_data = {SIDO  : SIDO,
					GUGUN  : GUNGU,
					RES_NM : RES_NM};
		
		$.ajax({ 
			url : "tourDetail.action", 	
			type : "POST",
			data : form_data,  
			dataType : "JSON",  // 응답은 JSON 타입으로 받아라.
			success: function(data) { // 데이터 전송이 성공적으로 이루어진 후 처리해줄 callback 함수
				// data 는 ajax 요청에 의해 url 페이지 tourDetail.action 으로 부터 리턴받은 데이터
	
			   $("#tourDetail").empty();
			   // <div id="tourDetail"> 엘리먼트를 모두 비워서 새로운 데이터를 받을수 있게 해라
			   
		//		console.log(data.DGungu);
		//		console.log(data.x);
		//		console.log(data.y);
				
				var html = "";
	
					html += "<span style='font-size:12pt; font-weight: bold;'>";
					html +=  data.BResNm+" [ "+data.HEnglishNm+" ] ("+ data.KPhone +")</span></br></br>"; 
					html += "<span style='font-size:12pt; font-weight: bold;'>";
					html +=  data.Desc+"</span></br></br>"; 
				
	   	   	   $("#tourDetail").html(html);   // html을  <div id="sidoInfo"> 에 넣어라
				
	   	   	   var ResNm = data.BResNm;
	   	   	   var x = data.x; // string
	   	   	   var y = data.y;
	   	   
	   	   	   x = Number(x);
	   	   	   y = Number(y);
	   	   	   
	   	   	   alert(y +" , "+ x);
	
	     
	   	var myLatlng = new google.maps.LatLng(y, x);
	   	var mapOptions = {
	   	  zoom: 10,
	   	  center: myLatlng
	   	}
	   	var map = new google.maps.Map(document.getElementById("map"), mapOptions);

	   	var marker = new google.maps.Marker({
	   	    position: myLatlng,
	   	    title:"Hello World!"
	   	});

	   	// To add the marker to the map, call setMap();
	   	marker.setMap(map);
	   	  
	   	  
	   	  
		}, // end of success: function(data) ---------------------
		
		error: function(request, status, error){
	        alert("에러 발생 code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
	    } // end of error: function(request,status,error)
			
		}); // end of $.ajax --------------------

	}
	
	
<%-- 	

	$(document).ready(function(){
		google.maps.event.addDomListener(window, 'load', initialize);
		 
		function initialize(){
		    var mapOptions = { // 구글 맵 옵션 설정
		        zoom : 16, // 기본 확대율
		        center : new google.maps.LatLng(37.533868, 126.896763), // 지도 중앙 위치
		        disableDefaultUI : false,  // 기본 UI 비활성화 여부
		        scrollwheel : true,        // 마우스 휠로 확대, 축소 사용 여부
		        zoomControl : true,        // 지도의 확대/축소 수준을 변경하는 데 사용되는 "+"와 "-" 버튼을 표시
		        mapTypeControl : true,     // 지도 유형 컨트롤은 드롭다운이나 가로 버튼 막대 스타일로 제공되며, 사용자가 지도 유형(ROADMAP, SATELLITE, HYBRID 또는 TERRAIN)을 선택할 수 있다. 이 컨트롤은 기본적으로 지도의 왼쪽 위 모서리에 나타난다.
		        streetViewControl : true,  // 스트리트 뷰 컨트롤에는 지도로 드래그해서 스트리트 뷰를 활성화할 수 있는 펙맨 아이콘이 있다. 기본적으로 이 컨트롤은 지도의 오른쪽 아래 근처에 나타난다.
		        scaleControl: true,        // 배율 컨트롤은 지도 배율 요소를 표시한다. 이 컨트롤은 기본적으로 비활성화되어 있다.
		    };
		    // 구글맵 옵션내역 사이트 아래 참조 
		    // https://developers.google.com/maps/documentation/javascript/reference#MapOptions
		 
		    var map = new google.maps.Map(document.getElementById('googleMap'), mapOptions);  // 구글 맵을 사용할 타겟
		    
		    google.maps.event.addDomListener(window, "resize", function() {
		        var center = map.getCenter();
		        google.maps.event.trigger(map, "resize");
		        map.setCenter(center); 
		    });
	
		    
			var storeArr = [
				<c:set var="cnt" value="1" />
				<c:forEach var="store" items="${mapList}" varStatus="status">					
				     [
				    	"${store.storeName}",
				    	"${store.latitude}",
				    	"${store.longitude}",
				    	"${store.zindex}"
					 ]
				     <c:if test="${cnt != mapList.size()}">
				     ,
				     </c:if>
				     
				     <c:set var="cnt" value="${cnt + 1}" />   // 변수 cnt 를 1씩 증가  
				</c:forEach>
			];
			
		    setMarkers(map, storeArr);
		    
		} // end of function initialize()--------------------------------
		 
		
		var markerArr;  // 전역변수로 사용됨.
		
		function setMarkers(map, storeArr){
		    
			markerArr = new Array(storeArr.length);
			
			for(var i=0; i < storeArr.length; i++){
				
				if(i == 0) {
					var image = "<%= request.getContextPath() %>/resources/images/pointerBlue.png";  // 1번 마커 이미지	
				} 
				else if(i == 1) {
					var image = "<%= request.getContextPath() %>/resources/images/pointerPink.png"; // 2번 마커 이미지
				}
				else {
					var image = "<%= request.getContextPath() %>/resources/images/pointerBlue.png"; // 3번 마커 이미지
				}
				
				var store = storeArr[i];
			//  alert(store[0]);
				
				var myLatLng = new google.maps.LatLng(Number(store[1]), Number(store[2]));  
				// Number() 함수를 꼭 사용해야 함을 잊지 말자. 
				
				markerArr[i] = new google.maps.Marker({   // 마커 설정하기
					position: myLatLng,  // 마커 위치
					map: map,
					icon : image,        // 마커 이미지
					title : store[0],    // 위에서 정의한 "${store.storeName}" 임
					zIndex : Number(store[3])  // Number() 함수를 꼭 사용해야 함을 잊지 말자.
				});
				
				markerListener(map, markerArr[i]);
				
			} // end of for------------------------------	
			
		}// end of setMarkers(map, locations)--------------------------
	 
		
	
		}); // end of $(document).ready()-------------------------
	
	
 --%>
</script>


<!-- 현재 운행중인 역 목록 div -->
<div style="background-color: white; float:left; width:20%; margin: 0 auto; margin-left: 5%; margin-bottom: 40px; border: solid red 1px; ">

	<div align="center" style="width:90%; margin: 0 auto; margin-bottom: 40px; /* border: solid red 1px; */">
		<h2>현재 운행중인 역목록</h2>
	</div>

	<!-- 역 선택해서 관광지 목록 조회하기 -->
	<div align="center" style="width:90%; margin: 0 auto; margin-bottom: 50px;  border: solid red 1px; ">			
		<c:forEach var="map" items="${stationList}">
			<button type="button" onClick="goStationInfo('${map.SIDO}', '${map.GUGUN}');" style="font-size: 20pt; margin-bottom:10px;">${map.STATION}</button><br/>
			
			<!-- 아래 부분은 삭제 가능 -->
			<input type="hidden" name="LINETYPE"  value="${map.LINETYPE}" />
		</c:forEach>
	</div>
	
	
	<div align="center" style="width:90%; margin: 0 auto; margin-bottom: 40px; /* border: solid red 1px; */">
		<h2>주소를 입력하세요</h2>
	</div>
	
	<!-- 주소 검색해서 관광지 목록 조회하기 ==> 시/도, 구/군 까지 주소검색하는 검색창 필요 -->
	<div align="center" style="width:90%; margin: 0 auto;  border: solid red 1px; margin-bottom: 50px;">			
		<h3>주소검색창 들어갈 예정</h3>
	</div>
</div>



<!-- 역 주변 관광지 목록 div -->
<div style="background-color: white; float:left; width:40%; margin: 0 auto; margin-bottom: 40px; border: solid green 1px; ">

	<div align="center" style="width:90%; margin: 0 auto; margin-bottom: 40px; /* border: solid red 1px; */">
		<h2>역 주변 관광지 목록</h2>
	</div>
	
	<div id="tourList"align="center" style="width:90%; margin: 0 auto; margin-bottom: 40px;  border: solid green 1px; ">
		<h2>관광지 목록</h2>
	</div>
	
</div>



<!-- 관광지 상세정보 div -->
<div style="background-color: white; float:left; width:30%; margin: 0 auto; margin-bottom: 40px; border: solid orange 1px; ">

	<div align="center" style="width:90%; margin: 0 auto; margin-bottom: 40px; /* border: solid red 1px; */">
		<h2>관광지 상세정보</h2>
	</div>
	
	<div id="tourDetail"align="center" style="width:90%; margin: 0 auto; margin-bottom: 40px;  border: solid orange 1px; ">
		<h2>지도 및 관광지 정보</h2>
	</div>
	
	<div id="map"	style="width: 100%; height: 360px; border: solid black 1px; margin: auto;">
	
	</div>
</div>