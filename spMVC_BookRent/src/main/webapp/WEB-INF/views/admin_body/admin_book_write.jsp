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
			url: "<c:url value='/admin/file_b_delete' />",
			method: "POST",
			data: {book_seq:id},
			success:function(result){
				if(result == 'FAIL'){
					alert("첨부파일 삭제 실패")
					return false
				}
				
				$.ajax({
					url: "<c:url value='/admin/book' />",
					method: "GET",
					data: {book_seq:id},
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
<div id="div-one">
	<input type="hidden" id="book_seq" name="book_seq" placeholder="일련번호" value="<c:out value='${VO.book_seq}' default='0' />" />
	
	<input type="text" id="book_isbn" name="book_isbn" placeholder="ISBN" value="${VO.book_isbn}" />
	
	<input type="text" id="book_title" name="book_title" placeholder="책제목명" value="${VO.book_title}" />
	
	<input type="text" id="book_author" name="book_author" placeholder="책저자명" value="${VO.book_author}" />
	
	<input type="text" id="book_price" name="book_price" placeholder="책가격" value="${VO.book_price}" />
	
	<input type="text" id="book_link" name="book_link" placeholder="책관련링크" value="${VO.book_link}" />
	
	<input type="text" id="book_rent_yn" name="book_rent_yn" placeholder="대여여부(Y/N)" value="${VO.book_rent_yn}" />
</div>
<div id="div-thf">
	<div id="div-th-one">
		<div id="div-text">
			<textarea style="resize:none;" id="book_description" name="book_description" placeholder="책설명" >${VO.book_description}</textarea>
		</div>
	</div>
	<div id="div-th-two">
		<div id="div-file">	
			<input type="file" accept="image/*" id="file" name="b_file" value="${VO.book_image}" />
		</div>
		
		<div id="div-image">	
		<c:if test="${not empty VO.book_image}">
			<img src="<c:url value='/files/${VO.book_image}' />" width="50px" class="image_file" id="image">
			<span class="file_delete" title="사진을 삭제합니다" data-id="${VO.book_seq}">  삭제</span>&nbsp;&nbsp;
		</c:if>
		</div>
		
		<div id="div-button">	
		<button id="btn-save">도서정보 저장</button>
		</div>
	</div>
</div>
</form>
