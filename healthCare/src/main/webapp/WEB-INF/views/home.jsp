<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width initial-scale=1">
<title>Insert title here</title>
<style>
	header {
		background: linear-gradient(to bottom, blue, black);
		color: white;
		text-align: center;
		font-size: 25pt;
		padding: 0.01em;
		margin: 10px 0px;
	}
	
	nav {
		background-color: black;
		margin: 10px 0px;
		font-size: 15pt;
		font-weight: bold;
	}
	
	.nav-home {
		padding: 8px 16px; 
		width: auto;
		border: none;
		display: inline-block;
		outline: 0
	}
	
	.nav-menu {
		padding: 8px 16px; 
		width: auto;
		border: none;
		display: inline-block;
		outline: 0
	}
	
	.nav-menu:hover {
		color: black;
		background: linear-gradient(to bottom, white, silver);
	}
	.nav-home:hover {
		color: black;
		background: linear-gradient(to bottom, white, silver);
	}
	
	a {
		text-decoration: none;
		color: white;
	}
	
	section {
		border: 2px solid black;
		padding: 45px 3px;
		font-weight: bold;
	}
	footer {
		background: linear-gradient(to bottom, blue, black);
		text-align: center;
		color: white;
		font-size: 13pt;
		padding: 7px;
		margin: 10px 0px;
	}
</style>
</head>
<body>

<header><h3 class="">나의 Simple 메모장</h3></header>

<nav>
	<a href="#" class="nav-home">홈</a>
	<a href="#" class="nav-menu">메모쓰기</a>
	<a href="#" class="nav-menu">로그인</a>
	<a href="user_join" class="nav-menu">회원가입</a>
</nav>

<section>
	<p>반갑습니다.
</section>

<footer><address>CopyRight &copy; juhoon12@nate.com</address></footer>

</body>
</html>
