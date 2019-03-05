<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
$(function(){
	$("#btn-login").click(function(){
		let m_userid = $("#m_userid").val()
		let m_password = $("#m_password").val()
		
		if(m_userid=="") {
			alert("id(email)을 반드시 입력하세요")
			$("#m_userid").focus()
			return false;
		}
		
		if(m_password=="") {
			alert("비밀번호를 반드시 입력하세요")
			$("#m_password").focus()
			return false;
		}
		
		$("form").submit()
	})
	
	//컨트롤러에서 보낸 LOGIN변수안에 FAIL문자열이 담겨있으면 
	if("${LOGIN_MSG}" == "FAIL") {
		$(".error-box").css("display","inline-block")
		$("#error-msg").html("<b><font color=red> 로그인 실패!! </font></b>")
	} 
	if("${LOGIN_MSG}" == "ADMIN-CONFIRM-FAIL") {
		$(".error-box").css("display","inline-block")
		$("#error-msg").html("<b><font color=red>" + "관리자로 로그인하세요." + "</font></b>")
	}
	
})
</script>
<style>
	#form-join {
		width: 50%;
		margin: 20px auto;
		padding: 10px;
		height: 50%;
	}
	
	input {
		border: 1px solid blue;
		padding: 8px;
	}
	
	.width-90 {
		display: inline-block;
		width: 90%;
		margin: 10px 0px 10px 45px;
	}
			
	.in-box:hover {
		background-color: #ddd;
	}
	
	input:invalid {
		border: 2px solid red;
	}
	
	.btn-login {
		background-color: black;
		color: yellow;
		font-size: 20px;
		font-weight: bold;
	}
	
	.error-box {
		display: none;
	}
	
</style>
<form action="<c:url value='login' />" method="POST" id="form-join" autocomplete="on">
	<fieldset id="login-div">
		<legend><h3>로그인</h3></legend>
		
		<h3 id="error-msg" class="error-box width-90"></h3><br />
			
		<input type="text" class="in-box  width-90" id="m_userid" name="m_userid" placeholder="ID를 입력해주세요" /><br />
		
		<input type="password" class="in-box  width-90"  id="m_password" name="m_password" placeholder="비밀번호를 입력해주세요" /><br />
			
		<button type="button" id="btn-login" class="width-90 btn-login">로그인</button>
	</fieldset>
</form>
