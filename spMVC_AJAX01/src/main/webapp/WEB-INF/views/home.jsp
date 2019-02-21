<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/css/home.css' />">
</head>
<body>
<header class="main-header"><h2>나라 Plus</h2></header>
<section class="content-container">
	<aside class="side-bar">
		side-bar
	</aside>
	<article class="section-atc">
		<div class="section-header">
			<p>section header</p>
		</div>
		<div class="section-div">
			<div class="div-div sub1">
				<table class="div-table">
				<tr>
					<th>회사코드</th>
					<th>회사이름</th>
					<th>대표자명</th>
				</tr>
				<c:forEach items="${LIST}" var="vo" varStatus="i">
					<tr>
						<th>${vo.d_code}</th>
						<th>${vo.d_name}</th>
						<th>${vo.d_ceo}</th>
					</tr>
				</c:forEach>
			</table>
			</div>
			<div class="div-div sub2">
				<p>flex-box2</p>
			</div>
		</div>
	</article>
</section>
<footer><address>CopyRight &copy; juhoon12@nate.com</address></footer>

</body>
</html>