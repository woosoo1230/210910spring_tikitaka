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


  <div class="row g-5">
    <div class="col-md-12">
      <h3 class="pb-4 mb-4 fst-italic border-bottom">
        Post
      </h3>

      <article class="blog-post">
        <h2 class="blog-post-title mb-3">${board.subject }
        </h2>
        <p class="blog-post-meta text-muted text-end">${board.regdate } | 작성자 : ${member.nickname } | 조회수 : ${board.readnum } | 추천수 : ${board.recommend }
        <c:choose>
      	<c:when test="${isLogOn==true and not empty vo and vo.mno == member.mno}">
      	| <a href="${pageContext.request.contextPath}/board/updateBoard?bno=${board.bno }">수정</a> | <a href="${pageContext.request.contextPath}/board/deleteBoard?bno=${board.bno}" id="deleteBtn">삭제</a>
      	</c:when></c:choose>
        </p>
        <p class="mt-3 mb-5">${board.content }</p>
		<c:choose>
			<c:when test="${isLogOn==true and not empty vo and empty recommendlist}">
		        <p class="blog-post-meta text-muted text-center mt-5">
		        <a href="${pageContext.request.contextPath}/board/insertRecommend?bno=${board.bno }" class="btn btn-outline-secondary ">추천하기</a></p>
			</c:when>
			<c:when test="${isLogOn==true and not empty vo and not empty recommendlist}">
		        <p class="blog-post-meta text-muted text-center mt-5">
		        <a href="${pageContext.request.contextPath}/board/deleteRecommend?bno=${board.bno }" class="btn btn-outline-danger ">추천 취소하기</a></p>
			</c:when>
		</c:choose>        
        <hr>
		</article>
    </div>

		<article class="blog-post">
	        <h2 class="blog-post-title">Comments</h2>
	        <c:choose>
	        	<c:when test="${empty replylist }">
	        		<p>아직 댓글이 달리지 않았어요. 댓글을 남겨 대화에 참여해보세요!</p>
	        	</c:when>
	        	<c:otherwise>
	        		<c:forEach items="${replylist}" var="reply">
	        			<p class="blog-post-meta">${reply.replyregdate }</p>
	        			<p>${reply.replycontent }</p>
	        		</c:forEach>
	        	</c:otherwise>
	        </c:choose>
	    </article>
	    <hr>
	    <article class="blog-post">
	        <h2 class="blog-post-title">Reply</h2>
		        <form action="${pageContext.request.contextPath}/reply/insert" method="post">
				  <fieldset>
				    <div class="form-group">
				      <label for="exampleTextarea" class="form-label mt-4">내용</label>
				      <textarea class="form-control" id="exampleTextarea" rows="3" name="replycontent"></textarea>
				    </div>
				    <input type="hidden" value="${board.bno }" name="bno">
				    <input type="submit" class="btn btn-primary" value="작성">
				  </fieldset>
				</form>
	        
	    </article>
	    

  </div>

</main>
</div>
<%@include file="../common/footer.jsp" %>
</body>
</html>