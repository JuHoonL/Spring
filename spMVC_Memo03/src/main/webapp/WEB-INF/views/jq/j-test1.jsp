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
/* 이 곳에서 body tag에 바탕색을 red로 설정하는 js코드를 작성 한다면 js 코드는 문법오류를 낼것이다
   그리고 이후의 js 코드는 모두 무시해 버린다.
   그래서 표준 js 코드에서는 tag에 어떤 속성을 변경하는 코드는 문서 끝에 body, html이 끝난 이후에 작성을 한다.*/
   
// document.getElementByTags("#body").setAttribute("backgroundColor","red") // body가 끝난 다음에 사용하면 오류X
   
   
//아래에 해당 html부분이 준비되면(모두 완성이되면) js코드를 실행하라라는 명령어(document.ready)
//JQuery(document).ready(function(){})) => $(document).ready(function(){})) => $(function(){})<3.1이상버젼부터사용가능>
$(function(){
	$(".q").click(function(){
		let num = $(this).attr("data-num")
//		alert(num)
//		$("#as" + num).css("display","block")
		$("#as"+num).toggleClass("block")
	})
})
</script>
<style>
	.q {
		background-color: yellow;
		color: black;
		font-size: 30px;
		margin: 10px;
	}
	
	.p {
		background-color: white;
		color: black;
		font-size: 30px;
		margin: 10px;
		display: none;
	}
	
	.block {
		display: block;
	}
</style>
</head>
<body id="body">
<header>
	<nav>
	</nav>
</header>
<section>
	<article>
		<div class="q" id="q1" data-num="1">div1</div>
		<p class="p" id="as1">우리</p>
		
		<div class="q" id="q2" data-num="2">div2</div>
		<p class="p" id="as2">나라</p>
		
		<div class="q" id="q3" data-num="3">div3</div>
		<p class="p" id="as3">만세</p>
	</article>
</section>
<footer>
	<address></address>
</footer>

</body>
</html>