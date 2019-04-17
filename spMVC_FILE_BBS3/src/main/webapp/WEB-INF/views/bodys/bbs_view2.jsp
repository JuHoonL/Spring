<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<style>
	fieldset{
		width:50%;
		margin:20px auto; /* 가로방향 중앙정렬 */
	}
	
	legend {
		font-size:12pt;
		font-weight: bold;
		color : #3d65ff;
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
		padding-top: 2px;
		margin:3px;
		display: inline-block;
		width:70%;
	}
	
	.in-box2 {
		width: 100%;
		height: 30px;
	}
	
	.in-box2:hover {
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
	
	.in-box-error {
		color: red;
		font-size: 10pt;
	}
	
	#btn-join {
		width: 15%;
		height: 30px;
		float: right;
		font-weight: bold;
	}
	
	.in-file-box {
		border: 2px solid blue;
	}
	
	.in-file-box h3 {
		text-align: center;
	}
	
	.in-file-box:hover {
		cursor: pointer;
		background-color: #ccc;
	}
	
	#img-container {
		display: flex;
	}
	
	#images {
		flex: 0 1 auto;
		margin: 5px auto;
		
		display: flex;
		align-items: center;
		justify-content: center;
		
		/*border: 1px solid blue;*/
	}
	
	.img-box {
		flex: 0 0 50px;
		height: 100px;
		margin: 10px;
		border-radius: 6px;
	}
</style>
<script>
$(function(){
	$("#bbs_update").click(function(){
		let id = ${BBS.id}
		location.href="<c:url value='/bbs/update'/>" + "?id=" + id
	})
	
	$("#bbs_delete").click(function(){
		let id = ${BBS.id}
		if(confirm("게시물을 삭제할까요?")){
			location.href="<c:url value='/bbs/delete'/>" + "?id=" + id
		}
	})
})
</script>	
<form action="#">
	<fieldset>
		<label  class="in-label" for="b_subject">제목</label>
		<div class='in-box'>
			<input class="in-box2" readonly id="b_subject" name="b_subject" value="${BBS.b_subject}"/><br/>
		</div>
		
		<label class="in-label" for="b_userid">작성자</label>
		<div class='in-box'>
			<input class='in-box2' readonly id="b_userid" name="b_userid" value="${BBS.b_userid}"/><br/>
		</div>
		
		<label class="in-label" for="b_date">작성일자</label>
		<div class='in-box'>
			<input class="in-box2" readonly id="b_date" name="b_date" value="${BBS.b_date}:${BBS.b_time}"/><br/>
		</div>
		
		<label class="in-label" for="b_content">내용</label>
		<div class='in-box'>
			<textarea class="in-box2" readonly id="b_content" name="b_content" >${BBS.b_content}</textarea><br/>
		</div>
		
		<label  class="in-label" for="b_image"></label>
		<div class='in-box'>
			<img src="${pageContext.request.contextPath}/files/${BBS.b_image}"><br/>
		</div>
		
		<hr/>
		<c:if test="${BBS.b_userid == LOGIN_INFO.m_userid}">
		<label class="in-label" for="btn-join"></label>
		<div class='in-box'>
			<button type="button" id="bbs_update">편집</button>
			<button type="button" id="bbs_delete">삭제</button>
		</div>
		</c:if>
	</fieldset>
</form>