<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- ===== #35. tiles 를 사용하는 레이아웃 페이지 만들기  ===== --%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>    
    
<style type="text/css">

#khxbackgroundimg 
{

	background:url("<%=request.getContextPath()%>/resources/images/khxbackground.png") no-repeat;
	background-size: 100%;
	width : 100%;
	height: 100%;
	
}

</style>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행의 시작은 KHX와 함께</title>






  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/BootStrapStudy/css/bootstrap.css">
  <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-2.0.0.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath() %>/resources/BootStrapStudy/js/bootstrap.js"></script>
  
  <style type="text/css">
  	#mycontainer	{ width:100%; margin:0 auto; padding:20px; }
	#myheader		{ float:right; min-height:200px; width :85%; padding: 10px;}
	#mycontent		{ float:left; width:85%; min-height:800px;  padding-top: 40px; border:0px solid #1CE3A9;}
	#mysideinfo		{ background-color:#FFFFFF; float:left; width:15%; min-height:1200px; padding-top: 10px;}
	#myfooter		{ float:right; background-color:#000000; clear:both; width:85%; min-height:200px; }
	/* #displayRank 	{ margin:20px; height:200px;} */
	
	#myheader a {text-decoration:none;}
	
	/* mouse over link */
	#myheader a:hover {color: navy; font-weight: bolder;}
	/* 
	  unvisited link 
	a:link {color: #FF0000;}
		
	  visited link 
	a:visited {color: #00FF00;}
		
	  selected link 
	a:active {color: #0000FF;}
	*/
	
	#myheader .mynav {font-size: 13pt;}
	.myrank {font-weight:bold; color:red; font-size:13pt;}
	.mynumber {text-align:center;}
	
	</style>
</head>

<body>
	<div id="mycontainer">
		<div id="mysideinfo" style="border-left : 1px solid #1CE3A9; border-top: #1CE3A9 1px solid; border-bottom: #1CE3A9 1px solid;">
			<tiles:insertAttribute name="sideinfo" />
		</div>

<div id = "khxbackgroundimg">
		<div id="myheader">	
			<tiles:insertAttribute name="header" />
		</div>
		
		<div id="mycontent">
			<tiles:insertAttribute name="content" />
		</div>
</div>		
		<div id="myfooter">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>