<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>헬스</title>
  <style>
  	header {
  		display: flex;
  		background-color: #343a40;
  		padding : 15px;
  		width: 1600px;
  		margin: 1px auto;
  	}
  	
  	#hometitle {
  		text-decoration: none;
  		font-size: 25pt;
  		color: white;
  		
  	}
  	
  	.login-title {
  		margin-left: auto;
  		display:flex;
  		align-items: center;
		justify-content: center;
  	}
  	
  	label, input {
  		width: 30%;
  	}
  	
  	.flex-login-title {
  		margin: 5px;
		color: white;
		text-decoration: none;
  	}
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script>
  	$(function(){
		 $("#login-button").click(function(){
			 var userId = $("#userId").val();
			 var password = $("#password").val();
			 
			 if(userId == "") {
				 alert("Id를 입력해주세요")
				 $("#userId").focus();
				 return false;
			 }
			 if(password == "") {
				 alert("비밀번호를 입력해주세요")
				 $("#password").focus();
				 return false;
			 }
			 
			 $("form").submit();
		 })
		 
		$(function(){
			 if("${MSG}" == "true") {
				 alert("로그인 되었습니다.")
			 } else if("%{MSG}" == "false"){
				 alert("아이디나 비밀번호를 다시 확인해 주세요.")
			 }
		 })
		 
	})
  </script>
<body>
<header>
	<a id="hometitle" href="${rootPath}/">헬스케어프로그램</a>
	<c:if test="${empty LOGIN}">
		<div class="login-title">
		<form action="login" method="POST">
			<label for="userId" class="flex-login-title">Id : </label> 
			<input type ="text" id="userId" name="userId" />
			
	    	<label for="password" class="flex-login-title">PassWord : </label> 
	    	<input type="password" id="password" name="password" />
	    	<a href="#" id="login-button" class="flex-login-title">로그인</a>
		</form>
		<a href="${rootPath}/user_join" class="flex-login-title">회원가입</a>
		</div>
	</c:if>
	<c:if test="${LOGIN ne null}">
		<div class="login-title">
			<a class="flex-login-title">${LOGIN.userName} 님 반갑습니다.</a>
			<a href="${rootPath}/logout" class="flex-login-title">로그아웃</a>
		</div>
	</c:if>
</header>
</body>
</html>
