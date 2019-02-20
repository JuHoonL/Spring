<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style type="text/css"></style>
<script>
	$(function(){
		$(".p-tr").click(function(){
			// id값을 추출할 수 있으면 몇번쨰 tr이 클릭되었는지 알 수 있다.
			
			/*
				var(public)는 기억장치를 차지하면서 변수가 사라지지않는데 
				let(private)는 함수가 끝나면 변수가 사라짐
				아래 명령문은 현재 클릭된(this) id항목의 속성을 알려주라는 것
				
				attr()함수
				$(...): 선택자, selector라고 하는 객체의 속성값을 getter하거나 setter하는 함수다
				$(this).attr("data-my-name","홍길동")
			*/
			let id = $(this).attr("id")
			let p_ccode = $(this).attr("data-p_ccode")
			let p_cname = $(this).attr("data-p_cname")
			let p_vat = $(this).attr("data-p_vat")
			let p_iprice = $(this).attr("data-p_iprice")
			let p_oprice = $(this).attr("data-p_oprice")
			
			let su = 2
			let p_isum = su * parseInt(p_iprice) // parseInt()는 Integer.valueOf()와 같음(문자열을 int형으로 변환)
			let p_osum = su * parseInt(p_oprice)
			
			/*
				prop은 attr과 거의 같은 기능을 하는데 일부 tag나 선택자로부터 값을
				추출하지 못하는 JS 버그를 개선한 함수이다.(버전에 따라서 두가지 혼용)
				
			*/
			//p_oprice = $(this).prop("data-p_oprice")
			
			let p_string = "<p>" + p_ccode + "<br/>" + p_cname + "<br/>" 
						+ p_iprice + "<br/>" + p_oprice + "<br/>" 
						+ "<span class='isum'>" + p_isum + "</span>" + "<br/>" 
						+ "<span class='osum'>" + p_osum + "</span>"  + "</p>"
			
			
			/*
				$(...).text() 어떤 tag 내부에 있는 text를 getter하거나 setter하는 함수
				
				이 text함수는 일반 문자열로 모든 것을 취급하기 때문에 tag 속성을 적용해도 
				적용되지 않는다.
				
				tag의 속성(효과)를 부여하고 싶을 때는 html()이라는 함수를 사용한다.
			*/
			/*
			let s_cart = $("#s-cart").text()
			$("#s-cart").text(s_cart + p_string)
			*/
			let s_cart = $("#s-cart").html()
			$("#s-cart").html(s_cart + p_string)
			
			return false
			
			alert("선택한 상품은 \n "
					+ "상품코드 : " + p_ccode + "\n"
					+ "상품이름 : " + p_cname + "\n"
					+ "과세여부 : " + p_vat + "\n"
					+ "매입가격 : " + p_iprice + "\n"
					+ "판매가격 : " + p_oprice + "\n"
					+ " 입니다.")
					
			
		}) // $(.p-tr).click END
		
		// 읽을 데이터가 있는 영역과 다른 영역을 설정해서 버튼을 만들어줘야함
		$("#btn-total").click(function(){
			
			//버튼 클릭시 합계 계산
			
			var isum = 0
			var osum = 0
			
			/* ().each는 forEach와 원리가 비슷하다
			   .isum 클래스 개수만큼 자동 반복하면서 item에 각각 한개의 항목(select)들을
				저장해 준다
				item을 $(item)처럼 설정 그항목에서 text를 추출하고 숫자로 변환한 후 isum 변수에 누적한다.			
			*/
			$(".isum").each(function(index,item){
				isum += parseInt($(item).text())
			})
			
			$(".osum").each(function(index,item){
				osum += parseInt($(item).text())
			})
			
			alert("매입합계 : " + isum + "\n"
					+ "매출합계 : " + osum + "\n"
					+ "순이익합계 : " + (osum - isum))
			
		})
	})
</script>
</head>
<body>
<header>
	<h1>나라 Plus</h1>
</header>
<nav id="main-menu">
	<a href="#" class="menu-home">홈</a>
	<a href="#" class="menu-home">상품검색</a>
	<a href="#" class="menu-home">About</a>
	<button id="btn-total">합계</button>
</nav>
<section>
	<article id="p-List">
		<table class="w3-table-all">
		<tr>
			<th>NO</th>
			<th>상품코드</th>
			<th>상품이름</th>
			<th>과세여부</th>
			<th>매입단가</th>
			<th>판매단가</th>
		</tr>
			<c:choose>
				<c:when test="${empty PRODUCT}">
					<tr><td colspan=5>상품리스트가 없습니다.</td></tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${PRODUCT}" var="vo" varStatus="i">
						<tr data-p_ccode="${vo.p_ccode}" 
						data-p_cname="${vo.p_cname}" 
						data-p_vat="${vo.p_vat}"
						data-p_iprice="${vo.p_iprice}"
						data-p_oprice="${vo.p_oprice}"
						id="${i.index}" class="p-tr" >
							<td class="table-data">${i.count}</td>
							<td class="table-data">${vo.p_ccode}</td>
							<td class="table-data">${vo.p_cname}</td>
							<td class="table-data">
							<c:if test="${vo.p_vat == '1'}">과세</c:if>
							<c:if test="${vo.p_vat == '2'}">면세</c:if>
							</td>
							<td class="table-data">${vo.p_iprice}</td>
							<td class="table-data">${vo.p_oprice}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</article>
	<article id="s-cart">
		<button type="button" id="btn-total">합계</button>
	</article>
</section>
<footer><address>CopyRight &copy; juhoon12@nate.com</address></footer>
</body>
</html>