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
	#email_view {
		margin-top: 50px;
		border: 2px solid black;
		padding: 20px;
	}
	
	.email_box {
		width: 50%;
		margin: 10px auto;
	}
	
	#e-content {
		width: 90%;
		margin: 5px auto;
		height: 600px;
		overflow: auto;
	}
	
	#images {
		flex: 0 1 auto;
		margin: 5px auto;
		
		display: flex;
		align-items: center;
		justify-content: center;
	}
	
	.img-box {
		flex: 0 0 50px;
		height: 200px;
		margin: 10px;
		border-radius: 6px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<script>
$(function(){
	
	$("#email_send").click(function(){
		let id = ${EMAIL.id}
		location.href="<c:url value='e_send'/>" + "?id=" + id
	})
	
	$("#email_update").click(function(){
		let id = ${EMAIL.id}
		location.href="<c:url value='e_save'/>" + "?id=" + id
	})
	
	$("#email_delete").click(function(){
		let id = ${EMAIL.id}
		if(confirm("게시물을 삭제할까요?")){
			location.href="<c:url value='delete'/>" + "?id=" + id
		}
	})
})
</script>
<body>
<article id="email_view" class="email_box">
	<div id="e-content">
	<h3>제목 : ${EMAIL.s_subject}</h3>
	<p>발 송 자 : ${EMAIL.from_email}</p>
	<p>수 신 자 : ${EMAIL.to_email}</p>
	<p>작성일자 : ${EMAIL.s_date}</p>
	<p>작성시간 : ${EMAIL.s_time}</p>
	<p>내    용 : ${EMAIL.s_content}</p>
	
		<p>첨부파일1 :
		<c:if test="${not empty EMAIL.s_file1}">
			<p><img src="${pageContext.request.contextPath}/files/${EMAIL.s_file1}" class="img-box">
		</c:if></p>
		<p>첨부파일2 :
		<c:if test="${not empty EMAIL.s_file2}">
			<p><img src="${pageContext.request.contextPath}/files/${EMAIL.s_file2}" class="img-box">
		</c:if></p>
		</div>
</article>
	<div class="email_box">
		<button type="button" id="email_send">메일보내기</button>
		<button type="button" id="email_update">수정</button>
		<button type="button" id="email_delete">삭제</button>
	</div>
</body>
</html>