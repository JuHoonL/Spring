<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<link href="${rootPath}/css/list.css" rel="stylesheet" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<script>
$(function(){
	$(".d-select").click(function(){
		let tds = $(this).children() // td들의 데이터를 모두 뽑아라 (배열변수)
		let d_code = tds.eq(1).text()
		let d_name = tds.eq(2).text()
		let d_ceo = tds.eq(3).text()
		let d_tel = tds.eq(4).text()
		let d_addr = tds.eq(5).text()
		
		$("#io_dcode").val(d_code)
		$("#d_name").text(d_name)
		
		$("#myModal").css("display","none")
	})
})
</script> 
<a href="<c:url value='/dept/write' />" id="insert-button">거래처정보 등록</a>
<hr />   
<table>
<tr id="tr-headline">
	<th>NO.</th>
	<th>거래처코드</th>
	<th>거래처명</th>
	<th>대표자명</th>
	<th>대표전화</th>
	<th>주소</th>
	<th></th>
</tr>
<tr>
	<c:choose>
		<c:when test="${empty LIST}">
			<td colspan=6>매입매출자료가 없습니다.</td>
		</c:when>
		<c:otherwise>
			<c:forEach var="list" items="${LIST}" varStatus="i">
				<tr class="list-tr1 d-select" data-id="${list.d_code}">
					<td>${i.count}</td>
					<td>${list.d_code}</td>
					<td>${list.d_name}</td>
					<td>${list.d_ceo}</td>
					<td>${list.d_tel}</td>
					<td>${list.d_addr}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
<hr />
