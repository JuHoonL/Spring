<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음식 선택</title>
</head>
<body>
<nav>

</nav>
<section>
<table>
	<c:forEach var="KcalVO" items="${List}" varStatus="i">
		<tr>
			<td>${KcalVO.foodName}</td>
			<c:if test="${i.count % 4 == 0}"></tr><tr></c:if>
		</tr>
	</c:forEach>
</table>
</section>

</body>
</html>