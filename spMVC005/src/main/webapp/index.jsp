<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
/* core tag lib를 import하고 /controller/book_list.jsp로 redirect하는 코드를 작성 */
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:redirect url="/controller/book_list.jsp"></c:redirect>
	<!-- 순수하게 redirect할 때에는 html코드가 없어도 된다. -->
