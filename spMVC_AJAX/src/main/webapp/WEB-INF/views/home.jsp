<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css">
<style type="text/css">

</style>
</head>
<body>
<header>
	<h1>나라 Plus</h1>
</header>
<nav id="main-menu">
	<a href="#" class="menu-home">홈</a>
	<a href="#" class="menu-home">상품검색</a>
	<a href="#" class="menu-home">About</a>
</nav>
<section>
	<article id="p-List">
		<table>
			<th>NO</th>
			<th>상품코드</th>
			<th>상품이름</th>
			<th>과세여부</th>
			<th>매입단가</th>
			<th>판매단가</th>
			<c:choose>
				<c:when test="${empty PRODUCT}">
					<tr><td>상품리스트가 없습니다.</td></tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${PRODUCT}" var="vo" varStatus="i">
						<tr>
							<td class="table-data">${i.count}</td>
							<td class="table-data">${vo.p_ccode}</td>
							<td class="table-data">${vo.p_cname}</td>
							<td class="table-data">
							<c:if test="${vo.p_vat == '1'}">과세</c:if>
							<c:if test="${vo.p_vat == '2'}">면세</c:if>
							</td>
							<td class="table-data">${vo.p_iprice}</td>
							<td class="table-data">${vo.p_oprice}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</article>
	<article id="s-cart">
	</article>
</section>
<footer><address>CopyRight &copy; juhoon12@nate.com</address></footer>
</body>
</html>