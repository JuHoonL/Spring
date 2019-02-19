<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach items="${LIST}" var="inoutVO" >
		<p>${inoutVO.io_date}/${inoutVO.io_time}/${inoutVO.io_cname}/${inoutVO.io_check}/${inoutVO.io_price}/${inoutVO.io_su}
	</c:forEach>
</body>
</html>