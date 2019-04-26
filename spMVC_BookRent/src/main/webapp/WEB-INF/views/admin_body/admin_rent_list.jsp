<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>일련번호</th>
		<th>대출일</th>
		<th>반납예정일</th>
		<th>도서일련번호</th>
		<th>회원일련번호</th>
		<th>도서반납여부</th>
	</tr>
	<c:choose>
		<c:when test="${empty LIST}">
			<tr><td colspan="6" id="empty-tr">대여정보가 없습니다.</td></tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="vo" items="${LIST}" >
				<tr>
					<td>${vo.rent_seq}</td>
					<td>${vo.rent_date}</td>
					<td>${vo.rent_return_date}</td>
					<td>${vo.rent_book_seq}</td>
					<td>${vo.rent_user_seq}</td>
					<td>${vo.rent_return_yn}</td>
					<td>
						<c:if test="${vo.rent_return_yn == 'Y'}">도서반납</c:if>
						<c:if test="${vo.rent_return_yn == 'N'}">도서미반납</c:if>
					</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
</body>
</html>