<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/css/home.css' />">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<c:if test="${BODY=='DEPT'}" >
	<%@ include file="/WEB-INF/views/body/dept-main.jspf" %>
</c:if>
</head>
<body>
<header class="main-header"><h2>나라 Plus</h2></header>
<section class="content-container">
	<aside class="side-bar">
		<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>
	</aside>
	<article class="section-atc">
		<div class="section-header">
			<h4>거래처 검색</h4>
		</div>
		<div class="section-div">
			<div class="div-div sub1">
				<div>
					<c:if test="${BODY=='DEPT'}">
					<form>
						<input type="text" id="dsearch" name="dsearch" placeholder="거래처이름을 입력 후 Enter" />
					</form>		
					</c:if>			
				</div>
				<p id="main-list"></p>
			</div>
			<div class="div-div sub2">
				<c:if test="${BODY == 'DEPT'}" >
					<%@ include file="/WEB-INF/views/body/DeptForm.jsp" %>
				</c:if>
				<p id="d-list"></p>
			</div>
		</div>
	</article>
</section>
<footer><address>CopyRight &copy; juhoon12@nate.com</address></footer>

</body>
</html>