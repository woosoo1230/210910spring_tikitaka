<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/sandstone/bootstrap.min.css" integrity="sha384-zEpdAL7W11eTKeoBJK1g79kgl9qjP7g84KfK3AZsuonx38n8ad+f5ZgXtoSDxPOh" crossorigin="anonymous">
<style type="text/css">
  .img{
    position: relative;
    background-image: url(https://ifh.cc/g/m4J6k0.jpg);                                                               
    height: 100vh;
    background-size: cover;
  }

  .img-cover{
     position: absolute;
     height: 100%;
     width: 100%;
     background-color: rgba(0, 0, 0, 0.7);                                                                 
     z-index:1;
  }

  .img .content{
     position: absolute;
     top:50%;
     left:50%;
     transform: translate(-50%, -50%);                                                                   
     font-size:5rem;
     color: white;
     z-index: 2;
     text-align: center;
  }
</style>

</head>
<body  class="pt-5">
<header>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">TIKI TAKA</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor02">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link active" href="#">Home
            <span class="visually-hidden">(current)</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Features</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Pricing</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">About</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Dropdown</a>
          <div class="dropdown-menu">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <a class="dropdown-item" href="#">Something else here</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Separated link</a>
          </div>
        </li>
      </ul>
      <c:choose>
      	<c:when test="${isLogOn==true and not empty vo}">
	      	<span class="navbar-text">
		      <ul class="navbar-nav me-auto">
		        <li>
			       <a class="nav-link" href="logout">LOGOUT</a>
		        </li>
		        <li>
		        	<a target="_blank" rel="noopener" class="nav-link" href="#"><i class="fa fa-github"></i> ${vo.mid }님</a>
		        </li>
		      </ul>
		      </span>
      	</c:when>
      	<c:otherwise>
	      	<span class="navbar-text">
		      <ul class="navbar-nav me-auto">
		        <li>
			       <a class="nav-link" href="login">LOGIN</a>
		        </li>
		        <li>
		        	<a class="nav-link" href="joinmember">SIGN IN</a>
		        </li>
		      </ul>
		      </span>
      	</c:otherwise>
      </c:choose>
      
       
    </div>
  </div>
</nav>
</header>
<div class="container">
	<div class="img">
        <div class="content">
            <h1 class="">TIKI TAKA</h1>
            <h2>다양한 사람들과 재밌는 대화를 나눠보세요!</h2>
        </div>
        <div class="img-cover"></div>
    </div>
</div>

<div class="b-example-divider"></div>

<div class="container">
  <footer class="py-3 my-4">
    <ul class="nav justify-content-center border-bottom pb-3 mb-3">
      <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Home</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Features</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Pricing</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">FAQs</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">About</a></li>
    </ul>
    <p class="text-center text-muted">&copy; 2021 Company, Inc</p>
  </footer>
</div>


</body>
</html>