<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="<c:url value='/css/mail_form.css' />" />
<style>
	#div-button {
		width: 150px;
		height: 30px;;
		float: right;
		margin-top: 20px;
	}
	
	#btn-insert {
		width: 150px;
		height: 30px;
	}
	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	$("#btn-send").click(function(){
		let form = $("form").serialize()
		
		alert(form)
		
		$.ajax ({
			url:"<c:url value='/e_send' />",
			method:"POST",
			dataType:"JSON",
			data:form,
			success:function(result){
				alert(result)
				location.replace("<c:url value='/' />")
			},
			error:function(){
				alert("메일전송실패")
			}
		})
	})
})
	
</script>
<section id="form-section">
	<form enctype="multipart/form-data" action=<c:url value="insert"/> method="POST">
	
		<input type="hidden" id="id" name="id" value=<c:out value="${EMAIL.id}" default="0" />  >
		<label for="from_email">발송email</label>
		<input 
			type="text"  
			value="${LOGIN_INFO.m_mailaddress}" <c:if test="${LOGIN_INFO.m_userid != 'juhoon12' }" >readonly</c:if>
			id="from_email" 
			name="from_email"><br/>

		<label for="to_email">받는email</label>
		<input type="text" id="to_email" name="to_email"><br/>
		
		<label for="s_date">발송일자</label>
		<input value="${EMAIL.s_date}" type="date" <c:if test="${LOGIN_INFO.m_userid != 'juhoon12' }" >readonly</c:if>
		id="s_date" name="s_date"><br/>
		
		<label for="s_time">발송시각</label>
		<input value="${EMAIL.s_time}" type="text"  <c:if test="${LOGIN_INFO.m_userid != 'juhoon12' }" >readonly</c:if> 
		id="s_time" name="s_time"><br/>
		
		<label for="s_subject">메일제목</label>
		<input type="text" id="s_subject" name="s_subject"><br/>
		
		<label for="s_content">메일내용</label>
		<textarea type="text" id="s_content" name="s_content" cols="5"></textarea><br/>
		
		<hr />
		<label></label>
		<button type="submit" id="btn-insert">메일 보내기</button>
	</form>
</section>