<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script>
$(function(){
	$("#btn-check-out").click(function(){
		$.get("${rootPath}/check_out",function(result){
			if(result == 'CHECK_OK') {
				$("#div-body").html("")
				alert("대여완료!!")
			} else {
				alert(result)
			}
		})
	})
	
	$("#btn-cart-clear").click(function(){
		$.get("${rootPath}/rent/cart_clear",function(result){
			$("#div-body").html(result)
		})
	})

	/*
	$(".item-del").click(function(){
		let index = $(this).attr("data-index")
		
		$.get("${rootPath}/rent/item_del/" + index, function(result){
			$("#div-body").html(result)
		})
	})
	*/
	$(".item-del").click(function(){
		let book_seq = $(this).attr("data-seq")
		
		$.get("${rootPath}/rent/cart_item_del/" + book_seq, function(result){
			$("#div-body").html(result)
		})
	})
})
</script>
<style>
.item-del {
	cursor: pointer;
}
</style>
<h3>장바구니</h3>
<div>
	<button id="btn-check-out">결제</button>
	<button id="btn-cart-clear">비우기</button>
</div>
<table>
	<tr>
		<th>NO.</th>
		<th>도서명</th>
		<th>가격</th>
		<th></th>
	</tr>
	<c:choose>
		<c:when test="${empty CART}">
			<tr><td colspan=3>장바구니 비었음</td></tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="vo" items="${CART}" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td>${vo.book_title}</td>
					<td>${vo.book_price}</td>
					<th class="item-del" data-index="${i.index}" data-seq="${vo.book_seq}">x</th>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>