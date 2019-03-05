<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	p {
		color : red;
	}
</style>
<link rel="stylesheet" 
	href=<c:url value="/css/memo_write.css" /> >
<section>
	<form action=<c:url value="memo" /> method="POST">
		
		<label for="id">ID</label>
		<input type="hidden" name="id" value=<c:out value="${MEMO.id}" default="0" /> ><br/>	
		<label for="m_auth" id="for_auth">작성자</label>
		<input value="${MEMO.m_auth}" type="text" id="m_auth" name="m_auth" 
		placeholder="작성자 이름을 입력하세요" /><br/>
		
		<label for="m_date">작성일자</label>
		<input value="${MEMO.m_date}" type="date" id="m_date" name="m_date" /><br/>
		
		<label for="m_subject">제목</label>
		<input value="${MEMO.m_subject}" type="text" id="m_subject" name="m_subject" 
		placeholder="제목을 입력하세요" /><br/>
		
		<label for="m_text">메모</label>
		<textarea rows="15" id="m_text" name="m_text"
		placeholder="메모 내용을 입력하세요" > ${MEMO.m_text} </textarea><br/>
		
		<hr />
		<label></label>
		<button>메모저장</button>
	</form>
</section>
