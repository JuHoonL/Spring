<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
 
  <meta name="viewport" content="width=device-width, initial-scale=1">


  <title>헬스</title>
  
  <style>
  
  .menubox1 {
  	height:360px;
  	width:640px;
  	background-image: url('${pageContext.request.contextPath}/img/health3.png') ;
  	background-repeat: no-repeat;
  	
  
  
  }
  
  
  </style>




  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sb-admin.css" />

</head>

<body id="page-top">


  <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="${pageContext.request.contextPath}/">헬스케어프로그램</a>
    
	<a class="btn btn-link btn-sm text-white ml-auto ml-md-0" 
	href="#" >
	로그인
    </a>
	<a class="btn btn-link btn-sm text-white ml-auto ml-md-0" 
	href="user_join" >
	회원가입
    </a>
     <a class="btn btn-link btn-sm text-white ml-auto ml-md-0" 
	href="food_select" >
	칼로리계산
    </a>
     <a class="btn btn-link btn-sm text-white ml-auto ml-md-0" 
	href="#" >
	다이어리
    </a>
   

  </nav>
  

  <div id="wrapper">

    <div id="content-wrapper">

      <div class="container-fluid" style>
		
		
		<!--  첫번째  -->
        <div class="row">
          <div class="col-xl-6 col-sm-6 mb-3">
            <div class="card text-white bg-custom1 o-hidden h-100">
              <div class="card-body menubox1">
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
         
          
          <!--  두번째 -->
          <div class="col-xl-6 col-sm-6 mb-3">
            <div class="card text-white bg-warning o-hidden h-100">
              <div class="card-body" style="height:300px;background-image: url('${pageContext.request.contextPath}/img/4.jpg')">
                <div class="card-body-icon">
                  <i class="fas fa-fw fa-list"></i>
                </div>
              </div>
              <a class="card-footer text-white clearfix small z-1 text-center" href="#">
              
                <span>다이어리</span>
                <span class="float-right">
                  <i class="fas fa-angle-right"></i>
                </span>
              </a>
            </div>
          </div>
        </div>
        
        <!--  세번째 -->
        <div class="row">
          <div class="col-xl-6 col-sm-6 mb-3">
            <div class="card text-white bg-primary o-hidden h-100">
              <div class="card-body">
                <div class="card-body-icon">
                  <i class="fas fa-fw fa-comments"></i>
                </div>
                <div class="mr-5 text-center" >"글씨"</div>
              </div>
            </div>
          </div>
          
          
          <!-- 네번째 -->
          <div class="col-xl-6 col-sm-6 mb-3">
            <div class="card text-white bg-secondary o-hidden h-100">
              <div class="card-body" style="height:500px;background-image: url('${pageContext.request.contextPath}/img/.jpg')">
                <div class="card-body-icon">
                  <i class="fas fa-fw fa-list"></i>
                </div>
              </div>
              <a class="card-footer text-white clearfix small z-1 text-center" href="#">
              
                <span>회원관리</span>
                <span class="float-right">
                  <i class="fas fa-angle-right"></i>
                </span>
              </a>
            </div>
          </div>
        </div>


      </div>
      
     </div>
     
     
     
     
     
   

	  
     <!--  푸터 -->
      <footer class="sticky-footer" >
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; </span>
          </div>
        </div>
      </footer>

    </div>
    



</body>

</html>
