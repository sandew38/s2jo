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
	
</style>

<script type="text/javascript">
 
     $(document).ready(function(){
    	 
    	 $("#btnNonLOGIN").click(function(event){
    		 
    	 
 			
    		/*  if(${sessionScope.nonloginuser != null}) {
    			 alert("이미 비회원 로그인을 하신 상태 입니다 !!");
 				 $("#nhp").val(""); 
 				 $("#npwd").val("");
 				 $("#nhp").focus();
 				 event.preventDefault();
 				 return; 
    		 } 
    		*/
 			 
    		 var nhp = $("#nhp").val(); 
 			 var npwd = $("#npwd").val(); 
 			 alert(nhp);
 			 alert(npwd);    		 
 			 

 			 
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
 			 document.nonloginFrm.action = "/khx/nonloginEnd.action";
 			 document.nonloginFrm.method = "post";
 			 document.nonloginFrm.submit();
  			alert("비회원 로그인 성공!1");

 		}); // end of $("#btnLOGIN").click();-----------------------
 		
 		
 		$("#npwd").keydown(function(event){
 			
 			if(event.keyCode == 13) { // 엔터를 했을 경우
 			
			
 				
 			var nhp = $("#nhp").val(); 
 			var npwd = $("#npwd").val(); 
			 alert(nhp);
 			 alert(npwd);    	
 			if(nhp.trim()=="") {
 				alert("전화번호를 입력하세요!!");
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
 			
 			document.nonloginFrm.action = "/khx/nonloginEnd.action";
			document.nonloginFrm.method = "post";
			document.nonloginFrm.submit();
 			alert("비회원 로그인 성공!2");

 			}
 			
 		
 		}); // end of $("#npwd").keydown();-----------------------
    	 
    }); //end of $(document).ready(function(){


</script>

<div style="background-color:white; width:100%; height:100%; margin: auto; border: solid 5px red;">

	<div align="center" style="vertical-align:center; width:80%; margin:10%; height:70%; border: solid 5px blue;">
			<h2 class="text-primary" style="color: #639EB0; font-weight: bold;">비회원 로그인</h2>
			<p style="font-size:8px; "><span style="color: #639EB0">통합 예매 홈페이지</span>는 네이버 회원 아이디와 비밀번호로 이용이 가능합니다.</p>
			<p class="bg-primary">&nbsp;</p>
			
			<form name="nonloginFrm" id="nonloginFrm" class="nonloginFrm">
				<div class="nonmydiv" style="margin-left: 10%; margin-top:10%; float:left;">
	
						<input class="nonmydisplay form-control" type="text" name="nhp" id="nhp" size="80px;" style="height: 50px;"  placeholder="010xxxxxxxx"/>
						<input class="nonmydisplay form-control" type="text" name="npwd" id="npwd" size="80px;" style="height:50px; margin-right: 20px; margin-top: 40px;"  placeholder="2134"/>
	
				</div>
				
				<div class="nonmydiv" style="margin-left:20px; margin-top:10%; float:left;">
					<button class="btn btn-success" style="vertical-align:center; height:125px; width: 120px; font-size: 14pt;" type="button" id="btnNonLOGIN" >로그인</button> 
				</div>
							
				
			</form>
			<div>아이디 찾기</div>
				<div>비밀번호 찾기</div>
		</div>
		<div>
			네이버 통합회원으로 가입하시면 홈페이지와 예매내역 공유로 더욱 편리한 기차 이용이 가능합니다.  <a>통합회원가입</a>
		</div>
</div>




  <!-- 		로그인 2안
			<div class="nonmydiv" style="margin-left: 10%;">
				<strong>전화번호</strong>
					<label style="background-color: red;">
						<input type="text" id="nhp" name="nhp" >
					</label>
			</div>
			<div class="nonmydiv" style="margin-left: 10%;">
				<strong>암    호 </strong>
					<input type="text" id="npwd" name="npwd" placeholder="1234">
			</div>
			 -->
  