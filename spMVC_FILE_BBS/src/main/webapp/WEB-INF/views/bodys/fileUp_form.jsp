<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	$(".drag-area").on("dragover",function(){
		$(".drag-area h3").text("파일을 내려놓으세요")
		return false
	})
	
	$(".drag-area").on("drop",function(e){
		$(".drag-area h3").text("파일을 등록하는중")
		let files = e.originalEvent.dataTransfer.files
		
		let fData = new FormData()
		
		fData.append("file",files[0])
		
		$.ajax({
			url: "<c:url value='/file' />",
			method: "POST",
			data: fData,
			processData: false,
			contentType: false,
			success:function(result){
				alert(result)
			},
			error:function(){
				alert("새로고침(F5)을 하고 파일을 다시 올려주세요.")
			}
		})
		return false;
	})
})
</script>
<style>
	.drag-area {
		width: 70%;
		height: 200px;
		border: 1px solid blue;
		margin: 0 auto;
		text-align: center;
	}
	
	.drag-area:hover {
		cursor: pointer;
		background-color: #ccc;
	}
</style>
</head>
<body>
<div>
	<p>
	<p>
	<div class="drag-area">
		<h3>파일 업로드</h3>
	</div>
	
	<div id="image">
	
	</div>
</div>
</body>
</html>