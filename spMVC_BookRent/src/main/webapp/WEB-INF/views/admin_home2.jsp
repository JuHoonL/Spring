<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>책나라 관리자 화면</title>
<link rel="stylesheet" href="${rootPath}/css/table.css?ver=1" />
<style type="text/css">

body,html {

}

section {
	display: flex;
	flex-flow: column;
	height: 100%;
}

#admin-title {
	height: 70px;
	background-color: blue;
	color: white;
	text-align: center;
}

article {
	flex: 1;
}

#admin-body {
	display: flex;
	border: 1px solid blue; 
}

#admin-body aside {
	width: 300px;
	background-color: green;
	color: white;
}

/*
#admin-body article {
	flex-basis: 3;
}
*/

#admin-body ul {
	width: 300px;
	padding: 0;
	text-align: center;
}

#admin-body li {
	list-style: none;
	
}

#admin-body a {
	color: white;
	text-decoration: none;
	display: block;
	padding: 5% 5%;
	font-size: 20px;
}

#admin-body a:hover {
	background-color: #ddd;
	color: black;
}
</style>
</head>
<body>
<section>
	<article id="admin-title">
		<h3>책나라 관리자</h3>
	</article>
	<article id="admin-body">
		<aside>
			<ul>
				<li><a href="${rootPath}/">Home</a></li>
				<li><a href="${rootPath}/admin/user">회원관리</a></li>
				<li><a href="${rootPath}/admin/book">도서관리</a></li>
				<li><a href="${rootPath}/admin/rent">대여관리</a></li>
			</ul>
		</aside>
		<article>
			<c:choose>
				<c:when test="${BODY == 'USER_LIST'}">
				<h3>회원정보 관리</h3>
				<div>
					<%@ include file="/WEB-INF/views/admin_body/admin_user_write.jsp" %>
				</div>
				<div>
					<%@ include file="/WEB-INF/views/admin_body/admin_user_list.jsp" %>
				</div>
				</c:when>
				<c:when test="${BODY == 'BOOK_LIST'}">
					<%@ include file="/WEB-INF/views/admin_body/admin_book_list.jsp" %>
				</c:when>
				<c:when test="${BODY == 'RENT_LIST'}">
					<%@ include file="/WEB-INF/views/admin_body/admin_rent_list.jsp" %>
				</c:when>
				<c:otherwise>
					<h3>아직 구현 XXXXXXXXXX</h3>
				</c:otherwise>
			</c:choose>
		</article>
	</article>
</section>
</body>
</html>