<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 브라우저에서 보내온 request 관련 정보는 request(일종의 VO)에 담겨있다.
	 서버에서는 request에서 값을 getter 해서 뭔가를 처리 할 것이다. -->
<p>Remote Address : <%= request.getRemoteAddr() %></p>
<p>Request URI : <%= request.getRequestURI() %></p>
<p>Request Method : <%= request.getMethod() %></p>
<p>Request ETC : <%= request.getLocalName() %></p>
</body>
</html>