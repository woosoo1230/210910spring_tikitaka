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
<%@include file="common/header.jsp" %>

<div class="container">
	<div class="img">
        <div class="content">
            <h1 class="">TIKI TAKA</h1>
            <h2>다양한 사람들과 재밌는 대화를 나눠보세요!</h2>
            <h2><a href="${pageContext.request.contextPath}/board/list">글 보러가기</a></h2>
        </div>
        <div class="img-cover"></div>
    </div>
</div>

<div class="b-example-divider"></div>


<%@include file="common/footer.jsp" %>

</body>
</html>