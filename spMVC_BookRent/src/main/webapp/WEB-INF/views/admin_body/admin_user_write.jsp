<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	$(".file_delete").click(function(){
		
		let id = $(this).attr("data-id")
		
		if(id == 0) {
			alert("삭제할 그림이 없습니다")
			return false
		}
		
		if(!confirm("첨부 파일을 삭제할까요?")) {
			return false
		}
		
		$.ajax({
			url: "<c:url value='/admin/file_u_delete' />",
			method: "POST",
			data: {user_seq:id},
			success:function(result){
				if(result == 'FAIL'){
					alert("첨부파일 삭제 실패")
					return false
				}
				
				$.ajax({
					url: "<c:url value='/admin/user' />",
					method: "GET",
					data: {user_seq:id},
					success:function(result){
						$("#body").html(result)
					},
					error:function(){
						
					}
				})
			},
			error:function(){
				alert("서버와 통신 오류")
			}
		})
	})
})
</script>
<form method="POST" enctype="multipart/form-data">
<div id="div-onef">
	<input type="hidden" id="user_seq" name="user_seq" value="<c:out value='${VO.user_seq}' default='0' />" />
	
	<input type="text" id="user_name" name="user_name" placeholder="이름" value="${VO.user_name}" />
	
	<input type="text" id="user_birth" name="user_birth" placeholder="생년월일" value="${VO.user_birth}" />
	
	<input type="text" id="user_sex" name="user_sex" placeholder="성별(M/F)" value="${VO.user_sex}" />
	
	<input type="text" id="user_phone" name="user_phone" placeholder="전화번호" value="${VO.user_phone}" />
	
	<input type="text" id="user_mail" name="user_mail" placeholder="E-mail" value="${VO.user_mail}" />
</div>
<div id="div-twof">
	<input type="text" id="user_reg_date" name="user_reg_date" placeholder="가입일" value="${VO.user_reg_date}" />
	
	<input type="text" id="user_out_date" name="user_out_date" placeholder="탈퇴일" value="${VO.user_out_date}" />
	
	<input type="text" id="user_out_yn" name="user_out_yn" placeholder="탈퇴여부(Y/N)" value="${VO.user_out_yn}" />
	
	<input type="text" id="user_rent_count" name="user_rent_count" placeholder="총 대여회수" value="${VO.user_rent_count}" />
	
	<input type="text" id="user_rent_total" name="user_rent_total" placeholder="총 대여금액" value="${VO.user_rent_total}" />
</div>
<div id="div-thf">		
	<div id="div-file">	
	<input type="file" accept="image/*" id="file" name="u_file" />
	</div>
	<div id="div-image">	
	<c:if test="${not empty VO.user_image}">
		<img src="<c:url value='/files/${VO.user_image}' />" width="50px" class="image_file">
		<span class="file_delete" title="사진을 삭제합니다" data-id="${VO.user_seq}">  삭제</span>&nbsp;&nbsp;
	</c:if>
	</div>
	<div id="div-button">	
	<button id="btn-save">회원정보 저장</button>
	</div>
</div>
</form>
