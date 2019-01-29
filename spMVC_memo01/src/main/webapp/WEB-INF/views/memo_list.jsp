<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-head.jspf" %>
<script>
function memo_click() {
	var memo_row = document.getElementsByClassName("memoRow")
	var memo_id = memo_row[0].dataset.memoId
	alert("선택한 메모의 ID는 " + memo_id + "입니다.")
}
</script>
</head>
<body>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<%@ include file="/WEB-INF/include/include-nav.jspf" %>
<section class="w3-border w3-margin-top w3-margin-bottom">
	<table class="w3-table-all">
		<tr>
			<th>NO</th>
			<th>작성자</th>
			<th>제목</th>
		</tr>
		<c:choose>
			<c:when test="${empty memoList}">
				<tr><td colspan="3">메모가 없습니다</td></tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="memo" items="${memoList}" varStatus="row">
					<tr class="w3-hover-light-gray memoRow" data-memo-id="${memo.id}" onclick="memo_click()">
						<td>${row.index}, ${row.count}</td>
						<td>${memo.m_auth}</td>
						<td>${memo.m_subject}</td>
					</tr>	
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	
</section>
<%@ include file="/WEB-INF/include/include-footer.jspf" %>	
</body>
</html>