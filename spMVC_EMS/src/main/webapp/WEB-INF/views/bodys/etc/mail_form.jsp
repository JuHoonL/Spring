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
		width: 150px;
		height: 30px;
	}
	
	#btn-delete {
		width: 150px;
		height: 30px;
	}
	
	.file_delete {
		cursor: pointer;
		
		display: inline-block;
		width: 50px;
		background-color: orange;
		color: white;
		text-align: center;
		border-radius: 6px;
		padding: 5px 0 ;
		margin-left: 10px;
	}
	
	.file_delete:hover {
		background-color: red;
	}
	
	.image_file {
		/* width나 height로 설정된 상태 그대로 유지 */ 
		transform: scale(1); 
		-webkit-transform: scale(1); /* 크롬구버젼 */
		-moz-transform: scale(1); /* 파이어폭스 */
		-ms-transform: scale(1); /* ie */
		-o-transform: scale(1); /* opera */
		
		/* transition은 효과가 부드럽게 연출됌 */
		/* ease-in-out : 보간법이라는 scale 변화 규칙에 따라 크기를 변화 */
		transition: all 0.3s ease-in-out; 
		-webkit-transition: all 0.3s ease-in-out; /* 크롬구버젼 */
		-moz-transition: all 0.3s ease-in-out; /* 파이어폭스 */
		-ms-transition: all 0.3s ease-in-out; /* ie */
		-o-transition: all 0.3s ease-in-out; /* opera */
	}
	
	.image_file:hover {
		/* 가로세로 3배로 확대 */
		transform: scale(3); 
		-webkit-transform: scale(3); /* 크롬구버젼 */
		-moz-transform: scale(3); /* 파이어폭스 */
		-ms-transform: scale(3); /* ie */
		-o-transform: scale(3); /* opera */ 
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	$("#btn-update").click(function(){
		$("form").submit()
	})
	
	$(".file_delete").click(function(){
			
			let id = ${EMAIL.id}
			let oneNtwo = $(".image_file").attr("data-oneNtwo")
									
			if(!confirm("첨부 파일을 삭제할까요?")) {
				return false
			}
			
			$.ajax({
				url: "<c:url value='/file_delete' />",
				method: "GET",
				data: {id:id,oneNtwo:oneNtwo},
				success:function(result){
					$("#body").html(result)
				},
				error:function(){
					alert("서버와 통신 오류")
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
		<input value="${EMAIL.s_time}" type="text" <c:if test="${LOGIN_INFO.m_userid != 'juhoon12' }" >readonly</c:if> 
		id="s_time" name="s_time"><br/>
		
		<label for="s_subject">메일제목</label>
		<input value="${EMAIL.s_subject}" type="text" id="s_subject" name="s_subject"><br/>
		
		<label for="s_content">메일내용</label>
		<textarea value="${EMAIL.s_content}" type="text" id="s_content" name="s_content" cols="5"></textarea><br/>
		
		<label for="s_file1">첨부파일1</label>
		<input type="hidden" name="s_file1" value="${EMAIL.s_file1}"/>
		<input type="file" id="s_file1" name="file1"><br/>
		<c:if test="${not empty EMAIL.s_file1}">
			<div>
				<label></label>
				<p>
					<a href="<c:url value='/files/${EMAIL.s_file1}' />" target="_new" >
					<img src="<c:url value='/files/${EMAIL.s_file1}' />" width="50px" class="image_file" data-oneNtwo="one">
					</a>	
						${EMAIL.s_file1}
					<span class="file_delete" title="첨부파일1의 파일을 삭제합니다">  삭제</span>&nbsp;&nbsp;
			
			</div>
		</c:if>
		<hr />
		
		<label for="s_file2">첨부파일2</label>
		<input type="hidden" name="s_file2" value="${EMAIL.s_file2}"/>
		<input value="${EMAIL.s_file2}" type="file" id="s_file2" name="file2"><br/>
		<c:if test="${not empty EMAIL.s_file2}">
			<div>
				<label></label>
				<p>
					<a href="<c:url value='/files/${EMAIL.s_file2}' />" target="_new">
					<img src="<c:url value='/files/${EMAIL.s_file2}' />" width="50px" class="image_file"  data-oneNtwo="two">
					</a>	
						${EMAIL.s_file2}
					<span class="file_delete" title="첨부파일1의 파일을 삭제합니다">  삭제</span>&nbsp;&nbsp;
			
			</div>
		</c:if>
		
		<hr />
		<label></label>
		<button type="button" id="btn-update">수정</button>
	</form>
</section>