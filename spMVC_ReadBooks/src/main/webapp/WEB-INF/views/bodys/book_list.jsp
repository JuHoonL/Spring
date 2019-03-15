<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	$(".tr-List").click(function(){
		var b_id = $(this).attr("data-id")
		
		$.ajax({
			url:"<c:url value='book_view' />",
			method:"POST",
			data:{b_id},
			success:function(result){
				$("#main-section").html(result)
			},
			error:function() {
				alert("오류발생!!")
			}
		})
	})
	
	$(".a-menu").click(function(){
		let id = $(this).attr("id")
		$.ajax({
			url : "<c:url value='/' />" + id,
			method:"GET",
			success:function(result){
				$("#main-section").html(result)
			},
			error:function() {
				location.href="<c:url value='/' />"
			}
		})
	})
	
})
</script>
<div id="div-table">
	<table id="main-table">
		<tr>
			<th>사용자ID</th>
			<th>도서코드</th>
			<th>도서제목</th>
			<th>독서일자</th>
			<th>별점</th>
		</tr>
		<c:choose>
			<c:when test="${empty BOOKLIST}">
				<tr><td colspan="5">도서 리스트가 없습니다</td></tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${BOOKLIST}" var="vo" varStatus="i">
					<tr class="tr-List" data-id="${vo.b_id}">
						<td>${vo.b_userid}</td>
						<td>${vo.b_isbn}</td>
						<td>${vo.b_title}</td>
						<td>${vo.b_date}</td>
						<td>${vo.b_star}</td>
					</tr>
				</c:forEach>
				<c:if test="${not empty LOGIN_INFO}">
				</c:if>
			</c:otherwise>
		</c:choose>
	</table>
</div>
<c:if test="${not empty LOGIN_INFO}">
	<div id="div-insert">
		<button id="insert" class="a-menu">도서목록추가</button>
	</div>
</c:if>
