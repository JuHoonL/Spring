<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/css/home.css' />" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	
	$.ajax({
		url: "<c:url value='main_list' />",
		method:"GET",
		success:function(result){
			$("#main-section").html(result)
		},
		error:function() {
			alert("서버와 통신 오류")
		}
	})
	
	$(".a-menu").click(function(){
		let id = $(this).attr("id")
		$.ajax({
			url : "<c:url value='/' />" + id,
			method:"GET",
			success:function(result){
				$("#main-section").html(result)
			},
			error:function() {
				location.href="<c:url value='/' />"
			}
		})
	})
})
</script>
</head>
<body>
<header id="main-header">
	<div id="header-div">
		<a href="<c:url value='/' />">나 만 의  독 서 록</a>
	</div>
	<nav id="header-nav">
		<c:if test="${empty LOGIN_INFO}">
			<a href="javascript:void(0)" id="join" class="a-menu">회원가입</a>
			<a href="javascript:void(0)" id="login" class="a-menu">로그인</a> 
		</c:if>
		<c:if test="${not empty LOGIN_INFO}">
			<a href="javascript:void(0)" id="logout" class="a-menu">로그아웃</a>
			<a href="javascript:void(0)" id="member" class="a-menu">${LOGIN_INFO.m_username} 님 반갑습니다.</a>
		</c:if>
	</nav>
</header>
<section id="main-section">
</section>
<footer><address>CopyRight &copy; juhoon12@nate.com</address></footer>


</body>
</html>