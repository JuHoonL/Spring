<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음식 선택</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
	
	section {
		padding: 15px;
	}
	
	#all-div {
		width: 1500px;
		margin: 1px auto;
	}

	#major-menudiv{
		float: left;
		width : 20%;
		height: 800px;
		padding-left: 5px; 
		border: 1px solid #ccc;
		font-size:15pt;
		text-decoration: none;
		margin-left: 45px;
		overflow: scroll; 
		overflow-x: hidden;
		overflow-y: auto;
	}

	article{
		float: left;
		width : 75%;
		height: 800px;
		border: 1px solid #ccc;
		
	}

	#minor-menu{
		height: 600px;
		overflow: scroll; 
		overflow-x: hidden;
		overflow-y: auto;
	}

	#calcekcal{
		height: 150px;
		border-top: 1px solid #ccc;
		color: green;
		font-size: 13pt;
		padding: 13px ;
	}
	
	table {
		width: 98%;
		margin: 5px auto;
	}
	
	td {
		border: 1px solid #ccc;
		text-align: center;
		font-size: 12pt;
		padding: 10px;
	}
	
	#td-foodname {
		color: black;
		
	}
	
	.selectfood {
		display : inline-block;
	}
	
	#Tkcal {
		display: block;
		float:right;
		margin: 9px;
		font-size: 20pt;
	}
			
	#calce-button {
		height:50px;
		width: 450px;
		margin: 1px auto;
	}
	
	#button-confirm {
		width: 80%;	
	}
	
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sb-admin.css" >
<script>
 $(function(){
	 $("#button-confirm").click(function(){
		 location.href="${pageContext.request.contextPath}/sports"
	 })
 })
</script>
</head>
<body>
<header>
    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="${pageContext.request.contextPath}/">헬스케어프로그램</a>
     <div style ="text-align:right; width:100%;">
    <label style = "color:white;">Id</label> <input type ="text" style = "text-align:right; ">
    <label style = "color:white;">PassWord</label> <input type ="password" style = "text-align:right; ">
     
    
    
    </div>
	<a class="btn btn-link btn-sm text-white ml-auto " style = "width:100px;"
	href="sports" >
	로그인
    </a>
	<a class="btn btn-link btn-sm text-white"  style = "width:100px;"
	href="user_join" >
	회원가입
    </a>

    </nav>
</header>
<section>
<div id="all-div">
	<div id="major-menudiv">
		<c:forEach items="${ALLFOODCATE}" var="FoodVO">
			<a href="food_select01?cate_code=${FoodVO.cate_code}">${FoodVO.cate}</a><br/>
		</c:forEach>
	</div>
	<article>
		<div id="minor-menu">
			<c:set var="i" value="0" />
			<c:set var="j" value="5" />
			<table>
				<c:forEach var="FoodVO" items="${CATEFOOD}">
					<c:if test="${i%j == 0}">
						<tr>
					</c:if>
						<td><a href="" id="td-foodname">${FoodVO.foodName}</a></td>
					<c:if test="${i%j == j-1}">
						</tr>
					</c:if>
				<c:set var="i" value="${i+1}" />
				</c:forEach>
			</table>
		</div>
		<div id="calcekcal">
			<c:set var="i" value="0" />
			<c:set var="s" value="${FLISTSIZE}" />
			
			<c:forEach items="${SELECTFOOD}" var="FoodVO" >
				<p class="selectfood">${FoodVO.foodName}(${FoodVO.foodkcal})
				<c:if test="${i < (s-1)}">
					<p class="selectfood"> +
				</c:if>
				<c:if test="${i == (s-1)}">
					<p id="Tkcal"> = ${TOTALKCAL}kcal </p>
				</c:if>
				<c:set var="i" value="${i+1}"/>
			</c:forEach>
		</div>
		<div id="calce-button"><button type="button" id="button-confirm">확인</button></div>
	</article>
</div>
</section>


</body>
</html>