<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
	table {
		border-collapse: collapse;
		border-spacing: 0; /* td와 td간의 간격을 0으로 설정 */
		width: 100%;
		border: 1px solid #ccc;
	}
	
	th {
		background-color: lightgray;
	}
	
	tr {
		border-bottom: 1px solid #ddd;
	}
	
	/* tr의 각 요소들에 대한 세팅 */
	/* 홀수열과 짝수열의 배경색 설정 */
	tbody tr:nth-child(even) {
		background-color: #f1f1f1;
	}
	
	tbody tr:nth-child(odd) {
		background-color: #fff;
	}
	
	tbody tr:hover {
		background-color: #ccc;
	}
	
	th, td {
		padding: 8px;
		text-align: left;
		cursor: pointer;
	}
	
	th:first-child, td:first-child {
		padding-left: 16px;
	}
</style>
<script>
	$(function(){
		var deptList = Array() // javascript 배열 선언
		
		/*
			js 배열은 동적배열이므로 초기 생성 후 자유롭게 데이터를 추가 삭제가 가능함
			1. 배열 생성 : var 변수명 = Array()
			2. 배열 추가 : 변수명.push("추가값")
		*/
		
		$(".d-tr").on("click",function(){
			let dcode = $(this).attr("data-d-code")
			let dname = $(this).attr("data-d-name")
			let dceo = $(this).attr("data-d-ceo")
			
			// dcode, dname, dceo를 JSON 형식으로 만들어서 배열에 추가
			let json_data = {d_code:dcode, d_name:dname, d_ceo:dceo} 
			
			deptList.push(json_data)
			
			let s1 = ""
			
			deptList.forEach(function(item,index){
				s1 += item.d_name + "(" + item.d_code + ")" + "<br />"
			})
							
			$("#d-list").html(s1)
			
		})
		
		/*
			ajax로 배열을 보낼 때 data에 배열을 추가해서 변수명[] 처럼 보냄
			그것을 []을 빼고 변수명만 보내라는 설정
			
			$.ajaxSettings.traditional = true;
		*/
		$.ajaxSettings.traditional = true;
		
		$("#btn-send").click(function(){
			$.ajax({
				url:"${rootPath}/dept.json.array",
				method:"POST",
				traditional:true, // 배열을 보낼때 반드시 설정(위에서 설정해주면 안해도됌)
				//dataType:"JSON", // 서버에서 받을 때 JSON으로 받아라
				contentType:"application/json", // 서버로 보낼 때 JSON으로 보내라
				data:JSON.stringify(deptList), //  서버로 보내기 위해 데이터를 JSON형태로 변환
				success:function(result){
					alert(result)
				},
				error:function(){
					alert("서버와 통신오류!!")
				}
			})
		})
				
	})
</script>
<table>
	<tr>
		<th>NO</th>
		<th>거래처코드</th>
		<th>거래처명</th>
		<th>대표자명</th>
	</tr>
	<c:choose>
		<c:when test="${empty LIST}">
			<tr><td colspan=4>거래처 정보가 없습니다.</td></tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${LIST}" var="vo" varStatus="i">
				<tr class="d-tr" data-d-code="${vo.d_code}" 
								 data-d-name="${vo.d_name}" 
								 data-d-ceo="${vo.d_ceo}">
					<td>${i.count}</td>
					<td>${vo.d_code}</td>
					<td>${vo.d_name}</td>
					<td>${vo.d_ceo}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>