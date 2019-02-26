<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
$(function(){
	$("#btn-join").click(function(){
		let m_userid = $("#m_userid").val()
		let m_password = $("#m_password").val()
		let m_re_password = $("#m_re_password").val()
		
		if(m_userid=="") {
			alert("id(email)을 반드시 입력하세요")
			$("#m_userid").focus()
			return false;
		}
		
		if(m_password=="") {
			alert("비밀번호를 반드시 입력하세요")
			$("#m_password").focus()
			return false;
		}
		
		if(m_re_password=="") {
			alert("비밀번호를 한번 더 입력하세요")
			$("#m_re_password").focus()
			return false;
		}
		
		if(m_password!=m_re_password) {
			alert("비밀번호가 다릅니다.")
			$("#m_password").val("")
			$("#m_re_password").val("")
			$("#m_password").focus()
			return false;
		}
		
		$("form").submit()
	})
	
	// id를 입력하고 다른항목으로 넘어갔을 때 실행 될 함수
	$("#m_userid").focusout(function(event){
		
		
		let userid = $("#m_userid").val()
		
		if(userid=="") {
			alert("ID를 입력하세요")
			return false;
		}
		
		$.ajax({
			url:"<c:url value='id-check' />",
			method:"POST",
			data: {m_userid:userid},
			success:function(result){
				alert(result)
			},
			error:function(){
				alert("오류 발생!!")
			}
		})
		
	})
	
})
</script>
<style>
	#form-join {
		width: 50%;
		margin: 20px auto;
		padding: 10px;
		height: 50%;
	}
	
	label, input {
		margin: 5px 0px ;
		float: left;
	}
	
	label {
		display: inline-block;
		font-weight: bold;
		width: 25%;
		text-align: right;
		margin-right: 15px;
	}
	
	input {
		display: inline-block;
		border: 1px solid blue;
		width: 65%;
		height: 30px;
		padding-left: 5px;
	}
	
	.in-box:hover {
		background-color: #ddd;
	}
	
	#btn-join {
		width: 10%;
		margin-top: 20px;
	}
	
	input:invalid {
		border: 2px solid red;
	}
</style>
<form action="<c:url value='/join' />" method="POST" id="form-join" autocomplete="on">
	<fieldset id="login-div">
		<legend><h3>회원가입</h3></legend>
		
		<label for="m_userid">회원ID(email)</label>
		<input type="email" class="in-box" required="required" id="m_userid" name="m_userid" placeholder="ID를 입력해주세요" /><br />
			
		<label for="m_password">비밀번호</label>
		<input type="password" class="in-box"  id="m_password" name="m_password" placeholder="비밀번호를 입력해주세요" /><br />
			
		<label for="m_re_password">비밀번호확인</label>
		<input type="password" class="in-box"  id="m_re_password" name="m_re_password" placeholder="비밀번호를 다시한번 입력해주세요" /><br />
			
		<label for="m_name">이름</label>
		<input type="text" class="in-box"  id="m_name" name="m_name" placeholder="이름을 입력해주세요" /><br />
		
		<label for="m_tel">전화번호</label>
		<input type="tel" class="in-box"  id="m_tel" name="m_tel" placeholder="전화번호를 입력해주세요" /><br />
			
		<label for="m_addr">주소</label>
		<input type="text" class="in-box" id="m_addr" name="m_addr" placeholder="주소를 입력해주세요" /><br />
		
		<label class="in-label" for="btn-join"></label>
		<button type="button" id="btn-join">가입</button>
	</fieldset>
</form>
