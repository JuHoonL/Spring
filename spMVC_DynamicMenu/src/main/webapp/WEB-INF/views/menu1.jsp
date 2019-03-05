<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/css/menu.css' />">
</head>
<body>
<nav>
<ul>
	<c:if test="${not empty MENUS}" >
		<c:forEach var="menu" items="${MENUS}" varStatus="index">
			<li><a href="<c:url value='${menu.menu_href}' />">${menu.menu_title}</a></li>
		</c:forEach>
	</c:if>
</ul>
</nav>
</body>
</html>