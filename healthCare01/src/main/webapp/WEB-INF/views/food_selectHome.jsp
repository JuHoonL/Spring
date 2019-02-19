<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음식 선택</title>
<style>
	
	section {
		padding: 15px;
	}
	
	#all-div {
		width: 1600px;
		margin: 1px auto;
	}

	#major-menudiv{
		float: left;
		width : 20%;
		height: 800px;
		padding-left: 5px; 
		border: 1px solid #ccc;
		font-size:15pt;
		text-decoration: none;
		margin-left: 45px;
		overflow: scroll; 
		overflow-x: hidden;
		overflow-y: auto;
	}

	article{
		float: left;
		width : 75%;
		height: 800px;
		border: 1px solid #ccc;
		
	}

	#minor-menu{
		height: 600px;
		overflow: scroll; 
		overflow-x: hidden;
		overflow-y: auto;
	}

	#calcekcal{
		height: 150px;
		border-top: 1px solid #ccc;
		color: green;
		font-size: 13pt;
		padding: 13px ;
	}
	
	table {
		width: 98%;
		margin: 5px auto;
	}
	
	td {
		border: 1px solid #ccc;
		text-align: center;
		font-size: 12pt;
		padding: 10px;
	}
	
	#td-foodname {
		color: black;
		
	}
	
	.selectfood {
		display : inline-block;
	}
	
	#Tkcal {
		display: block;
		float:right;
		margin: 9px;
		font-size: 20pt;
	}
			
	#calce-button {
		height:50px;
		width: 450px;
		margin: 1px auto;
	}
	
	#button {
		width: 80%;	
	}
	
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
<section>
<div id="all-div">
	<div id="major-menudiv">
		<c:forEach items="${ALLFOODCATE}" var="FoodVO">
			<a href="food_select01?cate_code=${FoodVO.cate_code}">${FoodVO.cate}</a><br/>
		</c:forEach>
	</div>
	<article>
		<div id="minor-menu">
			<h3>분류를 선택해 주세요</h3>
		</div>
		<div id="calcekcal">
			<p>칼로리계산
		</div>
	</article>
</div>
</section>
</body>
</html>