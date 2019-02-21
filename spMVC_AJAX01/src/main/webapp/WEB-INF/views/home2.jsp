<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	* {
		box-sizing: border-box;
		-webkit-box-sizing: border-box;
		-moz-box-sizing: border-box;
	}

	html, body {
		height: 100%;
	}
	
	body {
		display: flex;
		flex-flow: column wrap;
		width: 90%;
		margin: 0px auto;
	}

	header {
 		background: linear-gradient(To bottom, blue, black);
 		text-align: center;
 		color: white;
 		padding: 5px;
	}
	
	section {
		display: flex;
		flex-direction: row;
		height: 85%;
		margin: 5px 0px;
		margin-bottom: 0px;
	}
	
	#side-bar {
		display: inline-block;
		width: 200px;
		height: 99%;
		border: 2px solid black;
	}
	
	#section-atc {
		display: flex;
		flex-direction: column;
		width: 90%;
		height: 99%;
		margin-left: 3px;
	}
	
	#section-header {
		display: block;
		border: 2px solid black;
		background: linear-gradient(To bottom, silver, black);
		color: white;
		text-align: center;
		font-size: 13pt;
		width: 100%;
	}
	
	#section-div {
		display: flex;
		flex-flow: row wrap;
		width: 100%;
		height: 99%;
		margin-top: 3px;
	}
	
	#div-div1 {
		border: 2px solid black;
		width: 74.86%;
		height: 100%;
		overflow: auto;
	}
	
	#div-table { 
		width: 100%;
	}
	
	
	#div-div2 {
		border: 2px solid black;
		width: 25%;
		margin-left: 2px;
	}
	
	footer {
		background: linear-gradient(To bottom, blue, black);
 		text-align: center;
 		color: white;
 		padding: 5px;
	}
	
</style>
</head>
<body>
<header><h2>나라 Plus</h2></header>
<section>
	<nav id="side-bar">
	side-bar
	</nav>
	<article id="section-atc">
		<div id="section-header">
			<p>section header</p>
		</div>
		<div id="section-div">
			<div id="div-div1">
			<table id="div-table">
				<tr>
					<th>회사코드</th>
					<th>회사이름</th>
					<th>대표자명</th>
				</tr>
				<c:forEach items="${LIST}" var="vo" varStatus="i">
					<tr>
						<th>${vo.d_code}</th>
						<th>${vo.d_name}</th>
						<th>${vo.d_ceo}</th>
					</tr>
				</c:forEach>
			</table>
			</div>
			<div id="div-div2">
				<p>flex-box</p>
			</div>
		</div>
	</article>
</section>
<footer><address>CopyRight &copy; juhoon12@nate.com</address></footer>

</body>
</html>