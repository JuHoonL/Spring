<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib 
	uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>    
<style>
	fieldset{
		width:50%;
		margin:20px auto; /* 가로방향 중앙정렬 */
		margin-top:100px;
		padding: 30px;
	}
	
	legend {
		font-size:15pt;
		font-weight: bold;
		color : #3d65ff;
		text-align: center;
	}
	
	.in-label {
		display: inline-block;
		width:20%;
		
		float:left;
		text-align: right;
		margin-right: 5px;
		padding:8px;
	}
	
	.in-box {
		padding:8px;
		margin:3px;
		display: inline-block;
		width:70%;
		border:1px solid #ccc;
	}
	
	.in-box:hover {
		background-color: #ddd;
		border:1px solid blue;
	}
	
	input:invalid {
		background-color: #ffdddd;
		border:2px solid red;
	}
	
	/* span 설정 */
	#userid_error {
		width:70%;
		color:red;
		font-weight: bold;
	}
	
	.userid_label {
		display: none;
	}
	
	#btn-join {
		padding: 5px;
		width: 20%;
		margin-top: 8px;
		margin-bottom: 8px;
		margin-right: 64px;
		float: right;
	}

</style>

<script>
$(function(){
	$("#btn-join").click(function(){
		let m_userid = $("#m_userid").val()
		let m_password = $("#m_password").val()
		let m_re_password = $("#m_re_password").val()
		let m_mailaddress = $("#m_mailaddress").val()
		
		if(m_userid == "") {
			alert("id(email)을 반드시 입력하세요")
			$("#m_userid").focus();
			return false;
		}
		if(m_password == "") {
			alert("비밀번호를 반드시 입력하세요")
			$("#m_password").focus()
			return false;
		}
		if(m_re_password == "") {
			alert("비밀번호를 한번더 입력하세요")
			$("#m_re_password").focus()
			return false;
		}
		if(m_password != m_re_password) {
			alert("비밀번호와 확인이 일치하지 않습니다")
			$("#m_password").val("")
			$("#m_re_password").val("")
			$("#m_password").focus()
			return false;
		}
		if(m_mailaddress == "") {
			alert("메일주소를 반드시 입력하세요")
			$("#m_mailaddress").focus()
			return false;
		}
		
		$("form").submit()
	})
	
	$("#m_userid").blur(function(event){
		
		event.preventDefault()
		
		let userid= $("#m_userid").val()

		if(userid == "") {
			$("#userid_error").text("* 아이디를 입력하세요")
			$(".userid_label").css("display","inline-block")
			$("#m_userid").focus()
			return false;
		}
		
		$.ajax({
			url : "<c:url value='id_check' />",
			method:"POST",
			data : {m_userid:userid},
			success:function(result) {
				$("#userid_error").html(result)
				$(".userid_label").css("display","inline-block")
			},
			error:function(){
				alert("서버오류")
			}
		})
	})
})

</script>	
<form action="<c:url value='/join' />" method="POST">

	<fieldset>
	<legend>회원가입</legend>
	<label  class="in-label" for="m_userid">회원ID</label>
	<input type="text" class="in-box" required
			placeholder="회원ID를 입력하세요"
			id="m_userid" name="m_userid"><br/>
			
	<label class="in-label userid_label"></label>
	<span id="userid_error" class="userid_label"></span>
			
	<label class="in-label" for="m_password">비밀번호</label>
	<input type="password" class="in-box"
			id="m_password" name="m_password"><br/>
			
	<label  class="in-label" for="m_re_password">비밀번호확인</label>
	<input type="password" class="in-box"
			id="m_re_password" name="m_re_password"><br/>
	
	<label class="in-label" for="m_mailaddress">메일주소</label>
	<input type="email"  class="in-box"
			id="m_mailaddress" name="m_mailaddress"><br/>
	
	<label class="in-label" for="m_username">이름</label>
	<input type="text"  class="in-box"
			id="m_username" name="m_username"><br/>

	<label class="in-label" for="m_addr">주소</label>
	<input type="text" class="in-box"
			id="m_addr" name="m_addr"><br/>

	<label class="in-label" for="m_tel">전화번호</label>
	<input type="text" class="in-box"
			id="m_tel" name="m_tel"><br/>
	
	<label class="in-label" for="btn-join"></label>
	<button id="btn-join" type="button">회원가입</button>
	</fieldset>
</form>