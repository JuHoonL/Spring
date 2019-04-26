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
		
		location.replace("<c:url value='/admin/user?user_seq=' />" + id)
	})
	
	$(".btn_delete").click(function(){
		var id = $(this).attr("data-Delid")
		var name = $(this).attr("data-Delname")
		
		
		if(confirm( name + "회원을 삭제할까요?")) {
			location.replace("<c:url value='/admin/user_delete?user_seq=' />" + id)
		}
	})
})
</script>
</head>
<body>
<table>
	<tr>
		<th>일련번호</th>
		<th>이름</th>
		<th>생년월일</th>
		<th>성별</th>
		<th>연락처</th>
		<th>메일주소</th>
		<th>사진</th>
		<th>등록일</th>
		<th>탈퇴일</th>
		<th>탈퇴여부</th>
		<th>대여 도서권수</th>
		<th>총 대여금액 합계</th>
		<th></th>
	</tr>
	<c:choose>
		<c:when test="${empty LIST}">
			<tr>
				<td colspan="12" id="empty-tr">회원정보가 없습니다.</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="vo" items="${LIST}">
				<tr>	
					<td>${vo.user_seq}</td>
					<td>${vo.user_name}</td>
					<td>${vo.user_birth}</td>
					<td>${vo.user_sex}</td>
					<td>${vo.user_phone}</td>
					<td>${vo.user_mail}</td>
					<td><img src="<c:url value='/files/${vo.user_image}' />" width="50px" class="image_file"></td>
					<td>${vo.user_reg_date}</td>
					<td>${vo.user_out_date}</td>
					<td>
						<c:if test="${vo.user_out_yn == 'Y'}">탈퇴회원</c:if>
						<c:if test="${vo.user_out_yn == 'N'}">가입회원</c:if>
					</td>
					<td>${vo.user_rent_count}</td>
					<td>${vo.user_rent_total}</td>
					<td>
						<button type="button" class="btn_update" data-Upid="${vo.user_seq}">수정</button>
						<button type="button" class="btn_delete" data-Delid="${vo.user_seq}" data-Delname="${vo.user_name}">삭제</button>
					</td>					
				</tr>	
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
</body>
</html>