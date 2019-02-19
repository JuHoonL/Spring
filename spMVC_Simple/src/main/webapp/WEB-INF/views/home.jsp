<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="calce" method="POST">
	<p>숫자1 :<input type="text" name="intNum1" value="${intNum1}"/>
	<p>숫자2 :<input type="text" name="intNum2" value="${intNum2}"/>
	<p><button>계산</button></p>
	</form>
	
	<hr/>
	<p> 덧셈결과 : ${SUM}
	<p> 뺄셈결과 : ${MINUS}
	<p> 곱셈결과 : ${MULTI}
	<p> 나눗셈결과 : ${DEVIDE}

</body>
</html>