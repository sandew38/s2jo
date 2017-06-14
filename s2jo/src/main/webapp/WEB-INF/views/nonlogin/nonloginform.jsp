<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style type="text/css">

	.nonmydiv {display: inline-block; 
	        position: relative; 
	        top: 30px; 
	        line-height: 100%; 
	
	       }
	
	.nonmydisplay {
	display: block;
	background-color: yellow;
				}
	       	
	.nonmyfont {font-size: 14pt;}
	
</style>

<script type="text/javascript">
 
     $(document).ready(function(){
    	 
    	 $("#btnLOGIN").click(function(event){
    		 
    		 if(${sessionScope.nonloginuser != null}) {
    			 alert("이미 비회원 로그인을 하신 상태 입니다 !!");
 				 $("#nhp").val(""); 
 				 $("#npwd").val("");
 				 $("#nhp").focus();
 				 event.preventDefault();
 				 return; 
    		 }
 			 
    		 var nhp = $("#nhp").val(); 
 			 var pwd = $("#npwd").val(); 
 			
 			 if(nhp.trim()=="") {
 			 	 alert("비회원 아이디를 입력하세요!!");
 				 $("#nhp").val(""); 
 				 $("#nhp").focus();
 				 event.preventDefault();
 				 return;
 			 }
 			
 			 if(npwd.trim()=="") {
 				 alert("비회원 비밀번호를 입력하세요!!");
 				 $("#npwd").val(""); 
 				 $("#npwd").focus();
 				 event.preventDefault();
 				 return;
 			 }

 			 document.nonloginFrm.action = "/nonlogin/nonloginEnd.action";
 			 document.nonloginFrm.method = "post";
 			 document.nonloginFrm.submit();
 		}); // end of $("#btnLOGIN").click();-----------------------
 		
 		
 		$("#npwd").keydown(function(event){
 			
 			if(event.keyCode == 13) { // 엔터를 했을 경우
 			
			if(${sessionScope.nonloginuser != null}) {
    			 alert("이미 비회원 로그인을 하신 상태 입니다 !!");
 				 $("#nhp").val(""); 
 				 $("#npwd").val("");
 				 $("#nhp").focus();
 				 event.preventDefault();
 				 return; 
    		 }	
 				
 			var nhp = $("#nhp").val(); 
 			var npwd = $("#npwd").val(); 
 			
 			if(nhp.trim()=="") {
 				alert("비회원 아이디를 입력하세요!!");
 				$("#nhp").val(""); 
 				$("#nhp").focus();
 				event.preventDefault();
 				return;
 			}
 			
 			if(npwd.trim()=="") {
 				alert("비회원 비밀번호를 입력하세요!!");
 				$("#npwd").val(""); 
 				$("#npwd").focus();
 				event.preventDefault();
 				return;
 			}
 			
 			document.nonloginFrm.action = "/nonlogin/nonloginEnd.action";
			document.nonloginFrm.method = "post";
			document.nonloginFrm.submit();
 			
 			}
 		}); // end of $("#npwd").keydown();-----------------------
    	 
    });  	 

</script>

<div style="background-color:white; width:100%; height:100%; margin: auto; border: solid 5px red;">

	<div align="center" style="width:80%; margin-top:10%; margin-left:10%; height:300px; border: solid 5px blue;">
		<h2 class="text-primary">비회원 로그인</h2>
		<p class="bg-primary">&nbsp;</p>
		
		<form name="nonloginFrm">
			<div class="nonmydiv" style="margin-left: 10%;">
				<strong>전화번호</strong>
					<input type="text" id="nhp" name="nhp" placeholder="010-XXXX-XXXX">
			</div>				
			<div class="nonmydiv" style="margin-left: 10%;">
				<span class="nonmydisplay nonmyfont" >암    호 
					<input type="text" id="npwd" name="npwd" placeholder="1234">
				</span> 
			</div>
			
			<div class="nonmydiv" style="margin-left: 5%;">
				<input class="nonmydisplay form-control" type="text" name="nhp" id="nhp" size="20" />
				<input class="nonmydisplay form-control" style="margin-top: 15px;" type="password" name="npwd" id="npwd" size="20" /> 
			</div>
			
			<div class="nonmydiv" style="margin-left: 10%;">
				<button class="btn btn-success" style="vertical-align:center; width: 100px; font-size: 14pt;" type="button" id="btnLOGIN" >로그인</button> 
			</div>	 
		</form>
	</div>
	
</div>




  