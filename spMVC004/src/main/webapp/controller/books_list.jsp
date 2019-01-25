<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<sql:setDataSource var="booksDataSource" 
driver="oracle.jdbc.driver.OracleDriver" 
url="jdbc:oracle:thin:@localhost:1521:xe"
user="mybts" password="1234" />	

<sql:query dataSource="${booksDataSource}" var="booksList">SELECT * FROM tbl_books</sql:query>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서정보 관리</title>
<style>
	header {
		background-color: #00aba9;
		color: #ffff;
	    padding: 10px;
		font-size: 30pt;
		font-weight: bold;
		text-align: center; 
	}
	
	nav {
		width: 100%;
		color: #fff;
		background_color: #00aba9;
		font-weight: normal;
		font-size: 25px;
	}
	
	table {
		border-spacing: 0;
		width: 100%;
		display: table;
		border: 1px solid #ccc;
	}
	
	tr {
		border: 1px solid #ddd;
		text-align: center;
	}
	
	td {
		border: 1px solid #ddd;
	}
	
	th {
		border: 1px solid #ddd;
	}
	
	#button-div {
		border: 1px solid lightgray;
		margin: 30px auto;
		width: 212px;
		font-size: 0px;
	}
	
	#button-div button {
		width: 100px;
		margin: 3px;
	}
	
	footer {
		text-align: center;
		width: 100%;
		background-color: gray;
	}
	
</style>
</head>
<body>
<header>
	<h2>도&nbsp; 서&nbsp; 정&nbsp; 보</h2>
	<nav>
		<a href="#">홈</a>
		<a href="#">도서정보보기</a>
		<a href="#">로그인</a>
		<a href="#">회원가입</a>
		<a href="#">About</a>
	</nav>
</header>
<section>
	<table>
		<tr>
			<th>id</th>
			<th>도서명</th>
			<th>출판사</th>
			<th>저자명</th>
			<th>가  격</th>
		</tr>
		<c:forEach var="row" items="${booksList.rows}">
			<tr>
				<td><a href="#">${row.id}</a></td>
				<td>${row.tb_name}</td>
				<td>${row.tb_comp}</td>
				<td>${row.tb_auth}</td>
				<td>${row.tb_price}</td>
			</tr>
		</c:forEach>
	</table>
	<div id="button-div">
			<button onclick="location.href='/sp004/form/input.jsp'">도서추가</button>
			<button type="button" onclick="confirm('정말 돌아갈까요?')">돌아가기</button>
	</div>
</section>
<footer><address>CopyRight &copy; juhoon12@nate.com</address></footer>
</body>
</html>