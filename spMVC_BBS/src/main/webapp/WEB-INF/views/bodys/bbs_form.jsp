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
	$(".in-file-box").on("dragover",function(){
		$(".in-file-box h3").text("파일을 내려놓으세요")
		return false
	})
	
	$(".in-file-box").on("drop",function(e){
		$(".in-file-box h3").text("파일을 올리는 중...")
		
		let files = e.originalEvent.dataTransfer.files
		
		let fData = new FormData()
		
		for(let i = 0 ; i < files.length ; i++) {
			fData.append("files",files[i])
		}
		
		$.ajax({
			url:"<c:url value='/bbs/bbs_files' />",
			method:"POST",
			data:fData,
			dataType:"JSON",
			processData:false,
			contentType:false,
			success:function(result){
				if(result == null) {
					$("h3").text("파일업로드 오류!")
				} else {
					for(let i = 0 ; i < result.length ; i ++ ) {
						$("#images").append(
											$("<img/>",{
												src:"<c:url value='/files/' />" + result[i],
												class:'img-box'
											})
											)
						$("#b_image").val(result)
					}
					$("h3").text("파일업로드 성공!")
				}
			},
			error:function(){
				alert("새로고침(F5)을 하고 파일을 다시 올려주세요.")
			}
		})
		return false;
	})
	
})
</script>	
<form:form action="${pageContext.request.contextPath}/save" modelAttribute="bbsVO">
	<fieldset>
		<c:if test="${empty ACTION}">
			<legend>게시판작성</legend>
		</c:if>
		<c:if test="${not empty ACTION}">
			<legend>게시판수정</legend>
		</c:if>
		<form:hidden class="in-label" path="id" />
		<form:label class="in-label" path="b_userid">작성자</form:label>
		<div class='in-box'>
			<form:input class='in-box2' readonly="true" placeholder="작성자를 입력하세요" id="b_userid" path="b_userid" /><br/>
			<form:errors path="b_userid" class="in-box-error" />
		</div>
		
		<label class="in-label" for="b_date">작성일자</label>
		<div class='in-box'>
			<form:input class="in-box2" readonly="true" id="b_date" path="b_date" /><br/>
			<form:errors path="b_date" class="in-box-error" />
		</div>
		
			<label class="in-label" for="b_time">작성시간</label>
		<div class='in-box'>
			<form:input class="in-box2" readonly="true" id="b_time" path="b_time" /><br/>
			<form:errors path="b_time" class="in-box-error" />
		</div>
				
		<label  class="in-label" for="b_subject">제목</label>
		<div class='in-box'>
			<form:input class="in-box2" id="b_subject" path="b_subject" /><br/>
		</div>
		
		<label class="in-label" for="b_content">내용</label>
		<div class='in-box'>
			<form:textarea class="in-box2" id="b_content" path="b_content" rows="5" /><br/>
			<form:errors path="b_content" class="in-box-error" />
		</div>
		
		<label class="in-label" for="b_image"></label>
		<form:hidden path="b_image"  id="b_image"/>
		<div class="in-box in-file-box">
			<h3>파일을 끌어 놓으세요</h3>
		</div>
		<article id="img-container">
				<div id="images">
					<c:if test="${not empty boardVO.b_image}">
						<p><img src="${pageContext.request.contextPath}/files/${boardVO.b_image}">
					</c:if>
				</div>
		</article>
		
		<hr/>
		<label class="in-label" for="btn-join"></label>
		<div class='in-box'>
			<button id="btn-join" type="submit">저장</button>
		</div>
	</fieldset>
</form:form>