<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
   
<style type="text/css">
	table, th, td, input, textarea {border: solid gray 1px;}
	
	#table, #table2 {border-collapse: collapse;
	 		         width: 600px;
	 		        }
	#table th, #table td{padding: 5px;}
	#table th{width: 120px; background-color: #DDDDDD;}
	#table td{width: 480px;}
	.long {width: 470px;}
	.short {width: 120px;} 	
	
	a{text-decoration: none;}	

</style>

<script type="text/javascript">
    
    function goWrite(){
    	var addWriteFrm = document.addWriteFrm;
    	addWriteFrm.submit();
    }
    
</script>

<div style="padding-left: 10%; border: solid 0px red;">
	<h1>글내용보기</h1>
	
	<table id="table">
		<tr>
			<th>글번호</th>
			<td>${boardvo.seq}</td>
		</tr>
		<tr>
			<th>성명</th>
			<td>${boardvo.name}</td>
		</tr>
		<tr>
           	<th>제목</th>
           	<td>${boardvo.subject}</td>
        	</tr>
		<tr>
			<th>내용</th>
			<td>${boardvo.content}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${boardvo.readCount}</td>
		</tr>
		<tr>
			<th>날짜</th>
			<td>${boardvo.regDate}</td>
		</tr>
		
		<!-- ===== #144. 첨부파일 이름 및 파일크기를 보여주고 첨부파일을 다운받게끔 만들기 ===== -->
		<tr>
			<th>첨부파일</th>
			<td>
			   <a href="<%= request.getContextPath() %>/download.action?seq=${boardvo.seq}"> 
				${boardvo.orgFilename}
			   </a>	
			</td>
		</tr>
		
		<tr>
			<th>파일크기(bytes)</th>
			<td>${boardvo.fileSize}</td>
		</tr>
		
	</table>
	
	<br/>
	<button type="button" onClick="javascript:location.href='<%= request.getContextPath() %>/list.action'">목록보기</button>
	<button type="button" onClick="javascript:location.href='<%= request.getContextPath() %>/edit.action?seq=${boardvo.seq}'">수정</button>
	<button type="button" onClick="javascript:location.href='<%= request.getContextPath() %>/del.action?seq=${boardvo.seq}'">삭제</button>
		
		
	<br/>
	<br/>
	
	<!-- ===== #118. 답변글쓰기 버튼 추가하기(현재 보고 있는 글이 작성하려는 답변글의 원글(부모글)이 된다.) ===== -->
	<button type="button" onClick="javascript:location.href='<%= request.getContextPath() %>/add.action?fk_seq=${boardvo.seq}&groupno=${boardvo.groupno}&depthno=${boardvo.depthno}'">답변글쓰기</button> 
	<br/>
	
	<!-- ===== #83. 댓글쓰기 폼 추가 ===== -->
	<form name="addWriteFrm" action="<%= request.getContextPath() %>/addComment.action" method="get">     
		     <input type="hidden" name="userid" value="${sessionScope.loginuser.userid}" readonly />
		 성명 : <input type="text" name="name" value="${sessionScope.loginuser.name}" class="short" readonly/>
	     댓글 : <input type="text" name="content" class="long" />
	    
	    <!-- 댓글에 달리는 원게시물 글번호(즉, 댓글의 부모글) -->
	    <input type="hidden" name="parentSeq" value="${boardvo.seq}" />    
	    
	    <button type="button" onClick="goWrite();" >쓰기</button>    
	</form>
	
	<br/>
	<br/>
	<!-- ===== #93. 댓글 내용 보여주기 ===== -->
	<table id="table2">
		<c:forEach var="commentvo" items="${commentList}">
			<tr>
				<td>${commentvo.name}</td>
				<td>${commentvo.content}</td>
				<td>${commentvo.regDate}</td>
			</tr>
		</c:forEach>
	</table>
	
	
</div>











