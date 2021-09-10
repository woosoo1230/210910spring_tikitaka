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
<script type="text/javascript">

function changeState(){
	//alert(document.getElementById("exampleSelect1").value);
	document.getElementById("mstate").value = document.getElementById("exampleSelect1").value;
}
</script>
</head>
<body  class="pt-5">
<%@include file="../common/header.jsp" %>

<div class="container mt-5">
<form action="updateState" method="post">
  <fieldset>
    <legend>Member Info</legend>
    <div class="form-group">
      <label for="exampleInputEmail1" class="form-label mt-4">ID</label>
      <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="${vo.mid }" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="exampleInputEmail1" class="form-label mt-4">NAME</label>
      <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="${vo.mname }" readonly="readonly">
    </div>
    <div class="form-group">
      <label for="exampleInputEmail1" class="form-label mt-4">NickName</label>
      <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="${vo.nickname }" readonly="readonly">
    </div>
    
    <div class="form-group">
      <label for="exampleSelect1" class="form-label mt-4">State</label>
      <select class="form-select" id="exampleSelect1" onchange="changeState();">
        <option selected="selected" disabled="disabled">${vo.mstate }</option>
        <option value="0">0</option>
        <option value="1">1</option>
        <option value="2">2</option>
      </select>
    </div>
    </fieldset>
    <input type="hidden" value="" id="mstate" name="mstate">
    <input type="hidden" value="${vo.mno }" id="mno" name="mno">
    <input type="submit" value="상태 수정하기" id="stateBtn" class="btn btn-secondary">
    <a class="btn btn-secondary" href="memberlist">뒤로 가기</a>
</form>


</div>


<%@include file="../common/footer.jsp" %>
</body>
</html>