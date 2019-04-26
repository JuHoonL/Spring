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
		let isbn = $(this).attr("data-isbn")
		let title = $(this).attr("data-text")
		
		$("#book_isbn").val(isbn)
		$("#book_title").text(title)
	})
})
</script>
<table>
	<tr>
		<th>도서명</th>
		<th>저자</th>
		<th>가격</th>
		<th>대여</th>
	</tr>
	<c:choose>
		<c:when test="${empty BOOKS}">
			<tr><td colspan=4>도서목록 없음</td></tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="book" items="${BOOKS}">
				<tr class="b_select" data-isbn="${book.book_isbn}" data-text="${book.book_title}">
					<td>${book.book_title}</td>
					<td>${book.book_author}</td>
					<td>${book.book_price}</td>
					<td>
						<c:if test="${book.book_rent_yn == 'Y'}">
							대여가능
						</c:if>
						<c:if test="${book.book_rent_yn == 'N'}">
							대여불가
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>