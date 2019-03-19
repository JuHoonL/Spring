<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>id : ${LOGIN_INFO.m_userid}
<p>password : ${LOGIN_INFO.m_password}
<p>name : ${LOGIN_INFO.m_name}
<p>addr : ${LOGIN_INFO.m_addr}
<p>tel : ${LOGIN_INFO.m_tel}

<a href="<c:url value='/logout' />">로그아웃</a>
</body>
</html>