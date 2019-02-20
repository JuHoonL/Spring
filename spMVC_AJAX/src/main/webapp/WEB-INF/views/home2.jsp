<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
	* {
		box-sizing: border-box;
		-webkit-box-sizing: border-box;
		-moz-box-sizing: border-box;
	}
	
	header {
		background: linear-gradient(to bottom, blue, black);
		text-align: center;
		color: white;
		border: 1px solid #ccc;
		
	}
	
	#main-menu {
		border: 1px soild #ccc;
		background: linear-gradient(to bottom, lightgray, black);
		color: white; 
		font-size: 15pt;
		margin-top: 2px;
	}
	
	.menu-home {
		display: inline-block;
		padding: 5px 12px;
		color: white;
		text-decoration: none;
	}
	
	.menu-home:hover {
		background: linear-gradient(to bottom, white, silver);
		color: black;
	}
	
	section {
		display: flex;
		flex-flow: row wrap;
		padding-top: 3px;
		padding-bottom: 3px;
	}
	
	#pList {
		border: 3px solid black;
		width: 70%;
		margin-right: 3px;
		overflow: auto;
		height: 750px;
		text-align: right;
	}
	
	#p-table {
		width: 100%;
	}
	
	th.table-headline {
		font-size: 13pt;
		background-color: lightgray;
	}
	
	td.table-data {
		font-size: 10pt;
	}
	
	#s-cart {
		border: 3px solid black;
		width: 29.83%;
		overflow: auto;
		height: 750px;
	}
	
	footer {
		background: linear-gradient(to bottom, blue, black);
		text-align: center;
		color: white;
		border: 1px solid #ccc;
		padding: 8px;
	}
	
</style>
</head>
<body>
<header>
	<h1>나라 Plus</h1>
</header>
<nav id="main-menu">
	<a href="#" class="menu-home">홈</a>
	<a href="#" class="menu-home">상품검색</a>
	<a href="#" class="menu-home">About</a>
</nav>
<section>
	<article id="pList">
		<table id="p-table">
			<th class="table-headline">NO</th>
			<th class="table-headline">상품코드</th>
			<th class="table-headline">상품이름</th>
			<th class="table-headline">과세여부</th>
			<th class="table-headline">매입단가</th>
			<th class="table-headline">판매단가</th>
			<c:choose>
				<c:when test="${empty PRODUCT}">
					<tr><td>상품리스트가 없습니다.</td></tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${PRODUCT}" var="vo" varStatus="i">
						<tr>
							<td class="table-data">${i.count}</td>
							<td class="table-data">${vo.p_ccode}</td>
							<td class="table-data">${vo.p_cname}</td>
							<td class="table-data">
							<c:if test="${vo.p_vat == '1'}">과세</c:if>
							<c:if test="${vo.p_vat == '2'}">면세</c:if>
							</td>
							<td class="table-data">${vo.p_iprice}원</td>
							<td class="table-data">${vo.p_oprice}원</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</article>
	<article id="s-cart">
	</article>
</section>
<footer><address>CopyRight &copy; juhoon12@nate.com</address></footer>
</body>
</html>