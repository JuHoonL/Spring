<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="<c:url value='/css/book_input_form.css' />" />
<style>
	#div-button {
		width: 150px;
		height: 30px;;
		float: right;
		margin-top: 20px;
	}
	
	#btn-update {
		width: 70px;
		height: 30px;
	}
	
	#btn-delete {
		width: 70px;
		height: 30px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	$("#btn-update").click(function(){
		$("form").submit()
	})
	
	$("#btn-delete").click(function(){
		var b_id = $("#b_id").val()
		
		if(!confirm("정말 메모를 삭제 할까요")) {
			 return false;
		}
		
		$.ajax({
			url : "<c:url value='/book_delete' />",
			method:"GET",
			data:{b_id},
			success:function(result){
				location.href="<c:url value='/' />"
			},
			error:function(){
				alert("서버와 통신 오류 발생")
			}
		})
		
		
	})
})
	
</script>
<section>
	<form action=<c:url value="book_update"/> method="POST">
	
		<input type="hidden" id="b_id" name="b_id" value=<c:out value="${BOOK.b_id}" default="0" />  >
		<label for="b_userid">USERID</label>
		<input 
			type="text"  
			value="${LOGIN_INFO.m_userid}" readonly
			id="b_userid" 
			name="b_userid"><br/>

		<label for="b_isbn">도서코드</label>
		<input 
			type="text"  
			value="${BOOK.b_isbn}" id="b_isbn" name="b_isbn"><br/>
		
		<label for="b_title">도서제목</label>
		<input value="${BOOK.b_title}" type="text" id="b_title" name="b_title"><br/>
		
		<label for="b_date">독서일자</label>
		<input value="${BOOK.b_date}" type="date" id="b_date" name="b_date"><br/>
		
		<label for="b_star">별점</label>
		<select value="${BOOK.b_star}" id="b_star" name="b_star" >
			<option value="0.0">0</option>
			<option value="0.5">0.5</option>
			<option value="1.0">1.0</option>
			<option value="1.5">1.5</option>
			<option value="2.0">2.0</option>
			<option value="2.5">2.5</option>
			<option value="3.0">3.0</option>
			<option value="3.5">3.5</option>
			<option value="4.0">4.0</option>
			<option value="4.5">4.5</option>
			<option value="5.0">5.0</option>
		</select><br/>
		
		<label for="b_text">독서록</label>
		<textarea rows="5" id="b_text" name="b_text">${BOOK.b_text}</textarea><br/>
		
		<hr />
		<label></label>
		<button type="button" id="btn-update">수정</button>
		<button type="button" id="btn-delete">삭제</button>
	</form>
</section>