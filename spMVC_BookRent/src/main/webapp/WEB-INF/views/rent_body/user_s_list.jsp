<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
.b_select {
	cursor: pointer;
}
</style>
<script>
$(function(){
	$(".b_select").on("click",function() {
		let user_seq = $(this).attr("data-seq")
		let user_name = $(this).attr("data-name")
		
		$("#user_seq").val(user_seq)
		$("#user_name").text(user_name)
	})
})
</script>
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
	</tr>
	<c:choose>
		<c:when test="${empty LIST}">
			<tr>
				<td colspan="12" id="empty-tr">회원정보가 없습니다.</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="vo" items="${LIST}">
				<tr class="b_select" data-seq="${vo.user_seq}" data-name="${vo.user_name}">	
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
				</tr>	
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>