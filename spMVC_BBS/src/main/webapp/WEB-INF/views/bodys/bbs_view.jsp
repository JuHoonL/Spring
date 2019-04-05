<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.view-box {
		width: 70%;
		border: 1px solid blue;
		padding: 0.5rem;
		margin: 10px auto;
	}
	
	.bbs_box {
		width: 70%;
		margin: 10px auto;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<script>
$(function(){
	$("#bbs_update").click(function(){
		let id = ${BBS.id}
		location.href="<c:url value='update'/>" + "?id=" + id
	})
	
	$("#bbs_delete").click(function(){
		let id = ${BBS.id}
		if(confirm("게시물을 삭제할까요?")){
			location.href="<c:url value='delete'/>" + "?id=" + id
		}
	})
	
	$("#bbs_review").click(function(){
		let id = ${BBS.id}
		location.href="<c:url value='/'/>"
	})
})
</script>
<body>
<article id="bbs_view" class="view-box">
	<h3>${BBS.b_subject}</h3>
	<p><b>작 성 자 ID : ${BBS.b_userid}</b>
	<p><b>작 성 일 자 : ${BBS.b_date}:${BBS.b_time}</b>
	<p><b>내       용 : ${BBS.b_content}</b>
	<p><img src="${pageContext.request.contextPath}/files/${BBS.b_image}">
</article>

	<div class="bbs_box">
	<c:if test="${BBS.b_userid == LOGIN_INFO.m_userid}">
		<button type="button" id="bbs_update">편집</button>
		<button type="button" id="bbs_delete">삭제</button>
	</c:if>
		<button type="button" id="bbs_review">목록보기</button>
	</div>

</body>
</html>