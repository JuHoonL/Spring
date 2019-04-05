<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	.view-box {
		width: 60%;
		border: 1px solid blue;
		margin: 20px auto;
		padding-left: 20px;
	}
	
	.view-box h3, .view-box h5 {
		text-align: center;
	}
</style>
<article class="view-box">
	<h3>매입매출 정보 관리 v 1.0</h3>
	<h5>Since : 2019년 04월 03일</h5>
	<p><b>서버명 : </b><span>${pageContext.request.serverName}</span>
	<p><b>포트번호 : </b><span>${pageContext.request.serverPort}</span>
	<p><b>method : </b><span>${pageContext.request.method}</span>
	<p><b>Context Path : </b><span>${pageContext.request.contextPath}</span>
	<p><b>Path 정보 : </b><span>${pageContext.request.pathInfo}</span>
	<p><b>Path Translate : </b><span>${pageContext.request.pathTranslated}</span>
	<p><b>Query String : </b><span>${pageContext.request.queryString}</span>
	<p><b>Request uri : </b><span>${pageContext.request.requestURI}</span>
	<p><b>Request url : </b><span>${pageContext.request.requestURL}</span>
</article>