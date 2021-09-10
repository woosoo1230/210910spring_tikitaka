<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/sandstone/bootstrap.min.css" integrity="sha384-zEpdAL7W11eTKeoBJK1g79kgl9qjP7g84KfK3AZsuonx38n8ad+f5ZgXtoSDxPOh" crossorigin="anonymous">


</head>
<body>
<header>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/index">TIKI TAKA</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor02">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link active" href="${pageContext.request.contextPath}/index">Home
            <span class="visually-hidden">(current)</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/board/list">Board</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/board/write">Write</a>
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
			       <a class="nav-link" href="${pageContext.request.contextPath}/logout">LOGOUT</a>
		        </li>
		        <li>
		        	<a class="nav-link" href="${pageContext.request.contextPath}/myinfo">${vo.mid }님</a>
		        </li>
		        <c:if test="${vo.mstate == 1 }">
		        <li>
		        	<a class="nav-link" href="${pageContext.request.contextPath}/memberlist">관리자</a>
		        </li>
		        </c:if>
		      </ul>
		      </span>
      	</c:when>
      	<c:otherwise>
	      	<span class="navbar-text">
		      <ul class="navbar-nav me-auto">
		        <li>
			       <a class="nav-link" href="${pageContext.request.contextPath}/login">LOGIN</a>
		        </li>
		        <li>
		        	<a class="nav-link" href="${pageContext.request.contextPath}/joinmember">SIGN UP</a>
		        </li>
		      </ul>
		      </span>
      	</c:otherwise>
      </c:choose>
      
      
       
    </div>
  </div>
</nav>
</header>
</body>
</html>