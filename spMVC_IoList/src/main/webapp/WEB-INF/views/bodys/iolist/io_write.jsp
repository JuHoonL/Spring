<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ include file="/WEB-INF/views/bodys/modal-box.jspf" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<script>
$(function(){
	$("#btn-return").click(function(){
		location.href="<c:url value='/iolist/list' />"
	})
	
	$.get("${rootPath}/product/get_p_name?p_code=${iolistVO.io_pcode}",function(result){
		$("#p_name").text(result)
	})
	
	$.get("${rootPath}/dept/get_d_name?d_code=${iolistVO.io_dcode}",function(result){
		$("#d_name").text(result)
	})
})
</script>
<link href="${rootPath}/css/write.css" rel="stylesheet" />
<form:form action="${pageContext.request.contextPath}/iolist/write" modelAttribute="iolistVO">
	<fieldset>
		<c:if test="${empty ACTION}">
			<legend>매입매출 작성</legend>
		</c:if>
		<c:if test="${not empty ACTION}">
			<legend>매입매출 수정</legend>
		</c:if>
		
		<label class="in-label" for="io_date">거래일자</label>
		<div class='in-box'>
			<form:input class="in-box2" placeholder="거래일자를 입력하세요" id="io_date" path="io_date" /><br/>
			<form:errors path="io_date" class="in-box-error" />
		</div>
		
		<label class="in-label" for="io_time">거래시간</label>
		<div class='in-box'>
			<form:input class="in-box2" placeholder="거래시간을 입력하세요" id="io_time" path="io_time" /><br/>
			<form:errors path="io_time" class="in-box-error" />
		</div>
		
			<label class="in-label" for="io_pcode">상품코드</label>
		<div class='in-box'>
			<form:input class="in-box3" placeholder="상품코드를 입력하세요" id="io_pcode" path="io_pcode" />
			<span class="name-box" id="p_name"></span><br/>
			<form:errors path="io_pcode" class="in-box-error" />
		</div>
				
		<label  class="in-label" for="io_dcode">거래처코드</label>
		<div class='in-box'>
			<form:input class="in-box3" placeholder="거래처코드를 입력하세요" id="io_dcode" path="io_dcode" />
			<span class="name-box" id="d_name"></span><br/>
			<form:errors path="io_dcode" class="in-box-error" />
		</div>
		
		<label class="in-label" for="io_quan">수량</label>
		<div class='in-box'>
			<form:input class="in-box2" placeholder="수량을 입력하세요" id="io_quan" path="io_quan" /><br/>
			<form:errors path="io_quan" class="in-box-error" />
		</div>
		
		<label class="in-label" for="io_inout">매입/매출</label>
		<div class='in-box'>
			<div class='in-box radiobox-div'>
			<form:radiobutton class="radio-box" value="1" label="매입" id="io_inout" path="io_inout" />
			<form:radiobutton class="radio-box" value="2" label="매출" id="io_inout" path="io_inout" />
			</div><br/>
			<form:errors path="io_inout" class="in-box-error" />
		</div>
		
		<label class="in-label" for="io_tax">과세</label>
		<div class='in-box'>
			<div class='in-box radiobox-div'>
			<form:radiobutton class="radio-box" value="1" label="과세" id="io_tax" path="io_tax" />
			<form:radiobutton class="radio-box" value="0" label="면세" id="io_tax" path="io_tax" />
			</div><br/>
			<form:errors path="io_tax" class="in-box-error" />
		</div>
		
		<label class="in-label" for="io_price">공급단가</label>
		<div class='in-box'>
			<form:input class="in-box2" placeholder="공급단가를 입력하세요" id="io_price" path="io_price" /><br/>
			<form:errors path="io_price" class="in-box-error" />
		</div>
		
		<label class="in-label" for="io_total">공급가액</label>
		<div class='in-box'>
			<form:input class="in-box2" placeholder="공급가액을 입력하세요" id="io_total" path="io_total" /><br/>
			<form:errors path="io_total" class="in-box-error" />
		</div>
		
		<label class="in-label" for="io_tax_total">합계</label>
		<div class='in-box'>
			<form:input class="in-box2" placeholder="합계를 입력하세요" id="io_tax_total" path="io_tax_total" /><br/>
			<form:errors path="io_tax_total" class="in-box-error" />
		</div>
		<hr/>
		
		<label class="in-label" for="btn-write"></label>
		<div class='in-box'>
			<button id="btn-write" type="submit">저장</button>
			<button id="btn-return" type="button">뒤로가기</button>
		</div>
	</fieldset>
</form:form>