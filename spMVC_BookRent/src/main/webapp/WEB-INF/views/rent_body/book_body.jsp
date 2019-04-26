<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script>
$(function(){
	$("#book_text").keydown(function(e){
		if(e.keyCode == 13) {
			let text = $(this).val()
			
		$.get("${rootPath}/book/s_list/" + text,function(result){
			$("#book_list").html(result)
		})	
		}
	})
})
</script>
<input type="text" name="book_text" id="book_text" placeholder="도서정보(제목, 저자)를 입력후 Enter">
<div id="book_list">
	
</div>
