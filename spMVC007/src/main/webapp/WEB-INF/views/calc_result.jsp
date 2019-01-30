<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>계산결과</h3>
	<p>"$" 와 "{}"로 묶인 특수한 tag를 EL(Expression Language) tag라고 한다.
	<p>EL tag는 Controller에서 Model객체에 담은 Attribute들과 같은 이름이 있으면
	<p>1대1로 매칭된다. 만약 Model에 같은 이름이 없으면 공백으로 표시된다.
	<p>숫자1 : ${Num1}
	<p>숫자2 : ${Num2}
	<p>합계 : ${SUM}
	<p>오늘날짜 : ${TODAY}
</body>
</html>