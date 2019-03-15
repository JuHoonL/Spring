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
	$("#btn-pop").click(function(){
		$("form").submit()
	})
	
})
	
</script>
<section>
	<form action=<c:url value="book_insert"/> method="POST">
	
		<label for="b_userid">USERID</label>
		<input type="text" id="b_userid" name="b_userid" value="${LOGIN_INFO.m_userid}" readonly><br/>

		<label for="b_isbn">도서코드</label>
		<input type="text" id="b_isbn" name="b_isbn"><br/>
		
		<label for="b_title">도서제목</label>
		<input type="text" id="b_title" name="b_title"><br/>
		
		<label for="b_date">독서일자</label>
		<input type="date" id="b_date" name="b_date"><br/>
		
		<label for="b_star">별점</label>
		<select id="b_star" name="b_star" >
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
		<textarea rows="5" id="b_text" name="b_text"></textarea><br/>
		
		<hr />
		<label></label>
		<button type="button" id="btn-pop">등록하기</button>
	</form>
</section>