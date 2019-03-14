<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<link rel="stylesheet" 
	href=<c:url value="/css/memo_input_style.css" /> >
<script>
	$(function(){
		$(".file_delete").click(function(){
			
			//tbl_files의 pk값
			let id = $(this).attr("data-id")
			
			if(id == 0) {
				alert("삭제할 그림이 없습니다")
				return false
			}
			
			//삭제여부 확인에서 취소를 클릭하면 진행 중단
			if(!confirm("첨부 파일을 삭제할까요?")) {
				return false
			}
			
			$.ajax({
				url: "<c:url value='/files' />",
				method: "DELETE",
				data: {id:id},
				success:function(result){
					if(result == 'FAIL'){
						alert("첨부파일 삭제 실패")
						return false
					}
					
					let pid = $("#id").val()
					$.ajax({
						url: "<c:url value='/memo_view' />",
						method: "GET",
						data: {id:pid},
						success:function(result){
							$("#body").html(result)
						},
						error:function(){
							
						}
					})
				},
				error:function(){
					alert("서버와 통신 오류")
				}
			})
		})
		
		$("#btn-write").click(function(){
			/*ajax로 file과 memoVO를 한꺼번에 서버에 전송하기
			 1. js에 내장된 FormData클래스를 사용한다.
			 1-1. jquery가 내부적으로 form을 배열로 관리하고 있는데 현재 작성중인
			    form만 추출하기 위해서 배열의 0번째 라는 것을 반드시 명시
			*/
			let form = $("form")[0]
			
			//2. form 문서를 formData라는 객체 형식으로 변환
			/*
			 memoVO에 각 요소들이 포함이 되어 있는 상태
			 그런데 fData에는 input type=file은 기본적으로 포함되지 않는다.
			*/
			let fData = new FormData(form)
			
			//3. fData 객체에 임의로 input type=file 항목을 추가
			fData.append('m_file',$("#m_file")[0].files[0])
			
			$.ajax({
				url: "<c:url value='/memo_file'/>",
				method: "POST",
				data:fData,
				processData: false, //데이터를 다른처리를 하지말고
				contentType: false, //contentType도 지정하지 말아라
				success:function(result){
					$.ajax({
						url: "<c:url value='/memo_list2'/>",
						method:"GET",
						success:function(result){
							$("#body").html(result)
						}
					})
				},
				error:function(){
					alert("서버와 통신 오류 발생")
				}
			})
		})
		
		$("#btn-delete").click(function(){
			let id = $("#id").val()
			if(id == '0') {
				alert("삭제할 메모가 없습니다")
				return false
			}
			if(!confirm("정말 메모를 삭제 할까요")) {
				return false;
			}
			
			$.ajax({
				url: "<c:url value='/memo_delete'/>",
				method: "GET",
				data:{id},
				success:function(result){
					$.ajax({
						url: "<c:url value='/memo_list2'/>",
						method:"GET",
						success:function(result){
							$("#body").html(result)
						}
					})
				},
				error:function(){
					alert("서버와 통신 오류 발생")
				}
			})
		})
	})
</script>
<style>
	.file_delete {
		cursor: pointer;
		
		display: inline-block;
		width: 100px;
		background-color: orange;
		color: white;
		text-align: center;
		border-radius: 6px;
		padding: 5px 0 ;
		margin-left: 10px;
	}
	
	.file_delete:hover {
		background-color: red;
	}
	
	.image_file {
		/* width나 height로 설정된 상태 그대로 유지 */ 
		transform: scale(1); 
		-webkit-transform: scale(1); /* 크롬구버젼 */
		-moz-transform: scale(1); /* 파이어폭스 */
		-ms-transform: scale(1); /* ie */
		-o-transform: scale(1); /* opera */
		
		/* transition은 효과가 부드럽게 연출됌 */
		/* ease-in-out : 보간법이라는 scale 변화 규칙에 따라 크기를 변화 */
		transition: all 0.3s ease-in-out; 
		-webkit-transition: all 0.3s ease-in-out; /* 크롬구버젼 */
		-moz-transition: all 0.3s ease-in-out; /* 파이어폭스 */
		-ms-transition: all 0.3s ease-in-out; /* ie */
		-o-transition: all 0.3s ease-in-out; /* opera */
	}
	
	.image_file:hover {
		/* 가로세로 3배로 확대 */
		transform: scale(3); 
		-webkit-transform: scale(3); /* 크롬구버젼 */
		-moz-transform: scale(3); /* 파이어폭스 */
		-ms-transform: scale(3); /* ie */
		-o-transform: scale(3); /* opera */ 
	}
	
	#btn-delete {
		background-color: red;
	}
	
	#btn-delete:hover {
		background-color: orange;
	}
</style>
<section>
	<!-- 
		form에서 파일을 업로드 하려면
		반드시 enctype=multipart/form-data로 설정해 주어야 한다
	 -->
	<form action=<c:url value="/memo_file"/> 
			enctype="multipart/form-data"
			method="POST">
	
		<input type="hidden" id="id" name="id" value=<c:out value="${MEMO.id}" default="0" />  >
		<label for="m_auth">USERID</label>
		<input 
			type="text"  
			value="${LOGIN_INFO.m_userid}" readonly
			id="m_auth" 
			name="m_auth"><br/>

		<label for="m_auth">작성자</label>
		<input 
			type="text"  
			value="${LOGIN_INFO.m_name}" readonly><br/>

		
		<label for="m_date">작성일자</label>
		<input value="${MEMO.m_date}" type="date" id="m_date" name="m_date"><br/>
		
		<label for="m_subject">제목</label>
		<input value="${MEMO.m_subject}" type="text" id="m_subject" name="m_subject"><br/>
		
		<label for="m_text">메모</label>
		<textarea rows="5" id="m_text" name="m_text">${MEMO.m_text}</textarea><br/>
		
		<label for="m_file">파일</label>
		<%
		/*
			input type=file에서 accept 속성을 미지정하면 모든 파일(*.*) 선택창이 열림
			속성을 image/*로 설정해주면 이미지와 관련된 파일들만 선택 가능한 창이 열림
			속성 - audio/*(음성관련파일), video/*(동영상관련파일)
			
			그 외 파일 제한
			".jpg" ".png" : 확장자가 jpg인 파일 png인 파일중 하나만 선택 가능
			".jpg, .png, .gif": 확장자가 jpg이거나 png, gif인 파일 하나 선택가능
			
			IE 10 미만에서는 사용불가
		*/
		%>
		<input type="file" accept="image/*" id="m_file" name="m_file">
		<hr />
		
		<label></label>
		<p><b>첨부파일</b></p>
		<div>
			<c:if test="${not empty MEMO.files}">
				<label></label>
				<p>
				<c:forEach items="${MEMO.files}" var="file" varStatus="1">
					<a href="<c:url value='/files/${file.save_file_name}' />" target="_new">
					<img src="<c:url value='/files/${file.save_file_name}' />" width="50px" class="image_file">
					</a>	
						${file.file_name}
					<span class="file_delete" title="${file.file_name} 파일을 삭제합니다" data-id="${file.id}">  삭제</span>&nbsp;&nbsp;
				</c:forEach>
			</c:if>
		</div>
		<hr />
		<label></label>
		<button id="btn-write">메모저장</button>
		<button id="btn-delete">메모삭제</button>
	</form>
</section>