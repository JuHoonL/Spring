<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<sql:setDataSource var="booksDataSource" 
driver="oracle.jdbc.driver.OracleDriver" 
url="jdbc:oracle:thin:@localhost:1521:xe"
user="mybts" password="1234" />	

<sql:query dataSource="${booksDataSource}" var="booksList">SELECT * FROM tbl_books where id =?
<sql:param value="${param.id}"/>
</sql:query>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	fieldset {
		width: 550px;
		margin: 0 auto;
	}

	legend {
		text-align: center;
		font-size: 20px;
		font-weight: bold;
	}
	
	label {
		display: block;
		width: 160px;
		float: left;
		text-align: right;
		font-size: 10pt;
		font-weight: bold;
		padding: 8px;
		margin: 2px;
	}
	
	input {
		margin: 3px;
		padding: 8px;
		border: 1px solid 
	}
	
	#button-div {
		border: 1px solid lightgray;
		margin: 0 auto;
		width: 212px;
		font-size: 0;
		}
		
	#button-div button {
		margin: 3px;
		width: 100px;
		}
</style>
</head>
<body>
<header>도서정보입력</header>
<section>
	<form action="#">
		<fieldset>
			<legend>정보입력</legend>
			<label for="tb_name">도서명</label>&nbsp;
			<input type="text" id="tb_name" name="tb_name" value="${booksList.rows[0].tb_name}"/><br />
			
			<label for="tb_comp">출판사</label>&nbsp;
			<input type="text" id="tb_comp" name="tb_comp" value="${booksList.rows[0].tb_comp}"/><br />
			
			<label for="tb_auth">저자명</label>&nbsp;
			<input type="text" id="tb_auth" name="tb_auth" value="${booksList.rows[0].tb_auth}"/><br />
			
			<label for="tb_price">가  격</label>&nbsp;
			<input type="text" id="tb_price" name="tb_price" value="${booksList.rows[0].tb_price}"/><br />
			<div id="button-div">
				<button>도서등록</button>
				<button type="reset">다시작성</button>
			</div>
		</fieldset>
	</form>
</section>


</body>
</html>