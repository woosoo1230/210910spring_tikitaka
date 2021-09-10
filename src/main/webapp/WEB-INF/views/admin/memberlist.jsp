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
</head>
<body  class="pt-5">
<%@include file="../common/header.jsp" %>

<div class="container mt-5">
<div class="bs-docs-section">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-header">
              <h1 id="tables">Member List</h1>
            </div>

            <div class="bs-component">
              <table class="table table-hover">
                <thead>
                  <tr>
                  	<th scope="col">NO.</th>
                    <th scope="col">ID</th>
                    <th scope="col">NAME</th>
                    <th scope="col">NickName</th>
                    <th scope="col">State</th>
                  </tr>
                </thead>
                <tbody>
                <c:choose>
                	<c:when test="${empty memberlist}">
                		<tr>
		                    <th scope="row" colspan="5">아직 가입한 회원이 없습니다.</th>
		                  </tr>
                	</c:when>
                	<c:otherwise>
                		<c:forEach items="${memberlist}" var="memberVO" varStatus="status">
	                		<tr>
			                    <th scope="row">${status.count }</th>
			                    <td><a href="memberdetail?mno=${memberVO.mno}">${memberVO.mid }</a></td>
			                    <td>${memberVO.mname }</td>
			                    <td>${memberVO.nickname }</td>
			                    <td>${memberVO.mstate }</td>
			                </tr>
                		
                		</c:forEach>
                	</c:otherwise>
                </c:choose>
                  
                </tbody>
              </table>
            </div><!-- /example -->
          </div>
        </div>
      </div>
</div>


<%@include file="../common/footer.jsp" %>
</body>
</html>