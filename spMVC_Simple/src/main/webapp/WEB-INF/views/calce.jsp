<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="VO" value="${CALC}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="calce-vo" method="POST">
	<p>숫자1 :<input type="text" name="intNum1" value="${VO.intNum1}"/>
	<p>숫자2 :<input type="text" name="intNum2" value="${VO.intNum2}"/>
	<p><button>계산</button></p>
	</form>
	
	<hr/>
	<p> 덧셈결과 : ${VO.intAdd}
	<p> 뺄셈결과 : ${VO.intMinus}
	<p> 곱셈결과 : ${VO.intMulti}
	<p> 나눗셈결과 : ${VO.intDevide}

</body>
</html>