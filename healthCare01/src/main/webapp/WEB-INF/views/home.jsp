<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
 
  <meta name="viewport" content="width=device-width, initial-scale=1">


  <title>헬스</title>
  <style>
  	#h4-h4 {
  		text-align: center;
  		color: red;
  	}
  </style>




  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sb-admin.css" />

</head>

<body id="page-top">

    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="${pageContext.request.contextPath}/">헬스케어프로그램</a>
     <div style ="text-align:right; width:100%;">
    <label style = "color:white;">Id</label> <input type ="text" style = "text-align:right; ">
    <label style = "color:white;">PassWord</label> <input type ="password" style = "text-align:right; ">
     
    
    
    </div>
	<a class="btn btn-link btn-sm text-white ml-auto " style = "width:100px;"
	href="user_DB" >
	로그인
    </a>
	<a class="btn btn-link btn-sm text-white"  style = "width:100px;"
	href="user_join" >
	회원가입
    </a>

    </nav>
	<section>
    <div id="wrapper">
	
      
      <ul class="sidebar navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="${pageContext.request.contextPath}/">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>메인</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="food_select">
            <i class="fas fa-fw fa-table"></i>
            <span>칼로리계산기</span></a>
        </li>
      </ul>

      <div id="content-wrapper" class="content-wrapper-bg">

        

         
          <ol class="breadcrumb">
            <li class="breadcrumb-item active"><h4>간단합니다. 흔들리면 그것은 지방입니다.</h4></li>
            
          </ol>
	
           <div class="row">
          
            <div class="card text-white bg-custom1 o-hidden h-100">
              <div class="card-body" style="height:700px; width: 1900px; background-image: url('${pageContext.request.contextPath}/img/maini.png')">
                <div class="card-body-icon">
                  <i class="fas fa-fw fa-comments"></i>
                </div>
              </div>

              <a class="card-footer text-white clearfix small z-1 text-center" href="food_select">
                <span>칼로리 계산</span>
                <span class="float-right">
                  <i class="fas fa-angle-right"></i>
                </span>
              </a>
            </div>
          </div>

      </div>
      
      <!--  푸터 -->
      <footer class="sticky-footer" >
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span></span>
          </div>
        </div>
      </footer>
          
     
      
      
 </div>


</section>
</body>

</html>
