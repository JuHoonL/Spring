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
<style>
table {
	border-collapse:collapse;
	border-spacing: 0;
	width:100%;
	border:1px solid #ccc;
}

tr {
	border:1px solid #ddd;
}

tr:nth-child(even) {
	background-color: #ccc;
}
tr:nth-child(odd) {
	background-color: #fff;
}

tr:hover {
	background-color: #ddd;
}

td {
	text-align: center;
}

td, th {
	padding: 8px 8px;
	vertical-align: top
}

td:first-child, th:first-child {
	padding-left:16px;
}

</style>
<script>
$(function(){
	$(".my-card").click(function(){
		let id = $(this).attr("data-id")
		$.ajax ({
			url : "<c:url value='/memo_view' />",
			method : "GET",
			data : {id:id},
			success:function(result){
				$("#body").html(result)
			}
		})
	})
	
	$("#btn_memo").click(function(){
		$.ajax({
			url : "<c:url value='/memo' />",
			method : "GET",
			success:function(result){
				$("#body").html(result)
			}
		})
	})
})
</script>
<style type="text/css">
	section {
		display: flex;
		flex-wrap: wrap; /* flex box들이 가로방향으로 채워지면 줄바꿈 */
	}
	
	.my-card {
		flex: 0 0 200px;
		height: 332px;
		margin: 20px;
		box-shadow: 0 4px 10px 0 rgba(0,0,0,0.2),
					0 4px 20px 0 rgba(0,0,0,0.9);
		border-radius: 6px;
		overflow: auto;
		-ms-overflow-style: none;
		
		display: flex;
		flex-direction: column;
		text-align: center;
	}
	
	::-webkit-scrollbar {
		display:none;
	}
	
	img {
		border: 1px solid red;
	}
</style>
</head>
<body>
<section>
	<c:if test="${not empty MEMOS}">
		<c:forEach items="${MEMOS}" var="memo" varStatus="i">
			<c:if test="${not empty memo.files}">
				<c:forEach items="${memo.files}" var="file" varStatus="f">
					<div class="my-card" data-id="${memo.id}">
						<img width="100%" height="60%" src="<c:url value='/files/${file.save_file_name}' />">
						<div>
							<h3>${memo.m_subject}</h3>
							<p>${memo.m_auth}<br/>
							   ${memo.m_date}</p>
						</div>
					</div>
				</c:forEach>
			</c:if>
			<c:if test="${empty memo.files}">
				<div class="my-card">
					<h3>${memo.m_subject}</h3>
					<p>${memo.m_date}
					<p>${memo.m_auth}
				</div>
			</c:if>
		</c:forEach>
	</c:if>
</section>

<button id="btn_memo">메모작성</button>

</body>
</html>