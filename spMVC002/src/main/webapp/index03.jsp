<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 JSP 페이지</title>
<style>

	fieldset {
		width: 300px;
	}
	
	legend {
		font-size: 14pt;
		font-weight: bold;
	}
	/*
		lable tag와 input tag를 가로 한줄로 배치하고자 할 때
		
		1. label을 inline 요소에서 block 요소로 변경을 한다.
			display:block
		2. 원하는 넓이 만큼 width 값을 지정한다.
		3. label을 공중에 띄운 후 왼쪽으로 보낸다.
			float:left
	*/ 
	label {
		/* background-color : yellow; */
		display:block;
		float:left;
		width: 100px;
		
		/* text-align : right; 오른쪽 정렬 */
	}
	
	

</style>
</head>
<body>
	<div id="header">
		<h2>나의 JSP 페이지</h2>
		<h4>나의 홈페이지에 오신것을 환영합니다.</h4>
	</div>
	<div id="section">
		<div>
			<form action="/sp002/controller/join.jsp">
				<fieldset>
					<legend>회원가입</legend>				
					<label for="userId">아이디&nbsp;</label>
						<input type="text" id="userId" name="userId" /><br /> 
				
					<label for="password">비밀번호&nbsp;</label>
						<input type="password" id="password" name="password" /><br />
						
					<label for="email">이메일&nbsp;</label>				
						<input type="email" id="email" name="email" /><br /> 
						
					<label for="userName">이름&nbsp;</label>
						<input id="userName" name="userName" /><br /><br />
					
					<hr/>	
					<button>회원가입</button>
					<button type="reset">다시작성</button>
				</fieldset>
			</form>
		</div>
	</div>

</body>
</html>