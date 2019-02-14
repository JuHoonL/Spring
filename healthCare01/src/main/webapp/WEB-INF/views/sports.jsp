<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sb-admin.css" >
</head>
<body>
<header>
    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="${pageContext.request.contextPath}/">헬스케어프로그램</a>
     <div style ="text-align:right; width:100%;">
    <label style = "color:white;">Id</label> <input type ="text" style = "text-align:right; ">
    <label style = "color:white;">PassWord</label> <input type ="password" style = "text-align:right; ">
     
    
    
    </div>
	<a class="btn btn-link btn-sm text-white ml-auto " style = "width:100px;"
	href="sports" >
	로그인
    </a>
	<a class="btn btn-link btn-sm text-white"  style = "width:100px;"
	href="user_join" >
	회원가입
    </a>

    </nav>
</header>
	<div>
	<c:forEach items="${SLIST}" var="sportsL" >
		<p> ${sportsL}
	</c:forEach>
	</div>
</body>
</html>