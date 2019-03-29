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
	$(".messages").click(function(){
		let id = $(this).attr("id")
		
		location.href="<c:url value='/m_request?m_id=' />" + id
	})
})
</script>
</head>
<body>
<header id="home-header">
 <p id="home-header-p">Web Application Service</p>
</header>
<section id="home-section">
<nav id="home-nav">
	<c:if test="${not empty LOGIN_INFO}">
		<a href="<c:url value='e_send' />" id="e_send">메세지보내기</a>
		<a href="javascript:void(0)" id="send-message" class="messages">보낸메세지함</a>
		<a href="javascript:void(0)" id="request-message" class="messages">받은메세지함</a>
	</c:if>
	<c:if test="${empty LOGIN_INFO}">
		<a href="<c:url value='login1' />" id="login">로그인</a>
		<a href="<c:url value='join1' />" id="join">회원가입</a>
	</c:if>
	<c:if test="${not empty LOGIN_INFO}">
		<a href="<c:url value='logout' />" id="logout">로그아웃</a>
	</c:if>
	<a href="#" id="m-notice">공지사항</a>
</nav>
<article id="body">
	<c:if test="${BODY == 'JOIN'}">
		<%@ include file="/WEB-INF/views/bodys/join.jsp" %>
	</c:if>
	<c:if test="${BODY == 'LOGIN'}">
		<%@ include file="/WEB-INF/views/bodys/login.jsp" %>
	</c:if>
	<c:if test="${BODY == 'REQUEST'}">
		<%@ include file="/WEB-INF/views/bodys/email_list.jsp" %>
	</c:if>
	<c:if test="${BODY == 'INSERT'}">
		<%@ include file="/WEB-INF/views/bodys/etc/mail_pop_form.jsp" %>
	</c:if>
	<c:if test="${BODY == 'UPDATE_DELETE'}">
		<%@ include file="/WEB-INF/views/bodys/etc/mail_form.jsp" %>
	</c:if>
	<c:if test="${BODY == 'SAVE'}">
		<%@ include file="/WEB-INF/views/bodys/mail_save_form.jsp" %>
	</c:if>
</article>
</section>
<footer id="home-footer"><address>CopyRight &copy; juhoon12@nate.com</address></footer>
</body>
</html>