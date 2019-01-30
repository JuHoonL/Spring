<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
	#book_field {
		width: 500px;
		margin:10px auto;
	}
	
	legend {
		font-weight: bold;
		font-size: 12pt;
		color:#3E65FF
	}
	
	input {
		margin: 3px;
		padding: 8px;
		border: 1px solid #ccc;
	}
	
	label {
		display: block;
		width: 150px;
		float: left;
		text-align: right;
		font-weight: bold;
		font-size: 10pt;
		padding: 8px;
	}
	
	#btn-box {
		border: 1px solid lightgray;
		width: 103px;
		margin: 5px auto;
	}
	
	#btn-box button {
		width:100px;
		margin:3px;
	}
	
	#btn-ok {
		width:100px;
		margin:3px;
		padding:5px;
	}
</style>
</head>
<body>
	<form action="book" method="POST">
		<fieldset id="book_field">
		<legend>도서입력</legend>
			<label for="b_title">도서명</label>
			<input type="text" id="b_title" name="b_title" /><br/>
			<label for="b_comp">출판사명</label>
			<input type="text" id="b_comp" name="b_comp" /><br/>
			<label for="b_auth">저자</label>
			<input type="text" id="b_auth" name="b_auth" /><br/>
			<label for="b_price">가격</label>
			<input type="text" id="b_price" name="b_price" /><br/>
			
			<label for="btn-ok"></label>
			<button id="btn-ok">확인</button>
		</fieldset>
	</form>

</body>
</html>