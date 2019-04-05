<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<style>
	fieldset{
		width:50%;
		margin:20px auto; /* 가로방향 중앙정렬 */
	}
	
	legend {
		font-size:12pt;
		font-weight: bold;
		color : #3d65ff;
	}
	
	.in-label {
		display: inline-block;
		width:20%;
		
		float:left;
		text-align: right;
		margin-right: 5px;
		padding:8px;
	}
	
	.in-box {
		padding-top: 2px;
		margin:3px;
		display: inline-block;
		width:70%;
	}
	
	.in-box2 {
		width: 100%;
		height: 30px;
	}
	
	.in-box2:hover {
		background-color: #ddd;
		border:1px solid blue;
	}
	
	input:invalid {
		background-color: #ffdddd;
		border:2px solid red;
	}
	
	/* span 설정 */
	#userid_error {
		width:70%;
		color:red;
		font-weight: bold;
	}
	
	.userid_label {
		display: none;
	}
	
	.in-box-error {
		color: red;
		font-size: 10pt;
	}
</style>
<script>
$(function(){
/*	$.ajax({
			
		url : "<c:url value='id_check' />",
		method:"POST",
		data : {m_userid:userid},
		success:function(result) {
			$("#userid_error").html(result)
			$(".userid_label").css("display","inline-block")
		},
		error:function(){
			alert("서버오류")
		}
	})*/
})

</script>	
<%/*
	form:form의 modelAttribute속성 : Controller와 view(*.jsp)파일간의 VO객체에 담긴 데이터를 쉽게 교환하기 위한 통로로
									설정하는 항목으로 command라는 속성으로도 사용되고 form tag에서는 필수 항목이다.
	
	method는 HTML tag에서는 기본값이 GET이나 form:form에서는 기본값이 POST이다
*/%>
<form:form action="${rootPath}/member/join1" method="POST" modelAttribute="memberVO" autocomplete="off">
	<fieldset>
		<c:if test="${empty LOGIN_INFO}">
			<legend>회원가입</legend>
		</c:if>
		<c:if test="${not empty LOGIN_INFO}">
			<legend>회원정보</legend>
		</c:if>
		
		<form:label class="in-label" path="m_userid">회원ID</form:label>
		<div class='in-box'>
			<form:input class='in-box2' placeholder="회원ID를 입력하세요" id="m_userid" path="m_userid" /><br/>
			<form:errors path="m_userid" class="in-box-error" />
		</div>
		<%/*
			form:input taglib의 input box는 HTML과 사용법이 다름
			
			HTML의 name부분은 taglib에서는 path로 대체사용 (반드시 modelAttribute의 멤버변수와 같이 설정)
			HTML의 required는 taglib에서는 required = 'required'로 대체사용
		*/%>
		
		<label class="in-label" for="m_password">비밀번호</label>
		<div class='in-box'>
			<form:password class="in-box2" id="m_password" path="m_password" /><br/>
			<form:errors path="m_password" class="in-box-error" />
		</div>
				
		<label  class="in-label" for="m_re_password">비밀번호확인</label>
		<div class='in-box'>
			<form:password class="in-box2" id="m_re_password" path="m_re_password" /><br/>
			<form:errors path="m_re_password" class="in-box-error" />
		</div>
		
		<label class="in-label" for="m_name">이름</label>
		<div class='in-box'>
			<form:input class="in-box2" id="m_name" path="m_name" /><br/>
			<form:errors path="m_name" class="in-box-error" />
		</div>
		
		<label class="in-label" for="m_addr">주소</label>
		<div class='in-box'>
			<form:input class="in-box2" id="m_addr" path="m_addr" /><br/>
		</div>
		
		<label class="in-label" for="m_tel">전화번호</label>
		<div class='in-box'>
			<form:input class="in-box2" id="m_tel" path="m_tel" /><br/>
			<form:errors path="m_tel" class="in-box-error" />
		</div>
		
		<label class="in-label" for="btn-join"></label>
		<div class='in-box'>
			<c:if test="${empty LOGIN_INFO}">
				<button id="btn-join" type="submit">회원가입</button>
			</c:if>
			<c:if test="${not empty LOGIN_INFO}">
				<button id="btn-join" type="submit">정보수정</button>
			</c:if>
		</div>
	</fieldset>
</form:form>