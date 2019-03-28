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
		
		if(!confirm("메일을 삭제 할까요")) {
			 return false;
		}
		
		$.ajax({
			url : "<c:url value='/delete' />",
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
<section id="form-section">
	<form enctype="multipart/form-data" action=<c:url value="update"/> method="POST">
	
		<input type="hidden" id="id" name="id" value=<c:out value="${EMAIL.id}" default="0" />  >
		<label for="from_email">발송email</label>
		<input 
			type="text"  
			value="${EMAIL.from_email}" <c:if test="${LOGIN_INFO.m_userid != 'juhoon12' }" >readonly</c:if>
			id="from_email" 
			name="from_email"><br/>

		<label for="to_email">받는email</label>
		<input 
			type="text"  
			value="${EMAIL.to_email}" id="to_email" name="to_email"><br/>
		
		<label for="s_date">발송일자</label>
		<input value="${EMAIL.s_date}" type="date" <c:if test="${LOGIN_INFO.m_userid != 'juhoon12' }" >readonly</c:if>
		id="s_date" name="s_date"><br/>
		
		<label for="s_time">발송시각</label>
		<input value="${EMAIL.s_time}" type="text"  <c:if test="${LOGIN_INFO.m_userid != 'juhoon12' }" >readonly</c:if> 
		id="s_time" name="s_time"><br/>
		
		<label for="s_subject">메일제목</label>
		<input value="${EMAIL.s_subject}" type="text" id="s_subject" name="s_subject"><br/>
		
		<label for="s_content">메일내용</label>
		<input value="${EMAIL.s_content}" type="text" id="s_content" name="s_content"><br/>
		
		<label for="s_file1">첨부파일1</label>
		<input value="${EMAIL.s_file1}" type="file" id="s_file1" name="s_file1"><br/>
		
		<label for="s_file2">첨부파일2</label>
		<input value="${EMAIL.s_file2}" type="file" id="s_file2" name="s_file2"><br/>
		
		<hr />
		<label></label>
		<button type="button" id="btn-update">수정</button>
		<button type="button" id="btn-delete">삭제</button>
	</form>
</section>