<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
	* {
		box-sizing: border-box;
		-webkit-box-sizing: border-box;
		-moz-box-sizing: border-box;
	}
	
	html{
		height: 100%;
	}
	
	body {
		display: flex;
		margin: 0;
		flex-direction: column;
		height: 100%;
	}
	
	header {
		width: 100%;
		color: white;
		background: linear-gradient(to bottom, purple, purple);
		text-align: center;
	}
	
	section {
		height: 90%;
	}
	
	#main-menu {
		background-color: black;
		width: 100%;
		margin: 3px 0px;
		height: 5%;
		padding-top: 10.6px;
	}
	
	.main-menu {
		padding: 10px;
		color: white;
		text-decoration: none;
	}
	
	.main-menu:hover {
		background: linear-gradient(to bottom, white, silver);
		color: black;
	}
	
	#pre-list {
		display: flex;
		border: 2px solid black;
		width: 100%;
		height: 93.8%;
	}
	
	footer {
		border: 1px solid purple;
		background: linear-gradient(to bottom, white, purple);
		color: white;
		text-align: center;
	}
	
	
	
	
</style>
</head>
<body>
<header>
	<h2>회원가입</h2>
</header>
<section>
	<nav id="main-menu">
		<a href="${rootPath}/" class="main-menu">홈</a>
		<a href="#" class="main-menu">로그인</a>
		<a href="${rootPath}/join" class="main-menu">회원가입</a>
		<a href="#" class="main-menu">관리자</a>
		<a href="#" class="main-menu">시스템정보</a>
	</nav>
	<article id="pre-list">
		<c:if test="${BODY == 'JOIN-FORM'}" >
			<%@ include file="/WEB-INF/views/include/join.jsp" %>
		</c:if>
		<P>상품리스트 표시 영역
		
	</article>
</section>
<footer><address>CopyRight &copy; juhoon12@nate.com</address></footer>

</body>
</html>