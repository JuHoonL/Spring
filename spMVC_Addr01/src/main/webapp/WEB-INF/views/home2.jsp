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
<form action="addr" method="POST">
	<label>이름</label>
	<input type="text" value="${ADDR.a_name}" id="a_name" name="a_name" /><br/>
	
	<label>전화번호</label>
	<input type="text" value="${ADDR.a_tel}" id="a_tel" name="a_tel" /><br/>
	
	<label>시/도</label>
	<select id="a_city" name="a_city">
		<option value="SEOUL" <c:if test="${ADDR.a_city == 'SEOUL'}">SELECTED</c:if>>서울</option>
		<option value="INCEON" <c:if test="${ADDR.a_city == 'INCEON'}">SELECTED</c:if>>인천</option>
		<option value="DAEJEON" <c:if test="${ADDR.a_city == 'DAEJEON'}">SELECTED</c:if>>대전</option>
		<option value="GWANGJU" <c:if test="${ADDR.a_city == 'GWANGJU'}">SELECTED</c:if>>광주</option>
		<option value="BUSAN" <c:if test="${ADDR.a_city == 'BUSAN'}">SELECTED</c:if>>부산</option>
	</select><br/>
	
	<button>전송</button>
</form>
</body>
</html>