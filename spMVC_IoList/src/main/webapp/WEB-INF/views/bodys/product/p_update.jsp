<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<script>
$(function(){
	$("#btn-return").click(function(){
		location.href="<c:url value='/product/list' />"
	})
})
</script>
<link href="${rootPath}/css/write.css" rel="stylesheet" />
<form:form action="${pageContext.request.contextPath}/product/update" modelAttribute="productVO">
	<fieldset>
		<legend>상품정보 수정</legend>
		<form:label class="in-label" path="p_code">상품코드</form:label>
		<div class='in-box'>
			<form:input class='in-box2' placeholder="상품코드를 입력하세요" id="p_code" path="p_code" /><br/>
			<form:errors path="p_code" class="in-box-error" />
		</div>
		
		<label class="in-label" for="p_name">상품명</label>
		<div class='in-box'>
			<form:input class="in-box2" placeholder="상품명을 입력하세요" id="p_name" path="p_name" /><br/>
			<form:errors path="p_name" class="in-box-error" />
		</div>
		
			<label class="in-label" for="p_tax">관세</label>
		<div class='in-box'>
			<div class='in-box radiobox-div'>
			<form:radiobutton class="radio-box" value="1" label="과세" id="p_tax" path="p_tax" />
			<form:radiobutton class="radio-box" value="0" label="면세" id="p_tax" path="p_tax" />
			</div><br/>
			<form:errors path="p_tax" class="in-box-error" />
		</div>
				
		<label  class="in-label" for="p_iprice">매입단가</label>
		<div class='in-box'>
			<form:input class="in-box2" placeholder="매입단가을 입력하세요" id="p_iprice" path="p_iprice" /><br/>
			<form:errors path="p_iprice" class="in-box-error" />
		</div>
		
		<label class="in-label" for="p_oprice">매출단가</label>
		<div class='in-box'>
			<form:input class="in-box2" placeholder="매출단가을 입력하세요" id="p_oprice" path="p_oprice" /><br/>
			<form:errors path="p_oprice" class="in-box-error" />
		</div>
		<hr/>
		
		<label class="in-label" for="btn-write"></label>
		<div class='in-box'>
			<button id="btn-write" type="submit">저장</button>
			<button id="btn-return" type="button">뒤로가기</button>
		</div>
	</fieldset>
</form:form>