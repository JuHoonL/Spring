<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	$(".btn_update").click(function(){
		var id = $(this).attr("data-Upid")
		
		location.replace("<c:url value='/admin/book?book_seq=' />" + id)
	})
	
	$(".btn_delete").click(function(){
		var id = $(this).attr("data-Delid")
		var title = $(this).attr("data-Deltitle")
		
		if(confirm( title + "을(를) 삭제할까요?")) {
			location.replace("<c:url value='/admin/book_delete?book_seq=' />" + id)
		}
	})
})
</script>
</head>
<body>
<table>
	<tr>
		<th>일련번호</th>
		<th>ISBN</th>
		<th>제목</th>
		<th>저자</th>
		<th>가격</th>
		<th>설명</th>
		<th>책표지</th>
		<th>관련링크</th>
		<th>대여가능여부</th>
		<th></th>
	</tr>
	<c:choose>
		<c:when test="${empty LIST}">
			<tr><td colspan="9" id="empty-tr">도서정보가 없습니다.</td></tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="vo" items="${LIST}" >
				<tr>
					<td>${vo.book_seq}</td>
					<td>${vo.book_isbn}</td>
					<td>${vo.book_title}</td>
					<td>${vo.book_author}</td>
					<td>${vo.book_price}</td>
					<td>${vo.book_description}</td>
					<td><img src="<c:url value='/files/${vo.book_image}' />" width="50px" class="image_file"></td>
					<td>${vo.book_link}</td>
					<td>
						<c:if test="${vo.book_rent_yn == 'Y'}">대여가능</c:if>
						<c:if test="${vo.book_rent_yn == 'N'}">대여불가</c:if>
					</td>
					<td>
						<button type="button" class="btn_update" data-Upid="${vo.book_seq}">수정</button>
						<button type="button" class="btn_delete" data-Delid="${vo.book_seq}" data-Deltitle="${vo.book_title}">삭제</button>
					</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
</body>
</html>