<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>메모장 보기</title>
<link rel="stylesheet" href="/memo02/css/memo_write.css">

</head>
<body>
<header>나의 메모장</header>
	<nav>
		<a href="home" class="nav-home">Home</a>
		<a href="memo_write" class="nav-menu">메모작성</a>
		<a href="#" class="nav-menu">로그인</a>
		<a href="#" class="nav-menu">회원가입</a>
		<a href="#" class="nav-menu">About</a>
	</nav>
<section>
	<form>
		<label for="m_auth" id="for_auth">작성자</label>
		<input type="text" id="m_auth" name="m_auth" 
		placeholder="작성자 이름을 입력하세요" /><br/>
		
		<label for="m_date">작성일자</label>
		<input type="date" id="m_date" name="m_date" /><br/>
		
		<label for="m_subject">제목</label>
		<input type="text" id="m_subject" name="m_subject" 
		placeholder="제목을 입력하세요" /><br/>
		
		<label for="m_text">메모</label>
		<input type="text" id="m_text" name="m_text"
		placeholder="메모 내용을 입력하세요" /><br/>
		
		<button>메모저장</button>
	</form>
</section>

</body>
</html>