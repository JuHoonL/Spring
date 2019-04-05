<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<script>
$(function(){
/*새로운코드를 만드는 버튼에 대한 script*/
	$("#btn_new").click(function(){
		/*Jquery3이상에서만 ajax사용시 method가 Get인 경우에 사용가능*/
		$.get("${rootPath}/dept/get_new_code", function(result)){
			$("#d_code").val(result)
		}
	})
})
</script>
<link href="${rootPath}/css/write.css" rel="stylesheet" />
<form:form action="${pageContext.request.contextPath}/dept/write" modelAttribute="deptVO">
	<fieldset>
		<legend>거래처정보 작성</legend>
		<form:label class="in-label" path="d_code">거래처코드</form:label>
		<div class='in-box'>
			<form:input class='in-box2 code' placeholder="거래처코드를 입력하세요" id="d_code" path="d_code" />
			<button id="btn_new" type="button">새로작성</button><br/>
			<form:errors path="d_code" class="in-box-error" />
		</div>
		
		<label class="in-label" for="d_name">거래처명</label>
		<div class='in-box'>
			<form:input class="in-box2" placeholder="거래처명을 입력하세요" id="d_name" path="d_name" /><br/>
			<form:errors path="d_name" class="in-box-error" />
		</div>
		
			<label class="in-label" for="d_ceo">대표자명</label>
		<div class='in-box'>
			<form:input class="in-box2" placeholder="대표자명을 입력하세요" id="d_ceo" path="d_ceo" /><br/>
			<form:errors path="d_ceo" class="in-box-error" />
		</div>
				
		<label  class="in-label" for="d_tel">대표전화</label>
		<div class='in-box'>
			<form:input class="in-box2" placeholder="대표전화를 입력하세요" id="d_tel" path="d_tel" /><br/>
			<form:errors path="d_tel" class="in-box-error" />
		</div>
		
		<label class="in-label" for="d_addr">주소</label>
		<div class='in-box'>
			<form:input class="in-box2" placeholder="거래처주소를 입력하세요" id="d_addr" path="d_addr" /><br/>
			<form:errors path="d_addr" class="in-box-error" />
		</div>
		<hr/>
		
		<label class="in-label" for="btn-write"></label>
		<div class='in-box'>
			<button id="btn-write" type="submit">저장</button>
		</div>
	</fieldset>
</form:form>