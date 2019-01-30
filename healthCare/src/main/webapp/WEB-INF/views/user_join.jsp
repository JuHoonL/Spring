<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<section>
		<form action="health_user_join" method="POST">
		<div class="w3-border">
			<label for="id">ID</label>
			<input type="text" id="id" name="id"
			placeholder="아이디를 입력하세요" class="w3-input w3-border w3-hover-gray">
		
			<label for="userName">이름</label>
			<input type="text" id="userName" name="userName"
			placeholder="이름을 입력하세요" class="w3-input w3-border w3-hover-gray">
			
			<label for="password">비밀번호</label>
			<input type="password" id="password" name="password"
			placeholder="비밀번호를 입력하세요" class="w3-input w3-border w3-hover-gray">
			
			<label for="birth">생년월일</label>
			<input type="date" id="birth" name="birth" class="w3-input w3-border w3-hover-gray">
			
			<label for="height">키</label>
			<input type="text" id="height" name="height"
			placeholder="본인의 키를 입력하세요" class="w3-input w3-border w3-hover-gray">
			
			<label for="weight">몸무게</label>
			<input type="text" id="weight" name="weight"
			placeholder="본인의 몸무게를 입력하세요" class="w3-input w3-border w3-hover-gray">
			
			<label for="activityindex">활동지수</label>
			<select id="activityindex"  name="activityindex">
				<option value="31">평소 운동량이 적은 사람</option>
				<option value="33">하루 한시간 운동하는 사람</option>
				<option value="35">하루 두세시간 운동하는 사람</option>
				<option value="40">힘든 육체노동을 하는 사람</option>
				<option value="43">전문 운동선수</option>
			</select><br />
					<button>회원 가입</button>
					<button type="reset">다시작성</button>
		</div>
		</form>
	</section>

</body>
</html>