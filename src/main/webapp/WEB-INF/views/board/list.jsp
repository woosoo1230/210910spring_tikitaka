<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="pt-5">
<%@include file="../common/header.jsp" %>

<div class="container pt-5">
<main class="container">
  <div class="p-4 p-md-5 mb-4 text-white rounded bg-dark">
    <div class="col-md-6 px-0">
      <h1 class="display-4 fst-italic">Tiki Taka</h1>
      <p class="lead my-3">사람들과 대화를 나누며 즐거움을 느껴보세요!</p>
      <!-- <p class="lead mb-0"><a href="#" class="text-white fw-bold">Continue reading...</a></p> -->
    </div>
  </div>

<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">NO.</th>
      <th scope="col">제목</th>
      <th scope="col">날짜</th>
      <th scope="col">조회수</th>
    </tr>
  </thead>
  <tbody>
  	<c:choose>
  		<c:when test="${empty list }">
	  		<tr>
		      <th scope="row" colspan="4">아직 작성된 게시글이 없습니다.</th>
		    </tr>
  		</c:when>
  		<c:otherwise>
  			<c:forEach items="${list }" var="board" varStatus="status">
	  			<tr>
			      <th scope="row">${status.count }</th>
			      <td><a href="detail?bno=${board.bno }">${board.subject }</a></td>
			      <td>${board.regdate }</td>
			      <td>${board.readnum }</td>
			    </tr>
  			</c:forEach>
  		</c:otherwise>
  	</c:choose>
    
  </tbody>
</table>

</main>
</div>
<%@include file="../common/footer.jsp" %>
</body>
</html>