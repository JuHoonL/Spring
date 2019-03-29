<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	
	$(".tr-List").click(function(){
		var id = $(this).attr("data-id")
		
		$.ajax({
			url:"<c:url value='view' />",
			method:"POST",
			data:{id},
			success:function(result){
				$("#body").html(result)
			},
			error:function() {
				alert("오류발생!!")
			}
		})
	})
	
	$("#insert").click(function(){
		location.href="<c:url value='e_save' />"
	})
	
})
</script>
<div id="div-table">
	<table id="main-table">
		<tr>
			<th>No</th>
			<c:if test="${LOGIN_INFO.m_userid == 'juhoon12' || SNR == 'REQUEST'}">
				<th>발송자</th>
			</c:if>
			<c:if test="${LOGIN_INFO.m_userid == 'juhoon12' || SNR == 'SEND'}">
				<th>수신자</th>
			</c:if>
			<th>메일제목</th>
			<th>발송날짜</th>
		</tr>
		<c:choose>
			<c:when test="${empty EMAILLIST}">
				<tr><td colspan="5">받은메일이 없습니다</td></tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${EMAILLIST}" var="vo" varStatus="i">
					<tr class="tr-List" data-id="${vo.id}">
						<td>${i.count}</td>
						<c:if test="${LOGIN_INFO.m_userid == 'juhoon12' || SNR == 'REQUEST'}">
							<td>${vo.from_email}</td>
						</c:if>
						<c:if test="${LOGIN_INFO.m_userid == 'juhoon12' || SNR == 'SEND'}">
							<td>${vo.to_email}</td>
						</c:if>
						<td>${vo.s_subject}</td>
						<td>${vo.s_date}:${vo.s_time}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</div>
<c:if test="${not empty LOGIN_INFO}">
	<div id="div-insert">
		<button id="insert" class="a-menu">이메일추가</button>
	</div>
</c:if>
