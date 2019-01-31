<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>메모장 보기</title>
<link rel="stylesheet" href=<c:url value="/css/memo_write.css" /> >
</head>
<body>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<section>
	<form action=<c:url value="memo_write" /> method="POST">
		<label for="m_auth" id="for_auth">작성자</label>
		<input type="text" id="m_auth" name="m_auth" 
		placeholder="작성자 이름을 입력하세요" /><br/>
		
		<label for="m_date">작성일자</label>
		<input type="date" id="m_date" name="m_date" /><br/>
		
		<label for="m_subject">제목</label>
		<input type="text" id="m_subject" name="m_subject" 
		placeholder="제목을 입력하세요" /><br/>
		
		<label for="m_text">메모</label>
		<textarea rows="15" id="m_text" name="m_text"
		placeholder="메모 내용을 입력하세요" ></textarea><br/>
		
		<button>메모저장</button>
	</form>
</section>

</body>
</html>