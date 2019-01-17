<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import= "java.util.*" %>
<%@ page import= "java.text.SimpleDateFormat" %>

<%
    Date date = new Date();
    SimpleDateFormat  sf = new SimpleDateFormat("yyyy년 MM월 dd일");
    String sDate = sf.format(date);
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
    String sClock = sdf.format(date);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>오늘은 <%= sDate %> 입니다.</h3>
<h3>현재시간은 <%= sClock %> 입니다.</h3>
</body>
</html>