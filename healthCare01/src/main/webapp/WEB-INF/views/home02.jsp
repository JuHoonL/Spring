<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  	}
  	
  	#hometitle {
  		text-decoration: none;
  		font-size: 25pt;
  		color: white;
  		
  	}
  	
  	#login-title {
  		margin-left: auto;
  		display:flex;
  		align-items: center;
		justify-content: center;
  	}
  	
  	label, input {
  		
  	}
  	
  	.flex-login-title {
  		margin: 5px;
		color: white;
  	}
  </style>
<body>
<header>
	<a id="hometitle" href="${pageContext.request.contextPath}/">헬스케어프로그램</a>
	<form action="login" method="POST">
	<div id="login-title">
		<label for="userId" class="flex-login-title">Id : </label> 
		<input type ="text" id="userId" name="userId" class="flex-login-title" />
		
    	<label for="password" class="flex-login-title">PassWord : </label> 
    	<input type ="password" id="password" name="password" class="flex-login-title"/>
    	<a href="user_DB" class="flex-login-title">로그인</a>
		<a href="user_join" class="flex-login-title">회원가입</a>
	</div>
	</form>
</header>
</body>
</html>
