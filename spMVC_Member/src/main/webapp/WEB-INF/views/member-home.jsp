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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="<c:url value='/css/member-home.css' />">
</head>
<body>
<header>
	<h2>회원가입</h2>
</header>
<section>
	<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>
	<article id="pre-list">
		<c:if test="${BODY == 'JOIN-FORM'}" >
			<%@ include file="/WEB-INF/views/include/join.jsp" %>
		</c:if>
		<c:if test="${BODY == 'LOGIN-FORM'}" >
			<%@ include file="/WEB-INF/views/include/login-form.jspf" %>
		</c:if>
		<c:if test="${empty BODY}">
			<P>상품리스트 표시 영역
		</c:if>
	</article>
</section>
<footer><address>CopyRight &copy; juhoon12@nate.com</address></footer>

</body>
</html>