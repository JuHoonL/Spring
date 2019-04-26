<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
._temp {
	height: 200px;
	background: #aaa;
}

.ch-container {
	margin-top: 30px;
	
}
</style>
</head>
<body>
<header class="jumbotron text-center">
	<h1>자유게시판 FINAL</h1>
	<p>자유롭게 아무거나 작성하세요</p>
</header>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<a href="#" class="navbar-brand">나의 게시판</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#colapseBar">
	
	</button>
	<div class="collapse navbar-collapse" id="colapseBar">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a href="#" class="nav-link">로그인</a>
			</li>
			<li class="nav-item">
				<a href="#" class="nav-link">회원가입</a>
			</li>
			<li class="nav-item">
				<a href="#" class="nav-link">관리자</a>
			</li>
		</ul>
	</div>
</nav>
<section class="container ch-container">
	<article class="row">
		<div class="col-sm-4">
			<h4>LIST</h4>
			<div id="list-box" class="_temp">
				<p>게시판 리스트 주루룩~
			</div>
		</div>
		<div class="col-sm-8">
			<h4>Content bOX</h4>
			<div id="text-box" class="_temp">
			</div>
		</div>
	</article>
</section>
</body>
</html>