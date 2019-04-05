<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set var="rootPath" value="${pageContext.request.contextPath}" />
    <link href="${rootPath}/css/list.css" rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<script>
$(function(){
	$(".p-select").click(function(){
		let tds = $(this).children() // td들의 데이터를 모두 뽑아라 (배열변수)
		let p_code = tds.eq(1).text()
		let p_name = tds.eq(2).text()
		let p_tax = tds.eq(3).text()
		let p_iprice = tds.eq(4).text()
		let p_oprice = tds.eq(5).text()
		
		let io_inout = $("#io_inout").val()
		
		$("#io_pcode").val(p_code)
		$("#p_name").text(p_name)
		
		if(p_tax == '1') {
			$("#io_tax_on").attr("cheched",true)
		}else{
			$("#io_tax_off").attr("cheched",true)
		}
		
		if(io_inout == '1') {
			$("#io_price").val(p_iprice)
		}else if(io_inout == '2'){
			$("#io_price").val(p_oprice)
		}
		
		$("#myModal").css("display","none")
	})
})
</script> 
<hr />
<table>
<tr id="tr-headline">
	<th>NO.</th>
	<th>상품코드</th>
	<th>상품이름</th>
	<th>과세</th>
	<th>매입단가</th>
	<th>매출단가</th>
	<th></th>
</tr>
<tr>
	<c:choose>
		<c:when test="${empty LIST}">
			<td colspan=20>상품리스트자료가 없습니다.</td>
		</c:when>
		<c:otherwise>
			<c:forEach var="list" items="${LIST}" varStatus="i">
				<tr class="list-tr1 p-select" data-id="${list.p_code}">
					<td>${i.count}</td>
					<td>${list.p_code}</td>
					<td>${list.p_name}</td>
					<td>${list.p_tax}</td>
					<td>${list.p_iprice}</td>
					<td>${list.p_oprice}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
<hr />

