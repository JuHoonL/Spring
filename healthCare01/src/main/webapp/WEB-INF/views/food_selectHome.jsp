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
		margin : 0px auto;
	}

	#major-menu{
		float: left;
		width : 20%;
		height: 800px;
		padding-left: 5px; 
		border: 1px solid #ccc;
		font-size:15pt;
	}

	article{
		float: left;
		width : 75%;
		height: 800px;
		border: 1px solid #ccc;
		
	}

	#minor-menu{
		height: 700px;
		
	}

	#calcekcal{
		margin-top: -18px;
		height: 100px;
		border-top: 1px solid #ccc;
	}
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sb-admin.css" >
</head>
<body>
<header>
  <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="${pageContext.request.contextPath}/">헬스케어프로그램</a>
    
	<a class="btn btn-link btn-sm text-white ml-auto ml-md-0" 
	href="#" >
	로그인
    </a>
	<a class="btn btn-link btn-sm text-white ml-auto ml-md-0" 
	href="user_join" >
	회원가입
    </a>
     <a class="btn btn-link btn-sm text-white ml-auto ml-md-0" 
	href="food_select" >
	칼로리계산
    </a>
     <a class="btn btn-link btn-sm text-white ml-auto ml-md-0" 
	href="#" >
	다이어리
    </a>
   

  </nav>
</header>
<section>
	<div id="major-menu">
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
</section>
</body>
</html>