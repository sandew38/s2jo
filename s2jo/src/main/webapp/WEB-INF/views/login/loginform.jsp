<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<style type="text/css">

	.nonmydiv {display: inline-block; 
	        position: relative; 
	        top: 30px; 
	        line-height: 100%; 
	        border: solid 3px green;
	       }
	
	.nonmydisplay {
	display: block;
	background-color: yellow;
				}
	       	
	.nonmyfont {font-size: 14pt;}
	
@media (min-width: 768px) {
    .omb_row-sm-offset-3 div:first-child[class*="col-"] {
        margin-left: 25%;
    }
}

.omb_login .omb_authTitle {
    text-align: center;
	line-height: 300%;
}
	
.omb_login .omb_socialButtons a {
	color: white; // In yourUse @body-bg 
	opacity:0.9;
}
.omb_login .omb_socialButtons a:hover {
    color: white;
	opacity:1;    	
}
.omb_login .omb_socialButtons .omb_btn-facebook {background: #3b5998;}
.omb_login .omb_socialButtons .omb_btn-twitter {background: #00aced;}
.omb_login .omb_socialButtons .omb_btn-google {background: #c32f10;}


.omb_login .omb_loginOr {
	position: relative;
	font-size: 1.5em;
	color: #aaa;
	margin-top: 1em;
	margin-bottom: 1em;
	padding-top: 0.5em;
	padding-bottom: 0.5em;
}
.omb_login .omb_loginOr .omb_hrOr {
	background-color: #cdcdcd;
	height: 1px;
	margin-top: 0px !important;
	margin-bottom: 0px !important;
}
.omb_login .omb_loginOr .omb_spanOr {
	display: block;
	position: absolute;
	left: 50%;
	top: -0.6em;
	margin-left: -1.5em;
	background-color: white;
	width: 3em;
	text-align: center;
}			

.omb_login .omb_loginForm .input-group.i {
	width: 2em;
}
.omb_login .omb_loginForm   {
    color: red;
}

	
@media (min-width: 768px) {
    .omb_login .omb_forgotPwd {
        text-align: right;
		margin-top:10px;
 	}		
}
</style>


<script type="text/javascript">

$(document).ready(function(){
	 
	 $("#btnLOGIN").click(function(event){
		 
	 
		
		/*  if(${sessionScope.nonloginuser != null}) {
			 alert("이미 비회원 로그인을 하신 상태 입니다 !!");
			 $("#nhp").val(""); 
			 $("#npwd").val("");
			 $("#nhp").focus();
			 event.preventDefault();
			 return; 
		 } 
		*/
		 
		 var userid = $("#userid").val(); 
		 var pwd = $("#pwd").val(); 
		 alert(userid);
		 alert(pwd);    		 
		 

		 
		 if(userid.trim()=="") {
		 	 alert("정회원 아이디를 입력하세요!!");
			 $("#userid").val(""); 
			 $("#userid").focus();
			 event.preventDefault();
			 return;
		 }
		 
		
		 if(pwd.trim()=="") {
			 alert("정회원 비밀번호를 입력하세요!!");
			 $("#pwd").val(""); 
			 $("#pwd").focus();
			 event.preventDefault();
			 return;
		 }
		 document.loginFrm.action = "/khx/loginEnd.action";
		 document.loginFrm.method = "post";
		 document.loginFrm.submit();
			alert("정회원 로그인 성공!1");

	}); // end of $("#btnLOGIN").click();-----------------------
	
	
	$("#pwd").keydown(function(event){
		
		if(event.keyCode == 13) { // 엔터를 했을 경우
			
		var userid = $("#userid").val(); 
		var pwd = $("#pwd").val(); 
		 alert(userid);
		 alert(pwd);    	
		if(nhp.trim()=="") {
			alert("아이디를 입력하세요!!");
			$("#userid").val(""); 
			$("#userid").focus();
			event.preventDefault();
			return;
		}
		
		if(pwd.trim()=="") {
			alert("정회원 비밀번호를 입력하세요!!");
			$("#pwd").val(""); 
			$("#pwd").focus();
			event.preventDefault();
			return;
		}
		
		document.loginFrm.action = "/khx/loginEnd.action";
		document.loginFrm.method = "post";
		document.loginFrm.submit();
		alert("정회원 로그인 성공!2");

		}
		
	
	}); // end of $("#pwd").keydown();-----------------------
	 
}); //end of $(document).ready(function(){


</script>



<div style="background-color:white; width:100%; height:100%; margin: auto; border: solid 0px red; padding-top: 100px;">
   <div class="omb_login">
    	<h3 class="omb_authTitle">정회원로그인 or <a href="#">회원가입</a></h3>
		<div class="row omb_row-sm-offset-3 omb_socialButtons">
    	    <div class="col-xs-4 col-sm-2">
    	    	<a href="<%=request.getContextPath() %>/nonloginform.action" class="btn btn-lg btn-block omb_btn-facebook">
			        <i class="fa fa-facebook visible-xs"></i>
			        <span class="hidden-xs btn btn-lg">비회원 로그인</span>
			    </a>
	        </div>
        	<div class="col-xs-4 col-sm-2">
		        <a href="<%=request.getContextPath() %>/loginform.action" class="btn btn-lg btn-block omb_btn-twitter">
			        <i class="fa fa-twitter visible-xs"></i>
			        <span class="hidden-xs btn btn-lg">정회원 로그인</span>
		        </a>
	        </div>	
        	<div class="col-xs-4 col-sm-2">
<%-- 		        <a href="<%=request.getContextPath() %>/loginform.action" class="btn btn-lg btn-block omb_btn-google">
 --%>
		        <a class="btn btn-lg btn-block omb_btn-google">
			        <i class="fa fa-google-plus visible-xs"></i>
			        <span class="hidden-xs btn btn-lg">네이버아이디로그인</span>
		        </a>
	        </div>	
		</div>


		<div class="row omb_row-sm-offset-3 omb_loginOr">
			<div class="col-xs-12 col-sm-6">
				<hr class="omb_hrOr">
				<span class="omb_spanOr">or</span>
			</div>
		</div>
			<p align="center" style="font-size:14px;"><span style="color: #639EB0">통합 예매 홈페이지</span>는 네이버 회원 아이디와 비밀번호로 이용이 가능합니다.</p>
		<br/>
		<form name="loginFrm" id="loginFrm" class="loginFrm">
			<div class="row omb_row-sm-offset-3">
				<div class="col-xs-12 col-sm-6">	
				    <form class="omb_loginForm" action="" autocomplete="off" method="POST">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user"></i></span>
							<input type="text" class="form-control" name="userid" id="userid" placeholder="회원아이디">
						</div>
						<span class="help-block"></span>
											
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-lock"></i></span>
							<input  type="password" class="form-control" name="pwd" id="pwd" placeholder="비밀번호">
						</div>
		<br/><br/>
						<button class="btn btn-lg btn-primary btn-block" type="button" id="btnLOGIN">Login</button>
					</form>
				</div>
	    	</div>
		</form>
			
		<div class="row omb_row-sm-offset-3">
			<div class="col-xs-12 col-sm-3">
				<label class="checkbox" style="margin-left: 20px;">
					<input type="checkbox" value="remember-me">Remember ID
				</label>
			</div>
			<div class="col-xs-12 col-sm-3">
				<p class="omb_forgotPwd" >
					<a href="#">Forgot password?</a>
				</p>
			</div>
		</div>	    	
	</div>
</div>


  