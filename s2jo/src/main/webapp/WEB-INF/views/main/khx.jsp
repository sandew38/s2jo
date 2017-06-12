<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">

function goBooking() 
{
	location.href="booking.action";
}

</script>

<div align="center" style="/* border: solid red 1px; */">
	<div align="center" style="width:90%; margin: 0 auto; margin-bottom: 40px; /* border: solid red 1px; */">
		<h2>KHX와 함께 여행을 계획하세요!</h2>
		여기 고침.
	</div>
	
	<div style="width:100%; margin: 0 auto; /* border: solid red 1px; */">
		<div id="background" class="">
			<button type="button" 
				style="height: 200px; width: 500px;" 
				class="btn btn-warning"
				onclick="goBooking();"> <h1>예매하러 가기</h1> </button>
	  	</div>
	</div>
    
</div>