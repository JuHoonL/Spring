<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/* 이 페이지에 head에 view port를 설정하고 
   w3.css를 사용할 수 있도록 link를 설정한다. */


%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/include-head.jspf" %>
</head>
<!-- header의 바탕색을 teal 색으로 설정하고 header를 w3-panel로 설정 글자를 가운데 정렬
	 nav의 바탕색을 blue 색을 설정하고 각 nav 항목을 bar로 설정-->
<body>
	<!-- 여기는 header 영역 -->
	<%@ include file="../include/include-header-teal.jspf" %>
	<!-- 여기는 nav 영역 -->
	<%@ include file="../include/include-nav.jspf" %>
	<section class="w3-border-top w3-border-bottom w3-border-green w3-margin-top">
		<p>w3-border-* : 1px line
		
	</section>
	<section class="w3-topbar w3-bottombar w3-border-green w3-margin-top">
		<p>w3-**bar : 6px line
	</section>
</body>
</html>