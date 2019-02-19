<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="VO" value="${CALC}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function() {
	$("#btn-send").click(function(){
		var num1 = $("#intNum1").val();
		var num2 = $("#intNum2").val();
		
		// Ajax를 사용해서 controller에게 두 값을 보내겠다.
		$.ajax({
			/* 중괄호 안에 : 이 있는 경우 JSON형 */
			url : "${pageContext.request.contextPath}/add-ajax",
			method : "POST",
			data : {intNum1 : num1, intNum2 : num2},
			//span tag의 id c-add인 곳에 표시
			success : function(result) {  
				$("#c-add").text(result)
			},
			error : function(xhr,status,err) {
				alert(status)
			}
		})
		
		
	})
})
</script>
</head>
<body>

	<form action="calc-ajax" method="POST">
	<p>숫자1 :<input type="text" id="intNum1" name="intNum1" value="${VO.intNum1}"/>
	<p>숫자2 :<input type="text" id="intNum2" name="intNum2" value="${VO.intNum2}"/>
	<p><button id="btn-send" type="button">계산</button></p>
	</form>
	
	<hr/>
	<p> 덧셈결과 : <span id="c-add">0</span></p>
	<p> 뺄셈결과 : <span id="c-minus">0</span></p>
	<p> 곱셈결과 : <span id="c-multi">0</span></p>
	<p> 나눗셈결과 : <span id="c-devide">0</span></p>

</body>
</html>