<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script>
$(function(){
	$("#btn_rent").click(function(){
		var fData = $("form").serialize()
		
		$.post("${rootPath}/rent/cart",fData,function(result){
			$("#div-body").html(result)
		})
	})
})
</script>
<f:form modelAttribute="rentVO">
	<label for="rent_date">대여날짜</label>
	<input type="date" value="${rentVO.rent_date}" name="rent_date" id="rent_date" class="w3-input w3-border" />
	
	<label for="rent_return_date">회수예정날짜</label>
	<input type="date" value="${rentVO.rent_return_date}" name="rent_return_date" id="rent_return_date" class="w3-input w3-border" />
	
	<div>
	<label for="book_isbn">도서정보</label>
	<f:input path="book_isbn" class="w3-input w3-border" />
	<div><span id="book_title"></span></div>
	</div>
	
	<div>
	<label for="user_seq">회원정보</label>
	<f:input path="user_seq" class="w3-input w3-border" />
	<span id="user_name"></span>
	</div>
	
	<button type="button" id="btn_rent">장바구니넣기</button>
</f:form>
<div id="div-body">

</div>