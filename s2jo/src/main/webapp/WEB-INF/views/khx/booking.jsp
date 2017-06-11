<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<style type="text/css">

table tr td
{
	border: 0px gold solid;
	text-align: center;
	padding : 3px;
}


</style>
    
    
<div style="width: 100%; height: 90%; " align="center">
	<div id = "outer" style="width: 80%; height: 90%; border: 0px #1CE3A9 solid; " align="center">
		<h3 style="font-weight: bold;">배차조회</h3>
		
		<div id = "infobox" style="float: left; border: 0px #1CE3A9 solid; width: 35%; height: 98%;" >
		
			<div style="height: 10%; border: 0px green solid;">
				조회한 날짜
			</div>
			
			<div style="height : 40%; border: 0px dashed pink;">
				출발지 : <br/>
				도착지 : <br/>
				소요시간 : <br/>
			</div>
			
			<div style="height : 50%;">
			
			</div>
		</div>
		
		<div id = "detailbox" style="float: left; border: 1px #1CE3A9 solid; width: 65%; height: 98%;">
			<div style="height: 20%; border-bottom : 1px #1CE3A9 solid;">
				<div align="left">
					<img src="<%=request.getContextPath()%>/resources/images/btn_refresh.png"
								 style="width: 10%; padding: 2%; cursor: pointer;">
				</div>
				
				<div>
					<h4>조회한 날짜</h4>
				</div>
			</div>
			<div style="max-height: 500px; padding-top:2%; overflow-y: auto; " align="left">
				<table style="width: 100%; text-align: center; " >
					<tr style="border-bottom: 1px #1CE3A9 solid;">
						<th style="text-align: center;">분류</th>
						<th style="text-align: center;">열차번호</th>
						<th style="text-align: center;">출발지</th>
						<th style="text-align: center;">출발시각</th>
						<th style="text-align: center;">도착지</th>
						<th style="text-align: center;">도착시각</th>
						<th style="text-align: center;">운임</th>
					</tr>
					
					<c:if test="${not empty trainList}">
						<c:forEach items="${trainList}" var="train">
							<tr>
								<td>
									${train.traintype }
								</td>
								<td>
									${train.trainno}
								</td>
								<td>
									${train.departure}
								</td>
								<td>
									${train.departuretime.substring(0,2)} : ${train.departuretime.substring(2,4)}
								</td>
								<td>
									${train.arrival}
								</td>
								<td>
									${train.arrivaltime.substring(0,2)} : ${train.arrivaltime.substring(2,4)}
								</td>
								<td >	
									<fmt:formatNumber pattern="###,###">
										${train.rate}
									</fmt:formatNumber> 원					
								</td>
							</li>						
						</c:forEach>
					</c:if>
					
				</table>		
			</div>
		</div>
	</div>    
</div>